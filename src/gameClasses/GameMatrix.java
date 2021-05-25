package gameClasses;

import jdk.jshell.spi.ExecutionControl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

public class GameMatrix<E extends GameEntity> extends ArrayList<E> {



    public void metodo() {
        for (E el: this) {
            el.getMvtOffset();
        }
    }

}
