package gameLogic;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class
GamePanel extends JPanel {
    
    private final GameRules gameRules;

    public GamePanel() {
        gameRules = new GameRules();
        
        setFocusable(true);
        requestFocusInWindow();

        // aggiungo i gestori per mouse e tastiera
        MouseMotionListener gameMouseListener = new MouseListener(gameRules.spaceship, gameRules.spawnables);
        KeyboardListener gameKeyListener = new KeyboardListener(gameRules.spaceship, gameRules.spawnables);
        addMouseMotionListener(gameMouseListener);
        addKeyListener(gameKeyListener);

        gameRules.spawnAliens();

        Timer a = new Timer(7000, e -> gameRules.spawnAliens());
        Timer t = new Timer(30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameRules.spawnables.collisions();
                gameRules.moveAll();
                gameRules.gameOver();
                repaint();
            }
        });

        // lancia tutti i thread
        t.start();
        a.start();
    }

    // questo metodo viene invocato dal repaint()
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("img/sky_night.png").getImage(), 0, 0, null);
        gameRules.drawAll(g);
    }
}
