package gameClasses;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Collection;

public interface GameEntity {
    void move(int offset);
    boolean hasCollided(@NotNull GameEntity ge);
    boolean hasCollided(@NotNull Collection<? extends GameEntity> c);

    int getX();
    int getY();
    int getMvtOffset();
    Image getImage();
    int getXCentre();
    int getYCentre();
    int getRadius();

    void draw(Graphics g);

}
