package runner;

import gameClasses.*;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.util.function.Predicate;
import javax.swing.*;

public class GamePanel extends JPanel {
    
    private final GameRules gameRules;

    public GamePanel() {
        gameRules = new GameRules();
        
        setFocusable(true);
        requestFocusInWindow();

        MouseMotionListener gameMouseListener = new MouseListener(gameRules.spaceship, gameRules.spawnables);
        KeyboardListener gameKeyListener = new KeyboardListener(gameRules.spaceship, gameRules.spawnables);
        addMouseMotionListener(gameMouseListener);
        addKeyListener(gameKeyListener);

        gameRules.spawnAliens();

        Timer c = new Timer(50, e -> gameRules.collisions());
        Timer a = new Timer(7000, e -> gameRules.spawnAliens());
        Timer t = new Timer(30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameRules.moveAll();
                repaint();
            }
        });

        c.start();
        t.start();
        a.start();

    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("img/sky_night.png").getImage(), 0, 0, null);
        gameRules.drawAll(g);
    }
}
