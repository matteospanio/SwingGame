package gameClasses;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Predicate;

public class SpawnableMatrix<T extends Spawnable> implements Iterable<T> {

    private final List<T> aliens;
    private final List<T> shots;

    public SpawnableMatrix() {
        aliens = Collections.synchronizedList(new LinkedList<>());
        shots = Collections.synchronizedList(new LinkedList<>());
    }


    // TODO: rimuovi, funzione di debug
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

        // questa versione non funziona
        /*final Iterator<T> it1 = aliens.iterator();
        final Iterator<T> it2 = shots.iterator();

        while(it1.hasNext()) {
            while(it2.hasNext()) {
                T a = it1.next();
                T b = it2.next();
                if(a.hasCollided(b)) {
                    it1.remove();
                    it2.remove();
                }
            }
        }*/

        // questa da errore ma farebbe la cosa giusta
        /*for (int i = 0; i < aliens.size(); ++i) {
            for (int j = 0; j < shots.size(); ++j) {
                if (aliens.get(i).hasCollided((shots.get(j)))){
                    aliens.remove(i);
                    shots.remove(j);
                }
            }
        }*/

        // questa funziona, ma cancella più alieni in contemporanea
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
