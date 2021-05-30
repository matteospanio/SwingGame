package gameClasses;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseMotionListener {

    private final Spaceship shooter;
    private final SpawnableMatrix<Spawnable> spawnable;

    public MouseListener(Spaceship g, SpawnableMatrix<Spawnable> s) {
        this.shooter = g;
        this.spawnable = s;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        shooter.shoot(spawnable);
        shooter.setPosition(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        shooter.setPosition(e.getX(), e.getY());
    }
}
