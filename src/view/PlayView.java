package view;
import model.Game;
import utils.Connect4Exception;
public class PlayView extends GameView{
    PlayView(Game game){
        super(game);
    }
     void start(){
        new BoardView(this.game).write();
        do{
            this.play();
            this.game.next();
            new BoardView(this.game).write();
        }while(!game.isEnd());
    }
    private void play() {
        Out.ASKCOLUMN.writeln();
        int column =new Input().readInt();
        try {
            this.game.put(column);
        } catch (Connect4Exception e) {
            if (e.getMessage().equals("Out of range error ")){
                Out.ERROR_RANGE.writeln();
                 this.play();
            }else{
                Out.ERROR_COLUMN_FULL.writeln();
            }
          
          
        }
    }
    
}
