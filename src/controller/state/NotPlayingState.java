package controller.state;

public class NotPlayingState extends GameState {

    @Override
    public void playTurn(){tactician.setState(new PlayingTurnState());}
}
