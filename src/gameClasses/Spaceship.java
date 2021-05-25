package gameClasses;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Spaceship extends AbstractGameEntity {

    public Spaceship(int x, int y, int offset) {
        super(x, y, new ImageIcon("img/minispaceship.png").getImage(), offset);
    }

    @Override
    public void move(int offset) {
        x += offset;
    }

    public void shoot(GameRules g) {
        g.getElements().add(new Shot(this.getXCentre() - 24, this.getY(), -30));
    }

}
