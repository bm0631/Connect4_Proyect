package view;

import model.Game;

public class AskNewGameView extends GameView {
    AskNewGameView(Game game){
        super(game);
    }
    boolean start(){
        Out.OTHERGAME.writeln();
        return new Input().readYesNo();
    
    }
   
}
