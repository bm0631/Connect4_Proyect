package view;

import model.Game;

public class StartView extends GameView {

    StartView(Game game) {
        super(game);
    }

    void start() {
        OutPut.STARTGAME.writeln();
        game.start();
    }

}
