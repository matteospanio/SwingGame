package gameClasses;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameRules {

    public final Spaceship spaceship;
    //TODO sto facendo
    private final List<Alien> aliens;
    private final List<Shot> shots;

    public GameRules() {

        spaceship = new Spaceship(350, 640, 10);
        aliens = new LinkedList<>();
        shots = new LinkedList<>();

    }

    public void spawnAliens() {
        for (int i = 0; i < 10; i++) {
            aliens.add(new Alien((int)(Math.random() * 800), 200, 1));
        }
    }

    public List<Shot> getShots() {
        return shots;
    }

    public List<Alien> getAliens() {
        return aliens;
    }


    // TODO: separare la navicella dal resto dell'array
    public void moveAll() {
        for (GameEntity a : aliens) {
            a.move(a.getMvtOffset());
        }
        for (GameEntity s : shots) {
            s.move(s.getMvtOffset());
        }
    }

    public void drawAll(Graphics g){
        for(GameEntity a : aliens){
            a.draw(g);
        }
        for(GameEntity s : shots){
            s.draw(g);
        }
        spaceship.draw(g);
    }

    //TODO: sistema questo metodo, forse va nell'altra classe
    public void collisions() {
        for (int i = 0; i < aliens.size(); i++) {
            if (spaceship.collides(aliens.get(i)))
                gameOver();
            for (int j = 0; j < shots.size(); j++) {
                if (aliens.get(i).collides(shots.get(j))) {
                    aliens.remove(i);
                    shots.remove(j);
                }
                if (shots.get(j).getY() > 1000) {
                    shots.remove((j));
                }
            }
        }
        /*
        Iterator<Alien> alienIterator = aliens.iterator();
        Iterator<Shot> shotIterator = shots.iterator();
        while (alienIterator.hasNext()) {
            Alien a = alienIterator.next();
            if (spaceship.collides(a))
                gameOver();
            while (shotIterator.hasNext()) {
                Shot s = shotIterator.next();
                if (a.collides(s)) {
                    alienIterator.remove();
                    shotIterator.remove();
                }
            }
        }*/
        checkWin();
    }
    
    private void gameOver() {
        JFrame parent = new JFrame();
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(parent, "LOSER :P");
        System.exit(0);
    }
    
    private void checkWin() {
        if (aliens.isEmpty()) {
            JFrame parent = new JFrame();
            parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(parent, "Congrats, you won!");
            System.exit(0);
        }
    }
    

    
}
