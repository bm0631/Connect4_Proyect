import java.util.Iterator;

public class Board {
	private final int numberOfRows = 6;
	private final int numberOfColumns = 7;
	private Token tokens[][];

	public Board() {
		tokens = new Token[numberOfRows][numberOfColumns];
	}

	public void iniciateBoard() {
		for (int x = 0; x < numberOfColumns; x++) {
			for (int y = 0; y < numberOfRows; y++) {
				tokens[y][x] = Token.NULL_TOKEN;
			}
		}
	}

	public boolean isConnect4(Token token) {
		boolean out = checkHorizontal(token) || checkVertical(token);
		out = out || checkAscendDiagonal(token) || checkDescendDiagonal(token);
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

	private boolean checkVertical(Token token) {
		return false;
	}

	private boolean checkAscendDiagonal(Token token) {
		return false;
	}

	private boolean checkDescendDiagonal(Token token) {
		return false;
	}

}
