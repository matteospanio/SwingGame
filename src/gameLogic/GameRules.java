package gameLogic;

import gameClasses.Alien;
import gameClasses.Spaceship;
import gameClasses.Spawnable;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameRules {

    public final SpawnableMatrix spawnables;
    public final Spaceship spaceship;

    public GameRules() {
        spaceship = new Spaceship(350, 640, 10);
        spawnables = new SpawnableMatrix();
    }

    public void spawnAliens() {
        for (int i = 0; i < (int) (Math.random()*10 + 1) ; i++) {
            spawnables.add(new Alien((int)(Math.random() * 800), 10, (int) (2 * Math.random()) + 1));
        }
    }

    public void moveAll() {
        spawnables.removeIf(s -> !s.isVisible());
        for (Spawnable s : spawnables) {
            s.move(s.getMvtOffset());
        }
    }

    public void drawAll(Graphics g) {
        for (Spawnable s : spawnables) {
            s.draw(g);
        }
        spaceship.draw(g);
    }

    private void newWindow(String message) {
        JFrame parent = new JFrame();
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(parent, message);
        System.exit(0);
    }

    public void gameOver() {
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
