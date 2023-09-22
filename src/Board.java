public class Board {
    private final int numberOfRows = 6;
    private final int numberOfColumns = 7;
    private Token tokens[][];
    private View view;

    public Board(View view) {
        this.tokens = new Token[numberOfRows][numberOfColumns];
        this.view = view;
    }

    public void setBoardAsClean() {
        for (int x = 0; x < numberOfColumns; x++) {
            for (int y = 0; y < numberOfRows; y++) {
                this.tokens[y][x] = Token.NULL_TOKEN;
            }
        }
    }

    public boolean isConnect4(Token tokenSeach) {
        /**boolean out = checkHorizontal(tokenSeach) || checkVertical(tokenSeach)
         || checkAscendDiagonal(tokenSeach) || checkDescendDiagonal(tokenSeach);
         return out;**/
        boolean isConnect4 = false;
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (tokenSeach == this.tokens[row][column]) {
                    isConnect4 = checkHorizontal(row, column, tokenSeach) || checkVertical(row, column, tokenSeach)
                            || checkAscendDiagonal(row, column, tokenSeach) || checkDescendDiagonal(row, column, tokenSeach);

                }
                if (isConnect4)
                    return isConnect4;
            }
        }
        return false;
    }

    private boolean checkHorizontal(int row, int column, Token tokenSeach) {
        if (column + 3 < numberOfColumns) {
            return tokenSeach == this.tokens[row][column + 1] &&
                    tokenSeach == this.tokens[row][column + 2] &&
                    tokenSeach == this.tokens[row][column + 3];
        } else {
            return false;
        }
    }

    private boolean checkVertical(int row, int column, Token tokenSeach) {
        if (row + 3 < numberOfRows) {
            return tokenSeach == this.tokens[row + 1][column] &&
                    tokenSeach == this.tokens[row + 2][column] &&
                    tokenSeach == this.tokens[row + 3][column];
        } else {
            return false;
        }
    }

    private boolean checkAscendDiagonal(int row, int column, Token tokenSeach) {
        if (row + 3 < numberOfRows && column + 3 < numberOfColumns) {
            return tokenSeach == this.tokens[row + 1][column + 1] &&
                    tokenSeach == this.tokens[row + 2][column + 2] &&
                    tokenSeach == this.tokens[row + 3][column + 3];
        } else {
            return false;
        }
    }

    private boolean checkDescendDiagonal(int row, int column, Token tokenSeach) {
        if (row + 3 < numberOfRows && column - 3 >= 0) {
            return tokenSeach == this.tokens[row + 1][column - 1] &&
                    tokenSeach == this.tokens[row + 2][column - 2] &&
                    tokenSeach == this.tokens[row + 3][column - 3];
        } else {
            return false;
        }
    }

    public void put(int column, Token tokenToPut) throws Connect4Exception {
        if (column > numberOfColumns - 1 || column < 0) {
            throw new Connect4Exception("Out of range error ");
        }
        int row = firtsEmptyRow(column);
        this.tokens[row][column] = tokenToPut;
    }

    private int firtsEmptyRow(int column) throws Connect4Exception {
        for (int i = 0; i < numberOfRows; i++) {
            if (this.tokens[i][column].isNull()) {
                return i;
            }
        }
        throw new Connect4Exception("Full Column");
    }

    public void printBoard() {
        this.view.writeln();

        printBoardRows();

        this.view.write("  ");

        printBoardFooter();

        this.view.writeln();
    }

    private void printBoardRows() {
        for (int i = numberOfRows - 1; i >= 0; i--) {
            this.view.write(i);
            this.view.write("|");
            printBoardRow(i);
            this.view.writeln();
        }
    }

    private void printBoardRow(int idRow) {
        for (int i = 0; i < numberOfColumns; i++) {
            this.view.write(this.tokens[idRow][i].toString());
            this.view.write("|");
        }
    }

    private void printBoardFooter() {
        for (int i = 0; i < numberOfColumns; i++) {
            this.view.write(i);
            this.view.write("|");
        }
    }

    public boolean isCompleted() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (this.tokens[i][j].isNull()) {
                    return false;
                }
            }
        }
        return true;
    }
}
