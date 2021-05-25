package gameClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardListener implements KeyListener {
    private Spaceship shooter;
    private GameRules game;
    
    public KeyboardListener(Spaceship g, GameRules game) {
        this.shooter = g;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                shooter.move(shooter.getMvtOffset());
                break;
            case KeyEvent.VK_LEFT:
                shooter.move(shooter.getMvtOffset() * -1);
                break;
            case KeyEvent.VK_SPACE:
                shooter.shoot(game);
                break;
            default:
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
