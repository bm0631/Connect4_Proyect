package view;
import model.Game;
public class View extends GameView{
    private StartView startView;
    private PlayView playView;
   private EndView endView;
   private AskNewGameView askNewGameView;

    public View(Game game){
        super(game);
        this.startView    = new StartView(game);
        this.playView     = new PlayView(game);
        this.endView      = new EndView(game);
        this.askNewGameView =new AskNewGameView(game);
    }
    public void start(){
        startView.start();
    }
    public void play(){
       playView.start();
    }
    public void end(){
        endView.start();
    }
    public boolean askNewGame(){
      return askNewGameView.start();
    }


    
}
