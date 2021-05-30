package gameClasses;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class SpawnableMatrix<T extends Spawnable> implements Iterable<T> {

    private final List<T> aliens;
    private final List<T> shots;

    public SpawnableMatrix() {
        aliens = new LinkedList<>();
        shots = new LinkedList<>();
    }

    public void printDim() {
        System.out.printf("aliens: %d\tshots: %d\n", aliens.size(), shots.size());
    }

    public void add(@NotNull T e) {
        if (e instanceof Alien) {
            aliens.add(e);
        }
        else {
            shots.add(e);
        }
    }

    public boolean isAlienFree() {
        return aliens.isEmpty();
    }

    //TODO: sistemare la concorrenza nella remove e evitare che si spacchi tutto
    public void removeIf(Predicate<?  super T> filter) {
        aliens.removeIf(filter);
        shots.removeIf(filter);
    }

    public void collisions() {
        for (Spawnable s : shots) {
            removeIf(f -> s.hasCollided(aliens));
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int pos = 0;
            private final int length = aliens.size() + shots.size();

            @Override
            public boolean hasNext() {
                return pos < length;
            }

            @Override
            public T next() {
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
