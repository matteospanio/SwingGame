package gameClasses;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameRules {

    public final SpawnableMatrix<Spawnable> spawnables;
    public final Spaceship spaceship;

    public GameRules() {
        spaceship = new Spaceship(350, 640, 10);
        spawnables = new SpawnableMatrix<>();
    }

    public synchronized void spawnAliens() {
        for (int i = 0; i < (int) (Math.random()*10 + 1) ; i++) {
            spawnables.add(new Alien((int)(Math.random() * 800), 10, (int) (2 * Math.random()) + 1));
        }
    }

    public synchronized void moveAll() {
        spawnables.removeIf((x) -> !(x.isVisible()));
        for (Spawnable s : spawnables) {
            s.move(s.getMvtOffset());
        }
    }

    public synchronized void drawAll(Graphics g){
        spawnables.printDim();

        for (Spawnable s : spawnables) {
            s.draw(g);
        }
        spaceship.draw(g);
    }

    //TODO: sistema questo metodo, forse va nell'altra classe
    public synchronized void collisions() {
        /*List<Spawnable> alienList = spawnables.getAliens();
        List<Spawnable> shotList = spawnables.getShots();
        for (Spawnable a : alienList) {
            for (Spawnable s : shotList) {
                if (a.hasCollided(s)) {
                    alienList.remove(a);
                    shotList.remove(s);
                }
            }

        }*/
        spawnables.collisions();
        /*for (Spawnable x : spawnables)
            spawnables.removeIf((y) -> y.hasCollided(x));*/
        gameOver();
    }
    /*    for (int i = 0; i < aliens.size(); i++) {
            for (int j = 0; j < shots.size(); j++) {
                if (aliens.get(i).hasCollided(shots.get(j))) {
                    aliens.remove(i);
                    shots.remove(j);
                }
            }
        }*/

    private void newWindow(String message) {
        JFrame parent = new JFrame();
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(parent, message);
        System.exit(0);
    }

    private void gameOver() {
        for (Spawnable s : spawnables) {
            if (s instanceof Alien && spaceship.hasCollided(s)) {
                newWindow("LOSER :P");
            }
        }
        if (spawnables.isAlienFree()) {
            newWindow("Congrats, you won!");
        }
    }
}
