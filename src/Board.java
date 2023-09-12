
public class Board {
	private final int numberOfRows = 6;
	private final int numberOfColumns = 7;
	private Token tokens[][];
	private View view;
	
	public Board(View view) {
		tokens = new Token[numberOfRows][numberOfColumns];
		this.view=view;
	}

	public void iniciateBoard() {
		for (int x = 0; x < numberOfColumns; x++) {
			for (int y = 0; y < numberOfRows; y++) {
				tokens[y][x] = Token.NULL_TOKEN;
			}
		}
	}

	public boolean isConnect4(Token tokenSeach) {
		boolean out = checkHorizontal(tokenSeach) || checkVertical(tokenSeach)
				   || checkAscendDiagonal(tokenSeach) || checkDescendDiagonal(tokenSeach);
		return out;
	}

	private boolean checkHorizontal(Token tokenSeach) {
		for (int i = 0; i < numberOfRows; i++) {
			if (checkRowHorizontal(i, tokenSeach)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkRowHorizontal(int idRow, Token tokenSeach) {
		for (int j = 0; j < numberOfColumns - 3; j++) {
			if (this.tokens[idRow][j] == tokenSeach && this.tokens[idRow][j + 1] == tokenSeach) {
				if (this.tokens[idRow][j + 2] == tokenSeach && this.tokens[idRow][j + 3] == tokenSeach) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkVertical(Token tokenSeach) {
		for (int i = 0; i < numberOfColumns; i++) {
			if (checkColumnVertical(i, tokenSeach)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumnVertical(int idColumn, Token tokenSeach) {
		for (int i = 0; i < numberOfRows - 3; i++) {
			if (this.tokens[i][idColumn] == tokenSeach && this.tokens[i + 1][idColumn] == tokenSeach) {
				if (this.tokens[i + 2][idColumn] == tokenSeach && this.tokens[i + 3][idColumn] == tokenSeach) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDescendDiagonal(Token tokenSeach) {
		for (int i = 3; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns - 3; j++) {
				if (this.tokens[i][j] == tokenSeach && this.tokens[i - 1][j + 1] == tokenSeach
						&& this.tokens[i - 2][j + 2] == tokenSeach && this.tokens[i - 3][j + 3] == tokenSeach)
					return true;
			}
		}
		return false;
	}

	private boolean checkAscendDiagonal(Token tokenSeach) {
		for (int i = 3; i < numberOfRows; i++) {
			for (int j = 3; j < numberOfColumns; j++) {
				if (this.tokens[i][j] == tokenSeach && this.tokens[i - 1][j - 1] == tokenSeach
						&& this.tokens[i - 2][j - 2] == tokenSeach && this.tokens[i - 3][j - 3] == tokenSeach)
					return true;
			}
		}
		return false;
	}

	public void put(int column, Token tokenToPut) throws Connect4Exception {
		if (column > numberOfColumns - 1 || column < 0) {
			throw new Connect4Exception("Out of range error ");
		}
		int row = firtsEmptyRow(column);
		tokens[row][column] = tokenToPut;
	}

	private int firtsEmptyRow(int column) throws Connect4Exception {
		for (int i = 0; i < numberOfRows; i++) {
			if (tokens[i][column].isNull()) {
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
			this.view.write(tokens[idRow][i].toString());
			this.view.write("|");
		}
	}
	private void  printBoardFooter() {
		for (int i = 0; i < numberOfColumns; i++) {
			this.view.write(i);
			this.view.write("|");
		}
	}

	public boolean isCompleted() {
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				if (tokens[i][j].isNull()) {
					return false;
				}
			}
		}
		return true;
	}
}
