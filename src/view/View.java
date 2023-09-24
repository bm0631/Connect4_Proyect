package view;
import model.Game;
public class View extends GameView{
    private StartView startView;
    private PlayView playView;
   // private EndView endView;

    public View(Game game){
        super(game);
        this.startView    = new StartView(game);
        this.playView     = new PlayView(game);
      //  this.endView      = new EndView(game);
    }
    public void start(){
        startView.start();
    }
    public void play(){
       playView.start();
    }
    public boolean newGame(){
        return false;
      //  endView.start();
    }

    
}
