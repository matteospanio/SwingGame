/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameClasses;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author benny
 */
public class GameRules {
    private ArrayList<AbstractGameEntity> pedine = new ArrayList<AbstractGameEntity>();;
    private Image alien;
    private Image gun;
    private Image shot;
    
    public GameRules() {
        alien = new ImageIcon("img/alien_2.png").getImage();
        gun   = new ImageIcon("img/minispaceship.png").getImage();
        shot  = new ImageIcon("img/shot.png").getImage();
        
        Gun shooter = new Gun(350, 640, gun, 10);
        
        pedine.add(shooter);
        
        for (int i = 0; i < 10; i++) {
            pedine.add(new Alien((int)(Math.random() * 800)%100, 200, alien, 1));
        }
        
        
    }
    
    public Gun getGun() {
        return (Gun) pedine.get(0);
    }
    
    public void moveAll() {
        for (AbstractGameEntity x : pedine) {
            x.move();
        } 
    }
    
    public void drawAll(Graphics g){
        // for each game element
        for(AbstractGameEntity el: pedine){
            g.drawImage(el.getImage(), el.getX(), el.getY(), null);
        } 
    }
    
    public void crash() {
        for (int i = 0; i < pedine.size(); i++) {
            for (int j = i + 1; j < pedine.size(); j++) {
                if (pedine.get(i).collides(pedine.get(j))) {
                    if (pedine.get(i) instanceof Alien && pedine.get(j) instanceof Shot) {
                        pedine.remove(j);
                        pedine.remove(i);
                    } /*else if (pedine.get(i) instanceof Shot && pedine.get(i).getY() <= -1600) {
                        pedine.remove(i);
                    }*/else if (pedine.get(i) instanceof Gun && pedine.get(j) instanceof Alien) {
                        gameOver();
                    }
                    
                }
            }
        }
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
        for (AbstractGameEntity age : pedine) {
            if (age instanceof Alien)
                flag = false;
        }
        return flag;
    }
    
    public void addGameEntity(AbstractGameEntity gameEntity){
        pedine.add(gameEntity);
    }
    
}
