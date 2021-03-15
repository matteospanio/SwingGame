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
public class Shot extends AbstractGameEntity {
    private int mvt;

    public Shot(int x, int y, Image image, int mvt) {
        super(x, y, image);
        this.mvt = mvt;
    }
    
    @Override
    public void move() {
        setY(y + mvt);
    }
    
    public boolean hasCollided(AbstractGameEntity ge) {
        if (this.x == ge.getX() && this.y == ge.getY())
            return true;
        return false;
    }
    
}
