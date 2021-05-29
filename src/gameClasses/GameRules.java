package gameClasses;

import java.awt.Graphics;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameRules {

    public final SpawnableMatrix<Spawnable> spawnables;
    public final Spaceship spaceship;



    public GameRules() {
        spaceship = new Spaceship(350, 640, 10);
        spawnables = new SpawnableMatrix<>();
    }

    public void spawnAliens() {
        for (int i = 0; i < 10; i++) {
            spawnables.add(new Alien((int)(Math.random() * 800), 200, 1));
        }
    }

    public void moveAll() {
        for (Spawnable s : spawnables) {
            s.move(s.getMvtOffset());
        }
    }

    public void drawAll(Graphics g){
        spawnables.removeIf(x -> !(x.isVisible()));

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
        /*for (Spawnable x : spawnables)
            spawnables.removeIf((y) -> y.hasCollided(x));*/
        gameOver();
        checkWin();
    }
    /*    for (int i = 0; i < aliens.size(); i++) {
            for (int j = 0; j < shots.size(); j++) {
                if (aliens.get(i).hasCollided(shots.get(j))) {
                    aliens.remove(i);
                    shots.remove(j);
                }
            }
        }*/
    
    private void gameOver() {
        for (Spawnable s : spawnables) {
            if (s instanceof Alien && spaceship.hasCollided(s)) {
                JFrame parent = new JFrame();
                parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(parent, "LOSER :P");
                System.exit(0);
            }
        }
    }
    
    private void checkWin() {
        if (spawnables.isAlienFree()) {
            JFrame parent = new JFrame();
            parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(parent, "Congrats, you won!");
            System.exit(0);
        }
    }
    

    
}
