package model.handlers;

import controller.GameController;
import model.map.Location;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UseItemOnHandler implements PropertyChangeListener {

    private GameController suscriber;

    public UseItemOnHandler(GameController gameController) {
        this.suscriber = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        Location cell = (Location)propertyChangeEvent.getNewValue();
        int x = cell.getColumn();
        int y = cell.getRow();
        suscriber.useItemOn(x,y);

    }
}
