package view;

import utils.Console;

public class Input {

    private static Input instance = new Input();
    public static Object getInstance;
    
    public static Input getInstance() {
        return instance;
    }
    public int readInt(){
             int input = -1;
            try {
                input = Console.getInstance().readInt();
            } catch (Exception exception) {
                Out.ERROR_GENERAL.writeln();
                this.readInt();
            }
        
        return input;
    }
    public boolean readYesNo() {
            boolean input=false;
            try {
                input = Console.getInstance().readYesNo();
            } catch (Exception exception) {
                Out.ERROR_GENERAL.writeln();
                this.readYesNo();
            }
            
        return input;
    }

}
