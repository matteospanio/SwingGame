package gameClasses;

import javax.swing.*;


public class Shot extends AbstractGameEntity implements Spawnable {

    public boolean hasExpired = false;

    public Shot(int x, int y, int speed) {
        super(x, y, new ImageIcon("img/minishot.png").getImage(), speed);
    }

    @Override
    public void move(int offset) {
        y += getMvtOffset();
    }

    @Override
    public boolean isVisible() {
        return getY() > -100;
    }

    public void setHasExpired(boolean t) {
        this.hasExpired = t;
    }
    public boolean getHasExpired() {
        return this.hasExpired;
    }
}
