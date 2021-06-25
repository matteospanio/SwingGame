package gameLogic;

import gameClasses.Spaceship;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseMotionListener {

    private final Spaceship shooter;
    private final SpawnableMatrix spawnable;

    public MouseListener(Spaceship g, SpawnableMatrix s) {
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
