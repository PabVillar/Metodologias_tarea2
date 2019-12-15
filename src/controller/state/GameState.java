package controller.state;

import controller.GameController;
import model.Tactician;
import model.units.IUnit;

public class GameState {
    Tactician tactician;
    GameController gameController = GameController.getInstance();

    public void playTurn(){};

    public void endTurn(){};

    public void notPlayingTurn(){}

    public void setTactician(Tactician tactician){ this.tactician = tactician; }

    public void removeDefeatedUnit(IUnit unit){}

}
