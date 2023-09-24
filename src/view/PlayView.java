package view;
import model.Game;
public class PlayView extends GameView{
    PlayView(Game game){
        super(game);
    }
    protected void start(){
        do{
            this.game.play();
            new BoardView(this.game).write();
            if (!game.isConnect4()){
                game.nextPlayer();
            }
        }while(!game.isEnd());
    }
}
