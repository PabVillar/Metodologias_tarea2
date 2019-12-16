package controller.state;

import controller.GameController;
import model.Tactician;
import model.units.IUnit;

public class GameState {
    Tactician tactician;
    GameController gameController = GameController.getInstance();

    /**
     * The playing turn state
     */
    public void playTurn(){};

    /**
     * The end turn state
     */
    public void endTurn(){};

    /**
     * This state is set when the tactician is not the owner of the turn
     */
    public void notPlayingTurn(){}

    /**
     * Sets the tactician who changes the state of the game
     * @param tactician
     */
    public void setTactician(Tactician tactician){ this.tactician = tactician; }

    /**
     * Removes a unit when is defeated
     * @param unit
     *          the unit to be removed of the tactician's inventory
     */
    public void removeDefeatedUnit(IUnit unit){}

}
