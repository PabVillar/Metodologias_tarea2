package controller.state;

import controller.GameController;
import model.Tactician;
import model.units.IUnit;

public class PlayingTurnState extends GameState {

    @Override
    public void playTurn(){
        tactician = gameController.getTurnOwner();
        IUnit hero = tactician.getUnits().get(4);

        if (!tactician.getSelectedUnit().isActive()){
            gameController.removeDefeatedUnit(tactician.getSelectedUnit());
        }

        if (!hero.isActive()){
            tactician.setState(new EndTurnState());
            gameController.removeTactician(tactician.getName());
        }

    }



}
