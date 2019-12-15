package model.handlers;

import controller.GameController;
import model.map.Location;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MoveUnitToHandler implements PropertyChangeListener {

    private GameController suscriber;

    public MoveUnitToHandler(GameController gameController) {
        this.suscriber = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        Location targetCell = (Location)propertyChangeEvent.getNewValue();
        int x = targetCell.getColumn();
        int y = targetCell.getColumn();
        this.suscriber.moveUnitTo(x,y);

    }
}
