
public interface View {
	public void write(String string);
	public void write(int number);
	public void writeln(String string);
	public void writeln();
	public int readInt();
	public void writeError(String message);
}
