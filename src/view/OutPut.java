package view;

import types.Token;
import utils.Console;

public enum OutPut {
    STARTGAME("CONNECT 4 GAME"),
    WINGAME(", WIN GAME!!"),
    DRAWGAME("DRAW WELL PLAYED!!"),
    OTHERGAME("DO YOU WANT PLAY OTHER GAME? Y/N"),
    ASKCOLUMN(", Select a column to put a token:"),
    ERRORCOLUMN("THIS COLUMN IS FULL, TRY OTHER?"),
    COLUMN_SEPARATOR("|"),
    SPACE(" "),
    ERROR_RANGE("COLUMN OUT OF RANGE"),
    ERROR_COLUMN_FULL("THIS COLUMNS IS FULL"),
    ERROR_NUMBER("ERROR NUMBER, select other:"),
    ERROR_YES_NO("ERROR, only answer Y(YES) or N(NO):");

    private String out;

    OutPut(String out) {
        this.out = out;
    }

    public void write() {
        Console.getInstance().write(this.out);
    }

    public void writeln() {
        this.write();
        Console.getInstance().writeln();
    }
    public void writeln(Token actualPlayer) {
        assert (this == OutPut.ASKCOLUMN || this == OutPut.WINGAME);
        OutPut.writeCell(actualPlayer);
        Console.getInstance().write(this.out);
    }

    public static void writeCell(Token token) {
        Console.getInstance().write(token.toString());
    }

    public static void writeCell(int i) {
        Console.getInstance().write(i);
        OutPut.COLUMN_SEPARATOR.write();
    }

    public void writeWin(Token winner) {
       this.writeln(winner);
    }

}
