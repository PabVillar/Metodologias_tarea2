package model.handlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelectItemHandler implements PropertyChangeListener {

    private GameController suscriber;

    public SelectItemHandler(final GameController suscriber){this.suscriber = suscriber;}

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        suscriber.selectItem((int)propertyChangeEvent.getNewValue());
    }
}
