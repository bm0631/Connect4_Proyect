import model.Game;
import view.View;

class Connect4 {

    private Game game;
    private View view;

    public Connect4() {
        this.game=new Game();
        this.view= new View(this.game);
    }
    private void play(){
        do{
            this.view.start();
            this.view.play();
            this.view.end();
        }while(!this.view.askNewGame());
    }
    public static void main(String[] args) {
        new Connect4().play();
    }
}
