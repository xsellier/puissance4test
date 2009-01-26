package src;

public interface rules {

	public boolean check_diag(int i, int j, int color, DataStructure grid);

	public boolean check_col(int i, int j, int color, DataStructure grid);

	public boolean check_line(int i, int j, int color, DataStructure grid);

	public boolean isComplete(DataStructure grid);

	public boolean check_play(int play, DataStructure grid);

	public void grey_out(GUI app, DataStructure grid);
}
