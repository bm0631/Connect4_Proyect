package view;
import types.Coordinate;
import utils.Console;
public enum Out {
    STARTGAME ("CONNECT 4 GAME"),
    WINGAME ("YOU WIN GAME"),
    DRAWGAME ("DRAW WELL PLAYED!!"),
    OTHERGAME("DO YOU WANT PLAY OTHER GAME? Y/N"),
    ASKCOLUMN ("Select a column to put a token:"),
    ERRORCOLUMN ("THIS COLUMN IS FULL, TRY OTHER?"),
    COLUMN_SEPARATOR("|");

    private String out;

    Out(String out){
        this.out=out;
    }
    public void writeln(){
        Console.getInstance().writeln(this.out);
    }
    public static void writeCell(Coordinate coordinate) {
    }
    
}
