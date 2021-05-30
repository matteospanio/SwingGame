package runner;

import gameClasses.GameRules;
import gameClasses.KeyboardListener;
import gameClasses.MouseListener;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
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

        Timer a = new Timer(7000, e -> gameRules.spawnAliens());
        Timer t = new Timer(30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameRules.moveAll();
                gameRules.collisions();
                repaint();
            }
        });

        t.start();
        a.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("img/sky_night.png").getImage(), 0, 0, null);
        gameRules.drawAll(g);
    }
}
