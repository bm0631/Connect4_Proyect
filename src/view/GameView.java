package view;
import model.Game;
public abstract class GameView {
    protected Game game;
    
    protected GameView(Game game) {
        this.game=game;
    }
}
