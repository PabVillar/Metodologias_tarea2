package model.handlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EquipItemHandler implements PropertyChangeListener {

    private GameController suscriber;

    public EquipItemHandler(GameController gameController) {
        this.suscriber = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

        suscriber.equipItem((Integer) propertyChangeEvent.getNewValue());

    }
}
