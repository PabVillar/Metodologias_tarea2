package controller.state;

import controller.GameController;
import model.Tactician;

public class GameState {
    Tactician tactician;
    GameController gameController = GameController.getInstance();

    public void playTurn(){};

    public void endTurn(){};

    public void setTactician(Tactician tactician){ this.tactician = tactician; }

    public void selectUnitIn(int x, int y){
    }

    public void equipItem(){}

    public void moveUnitTo(){}

    public void useItemOn(){}

    public void giveItemTo(){}

}
