package gameClasses;

import javax.swing.*;


public class Shot extends AbstractGameEntity {

    public Shot(int x, int y, int speed) {
        super(x, y, new ImageIcon("img/minishot.png").getImage(), speed);
    }

    public boolean hasCollided(GameEntity ge) {
        if (this.x == ge.getX() && this.y == ge.getY())
            return true;
        return false;
    }

    @Override
    public void move(int offset) {
        y += mvtOffset;
    }
}
