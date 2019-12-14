package model.handlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class selectItemHandler implements PropertyChangeListener {

    private GameController suscriber;

    public selectItemHandler(final GameController suscriber){this.suscriber = suscriber;}

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        suscriber.selectItem((int)propertyChangeEvent.getNewValue());
    }
}
