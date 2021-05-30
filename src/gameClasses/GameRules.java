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

    public void spawnAliens() {
        for (int i = 0; i < (int) (Math.random()*10 + 1) ; i++) {
            spawnables.add(new Alien((int)(Math.random() * 800), 10, (int) (2 * Math.random()) + 1));
        }
    }

    public void moveAll() {
        for (Spawnable s : spawnables) {
            s.move(s.getMvtOffset());
        }
    }

    public void drawAll(Graphics g){
        spawnables.removeIf((x) -> !(x.isVisible()));
        // TODO: remove debug purpose function
        spawnables.printDim();

        for (Spawnable s : spawnables) {
            s.draw(g);
        }
        spaceship.draw(g);
    }

    //TODO: sistema questo metodo, forse va nell'altra classe
    public void collisions() {
        spawnables.collisions();

        gameOver();
    }

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
