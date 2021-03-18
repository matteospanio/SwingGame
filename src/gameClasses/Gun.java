/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameClasses;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author benny
 */
public class Gun extends AbstractGameEntity {
    private int mvt;
    private Image shotImg  = new ImageIcon("img/minishot.png").getImage();

    public Gun(int x, int y, Image image, int mvt) {
        super(x, y, image);
        this.mvt = mvt;
    }
    
    @Override
    public void move() {
    
    }
    
    public void moveLeft() {
        setX(x - mvt);
    }
    
    public void moveRight() {
        setX(x + mvt);
    }
    
    public void shoot(GameRules g) {
        g.addGameEntity(new Shot(this.getXCentre() - 24, this.getY(), shotImg, -30));
    }
}
