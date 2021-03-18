/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author benny
 */
public class KeyboardListener implements KeyListener {
    private Gun shooter;
    private GameRules game;
    
    public KeyboardListener(Gun g, GameRules game) {
        this.shooter = g;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            shooter.moveRight();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            shooter.moveLeft();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            shooter.shoot(game);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }



    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
