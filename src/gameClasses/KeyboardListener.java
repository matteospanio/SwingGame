package gameClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardListener implements KeyListener {
    private final Spaceship shooter;
    private final SpawnableMatrix<Spawnable> spawnable;
    
    public KeyboardListener(Spaceship g, SpawnableMatrix<Spawnable> s) {
        this.shooter = g;
        this.spawnable = s;
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
                shooter.shoot(spawnable);
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
