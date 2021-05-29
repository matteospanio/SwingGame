package runner;

import gameClasses.GameRules;
import gameClasses.KeyboardListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GamePanel extends JPanel {
    
    private final GameRules gameRules;

    public GamePanel() {
        gameRules = new GameRules();
        
        setFocusable(true);
        requestFocusInWindow();
        
        KeyboardListener gameKeyListener = new KeyboardListener(gameRules.spaceship, gameRules.spawnables);
        addKeyListener(gameKeyListener);

        gameRules.spawnAliens();
        
        Timer t = new Timer(30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameRules.moveAll();
                gameRules.collisions();

                repaint();
            }
        });
        t.start();
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Image backgroundImage = new ImageIcon("img/sky_night.png").getImage();
        g.drawImage(backgroundImage, 0, 0, null);
        gameRules.drawAll(g);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }
}
