package types;
public enum Token {
    X_TOKEN, O_TOKEN, NULL_TOKEN;

    public String toString() {
        switch (this) {
            case X_TOKEN: {
                return "X";
            }
            case O_TOKEN: {
                return "0";
            }
            case NULL_TOKEN: {
                return " ";
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + this);
        }
    }

    public boolean isNull() {
        return this == NULL_TOKEN;
    }
    public static Token getTokenIndex(int i){
         switch (i) {
            case 0: {
                return Token.X_TOKEN;
            }
            case 1: {
                return Token.O_TOKEN;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + i);
        }
    }
}
