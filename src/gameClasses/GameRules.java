package gameClasses;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameRules {
    private final List<GameEntity> elements = new GameMatrix<>();;

    public GameRules() {
        Spaceship shooter = new Spaceship(350, 640, 10);
        elements.add(shooter);
        
        for (int i = 0; i < 10; i++) {
            elements.add(new Alien((int)(Math.random() * 800)%100, 200, 1));
        }

    }

    public List<GameEntity> getElements() {
        return elements;
    }

    public Spaceship getGun() {
        return (Spaceship) elements.get(0);
    }

    // TODO: separare la navicella dal resto dell'array
    public void moveAll() {
        for (GameEntity el : elements) {
            if (el instanceof Spaceship)
                el.move(0);
            else
                el.move(el.getMvtOffset());
        }
    }

    // TODO: se separo la navicella rifare il metodo
    public void drawAll(Graphics g){
        // for each game element
        for(GameEntity el: elements){
            g.drawImage(el.getImage(), el.getX(), el.getY(), null);
        } 
    }

    //TODO: sistema questo metodo, forse va nell'altra classe
    public void collisions() {
        /* Iterator<GameEntity> it = elements.iterator();
        while (it.hasNext()) {

            it.next();
        } */
        for (int i = 0; i < elements.size(); i++) {
            for (int j = i + 1; j < elements.size(); j++) {
                if (elements.get(i).collides(elements.get(j))) {
                    if (elements.get(i) instanceof Alien && elements.get(j) instanceof Shot) {
                        elements.remove(j);
                        elements.remove(i);
                    } /*else if (pedine.get(i) instanceof Shot && pedine.get(i).getY() <= -1600) {
                        pedine.remove(i);
                    }*/else if (elements.get(i) instanceof Spaceship && elements.get(j) instanceof Alien) {
                        gameOver();
                    }
                    
                }
            }
        }

        // TODO: spostare il check?
        if (checkWin()) {
            JFrame parent = new JFrame();
            parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(parent, "Congrats, you won!");
            System.exit(0);
        }
    }
    
    public void gameOver() {
        JFrame parent = new JFrame();
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(parent, "LOSER :P");
        System.exit(0);
    }
    
    public boolean checkWin() {
        boolean flag = true;
        for (GameEntity ge : elements) {
            if (ge instanceof Alien)
                flag = false;
        }
        return flag;
    }
    

    
}
