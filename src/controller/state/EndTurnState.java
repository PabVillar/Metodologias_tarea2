package controller.state;

public class EndTurnState extends GameState {

    @Override
    public void endTurn() {
        gameController.endTurn();
        tactician.setState(new NotPlayingState());
    }
}
