package model.handlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class equipItemHandler implements PropertyChangeListener {

    private GameController suscriber;

    public equipItemHandler(GameController gameController) {
        this.suscriber = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

        suscriber.equipItem((int)propertyChangeEvent.getNewValue());

    }
}
