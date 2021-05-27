package gameClasses;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;


public class GamePieces<E> extends ArrayList<E> {

    private final List<Alien> aliens;
    private final List<Shot> shots;

    public GamePieces() {
        aliens = new LinkedList<>();
        shots = new LinkedList<>();
    }

    public void spawnAlien(Alien a) {
        aliens.add(a);
    }

    public void shoot(Shot s) {
        shots.add(s);
    }

    /*public void collisions() {
        Iterator<Alien> alienIterator = aliens.iterator();
        Iterator<Shot> shotIterator = shots.iterator();
        while (alienIterator.hasNext()) {
            Alien a = alienIterator.next();
            while (shotIterator.hasNext()) {
                Shot s = shotIterator.next();
                if (a.collides(s)) {
                    alienIterator.remove();
                    shotIterator.remove();
                }
            }
        }
    }*/
}
