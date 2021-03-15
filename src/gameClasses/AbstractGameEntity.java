/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameClasses;

import java.awt.Image;

/**
 *
 * @author benny
 */
public abstract class AbstractGameEntity {
    
    protected int x;
    protected int y;
    protected Image image;
    
    public AbstractGameEntity(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }
    
    //setters and getters
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public Image getImage() {
        return image;
    }
    
    // return x of the centre of this game element
    protected int getXCentre(){
        return x + image.getWidth(null) / 2; 
    }
    
    // return y of the centre of this game element
    protected int getYCentre(){
        return y + image.getHeight(null) / 2; 
    }
    
    private int getRadius(){
        if(image.getWidth(null) < image.getHeight(null)){
            return image.getWidth(null) / 2; 
        }
        else{
            return image.getHeight(null) / 2;
        }
    }
    
    public abstract void move();
    
    public boolean collides(AbstractGameEntity ge){
        // if the distance between the two centres 
        // is less than the sum of the two radiuses
        if(Math.sqrt(Math.pow(getXCentre() - ge.getXCentre(), 2) +
                Math.pow(getYCentre() - ge.getYCentre(), 2)) < getRadius() + 
                ge.getRadius()){
            return true;
        }
        else{
            return false;
        }     
    }
    
}
