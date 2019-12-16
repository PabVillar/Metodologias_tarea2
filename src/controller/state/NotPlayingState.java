package controller.state;

public class NotPlayingState extends GameState {

    @Override
    public void playTurn(){tactician.setState(new PlayingTurnState());}

    @Override
    public void notPlayingTurn(){

        if (!tactician.getSelectedUnit().isActive()){
            gameController.removeDefeatedUnit(tactician.getSelectedUnit());
        }

        if (!tactician.getUnits().get(5).isActive()){
            tactician.setState(new EndTurnState());
            gameController.removeTactician(tactician.getName());
        }
    }
}
