package gameClasses;

import javax.swing.*;


public class Shot extends AbstractGameEntity implements Spawnable {

    public Shot(int x, int y, int speed) {
        super(x, y, new ImageIcon("img/minishot.png").getImage(), speed);
    }

    @Override
    public void move(int offset) {
        y += mvtOffset;
    }

    @Override
    public boolean isVisible() {
        return getY() < 1000;
    }
}
