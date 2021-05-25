package gameClasses;

import org.jetbrains.annotations.NotNull;
import java.awt.Image;

public interface GameEntity {
    void move(int offset);
    boolean collides(@NotNull GameEntity ge);

    int getX();
    int getY();
    int getMvtOffset();
    Image getImage();
    int getXCentre();
    int getYCentre();
    int getRadius();

}
