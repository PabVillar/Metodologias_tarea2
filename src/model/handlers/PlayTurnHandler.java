package model.handlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayTurnHandler implements PropertyChangeListener {

    private GameController suscriber;

    public PlayTurnHandler(GameController gameController) {
        this.suscriber = suscriber;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }
}
