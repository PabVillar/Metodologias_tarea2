package controller.state;

import controller.GameController;
import model.Tactician;
import model.units.IUnit;

public class PlayingTurnState extends GameState {

    @Override
    public void playTurn(){
        tactician = gameController.getTurnOwner();
        IUnit hero = tactician.getUnits().get(4);

        if (!hero.isActive()){
            tactician.setState(new EndTurnState());
            gameController.removeTactician(tactician.getName());
        }

    }

    @Override
    public void removeDefeatedUnit(IUnit unit){
        int index = tactician.getUnits().indexOf(unit);
        
    }

}
