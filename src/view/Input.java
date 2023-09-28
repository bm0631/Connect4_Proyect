package view;

import utils.Console;

public class Input {

    public int readInt() {
        int input;
        do {
            input = -1;
            try {
                input = Console.getInstance().readInt();
            } catch (Exception exception) {
                OutPut.ERROR_NUMBER.writeln();
            }
        } while (input < 0);
        return input;
    }

    public boolean readYesNo() {
        boolean input = false;
        try {
            input = Console.getInstance().readYesNo();
        } catch (Exception exception) {
            OutPut.ERROR_YES_NO.writeln();
            this.readYesNo();
        }

        return input;
    }

}
