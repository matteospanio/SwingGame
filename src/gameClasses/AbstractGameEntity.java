package gameClasses;

import org.jetbrains.annotations.NotNull;
import java.awt.Image;


public abstract class AbstractGameEntity implements GameEntity {
    
    protected int x;
    protected int y;
    protected int mvtOffset;
    protected Image image;
    
    public AbstractGameEntity(int x, int y, @NotNull Image image, int offset) {
        this.x = x;
        this.y = y;
        this.mvtOffset = offset;
        this.image = image;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getMvtOffset() {
        return mvtOffset;
    }

    @NotNull
    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public int getXCentre(){
        return x + image.getWidth(null) / 2; 
    }

    @Override
    public int getYCentre(){
        return y + image.getHeight(null) / 2; 
    }

    @Override
    public int getRadius(){
        if(image.getWidth(null) < image.getHeight(null))
            return image.getWidth(null) / 2;
        return image.getHeight(null) / 2;
    }

    @Override
    public boolean collides(@NotNull GameEntity ge){
        // if the distance between the two centres 
        // is less than the sum of the two radiuses
        return Math.sqrt(Math.pow(getXCentre() - ge.getXCentre(), 2) +
                Math.pow(getYCentre() - ge.getYCentre(), 2)) < getRadius() +
                ge.getRadius();
    }
    
}
