package gameClasses;

import javax.swing.*;

public class Alien extends AbstractGameEntity implements Spawnable {
    
    public Alien(int x, int y, int speed) {
        super(x, y, new ImageIcon("img/alien_2.png").getImage(), speed);
    }

    @Override
    public void move(int offset) {
        //TODO
        /**
         * si devono muovere lateralmente
         * e quando raggiungono i bordi
         * shiftano in giù
         */
        this.y += getMvtOffset();
        this.x +=  (int)(5 * Math.sin((double)y/100))%100;
    }

    @Override
    public boolean isVisible() {
        return getY() > 0;
    }
    
}
