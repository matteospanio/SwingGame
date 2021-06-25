package gameClasses;

import gameLogic.SpawnableMatrix;

import javax.swing.ImageIcon;

public class Spaceship extends AbstractGameEntity {

    public Spaceship(int x, int y, int offset) {
        super(x, y, new ImageIcon("img/minispaceship.png").getImage(), offset);
    }

    @Override
    public void move(int offset) {
        x+=offset;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void shoot(SpawnableMatrix s) {
        s.add(new Shot(this.getXCentre() - 24, this.getY(), -30));
    }

}
