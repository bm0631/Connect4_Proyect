package view;

import model.Game;

public class EndView extends GameView {
    EndView(Game game) {
        super(game);
    }

    public void start() {
        if (game.isConnect4()) {
            OutPut.WINGAME.writeWin(game.getCurrentToken());
        } else {
            OutPut.DRAWGAME.writeln();
        }
    }
}
