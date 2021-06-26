package gameLogic;

import gameClasses.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Predicate;

public class SpawnableMatrix implements Iterable<Spawnable> {

    private final List<Alien> aliens;
    private final List<Shot> shots;

    public SpawnableMatrix() {
        aliens = new LinkedList<>();
        shots = new LinkedList<>();
    }

    // TODO: rimuovi, funzione di debug
    public void printDim() {
        synchronized (this) {
            for (Spawnable s : shots) {
                System.out.printf("id: %d\tX: %d\tY: %d\n", s.hashCode(), s.getX(), s.getY());
            }
            System.out.printf("aliens: %d\tshots: %d\n", aliens.size(), shots.size());
        }
    }

    public void add(@NotNull Spawnable e) {
        if (e instanceof Alien) {
            aliens.add( (Alien) e);
        }
        else {
            shots.add( (Shot) e);
        }
    }

    public boolean isAlienFree() {
        return aliens.isEmpty();
    }

    public void removeIf(Predicate<? super Spawnable> filter) {
        aliens.removeIf(filter);
        shots.removeIf(filter);
    }

    //TODO: dovrebbe eliminare anche i proiettili dopo che hanno colpito...
    public void collisions() {
        for (Shot s : shots) {
            if (aliens.removeIf(a -> a.hasCollided(s)))
                s.setHasExpired(true);
        }
        shots.removeIf(Shot::getHasExpired);
    }

    @NotNull
    @Override
    public Iterator<Spawnable> iterator() {
        return new Iterator<>() {
            private int pos = 0;
            private final int length = aliens.size() + shots.size();

            @Override
            public boolean hasNext() {
                return pos < length;
            }

            @Override
            public Spawnable next() {
                if (pos < aliens.size())
                    return aliens.get(pos++);
                else {
                    int x = pos - aliens.size();
                    pos++;
                    return shots.get(x);
                }
            }
        };
    }
}
