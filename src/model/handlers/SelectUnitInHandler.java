package model.handlers;

import controller.GameController;
import model.map.Location;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelectUnitInHandler implements PropertyChangeListener {

    private GameController suscriber;

    public SelectUnitInHandler(final GameController suscriber){this.suscriber = suscriber;}

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        Location cell = (Location) propertyChangeEvent.getNewValue();
        int x = cell.getColumn();
        int y = cell.getRow();
        suscriber.selectUnitIn(x,y);
    }
}
