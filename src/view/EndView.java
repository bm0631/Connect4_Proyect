package view;

import model.Game;

public class EndView extends GameView{
    EndView(Game game){
        super(game);
    }
    public void start(){
        if (game.isConnect4()){
            Out.WINGAME.writeWin(game.getCurrentToken());
        }else{
            Out.DRAWGAME.writeln();
        }
    }
}
