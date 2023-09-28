package view;

import model.Game;

public class AskNewGameView extends GameView {
    AskNewGameView(Game game) {
        super(game);
    }

    boolean start() {
        OutPut.OTHERGAME.writeln();
        return new Input().readYesNo();

    }

}
