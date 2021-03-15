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
public class Alien extends AbstractGameEntity {
    private int mvt;
    
    public Alien(int x, int y, Image image, int mvt) {
        super(x, y, image);
        this.mvt = mvt;
    }

    @Override
    public void move() {
        //TODO
        /**
         * si devono muovere lateralmente
         * e quando raggiungono i bordi
         * shiftano in giù
         */
        setY(getY() + mvt);
        setX(x + (int)(5 * Math.sin((double)y/100)));
    }
    
}
