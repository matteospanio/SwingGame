package runner;

import gameClasses.GameRules;
import gameClasses.KeyboardListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class GamePanel extends javax.swing.JPanel {
    
    private GameRules gameRules;
    private Image backgroundImage;
    /**
     * Creates new form GamePanel
     */
    public GamePanel() {
        
        backgroundImage = new ImageIcon("img/sky_night.png").getImage();
        gameRules = new GameRules();
        
        setFocusable(true);
        requestFocusInWindow();
        
        KeyboardListener gameKeyListener = new KeyboardListener(gameRules.getGun(), gameRules);
        addKeyListener(gameKeyListener);
        
        Timer t = new Timer(60, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameRules.moveAll();
                gameRules.collisions();

                //call paintComponent()
                repaint();
            }
        });
        t.start();
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
        gameRules.drawAll(g);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }
}
