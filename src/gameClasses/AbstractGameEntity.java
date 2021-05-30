package gameClasses;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Collection;


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
    public void draw(Graphics g) {
        g.drawImage(this.getImage(), this.getX(), this.getY(), null);
    }

    @Override
    public boolean hasCollided(@NotNull GameEntity ge){
        return Math.sqrt(Math.pow(getXCentre() - ge.getXCentre(), 2) +
                Math.pow(getYCentre() - ge.getYCentre(), 2)) < getRadius() +
                ge.getRadius();
    }

    public boolean hasCollided(@NotNull Collection<? extends GameEntity> c) {
        for (GameEntity g : c) {
            if (this.hasCollided(g)) {
                return true;
            }
        }
        return false;
    }
    
}
