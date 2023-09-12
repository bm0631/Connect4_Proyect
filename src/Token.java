
public enum Token {
	X_TOKEN,O_TOKEN,NULL_TOKEN;
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
}	
