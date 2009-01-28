package src;

public interface Rules {

	/*
	 * this interface define rules of 4 in a row
	 * but we can change these rules to another like tic tac toe
	 * if we change rule, you may change GUI and AI
	 */
	
	public boolean check_diag(int i, int j, int color, DataStructure grid);

	public boolean check_col(int i, int j, int color, DataStructure grid);

	public boolean check_line(int i, int j, int color, DataStructure grid);

	public boolean isComplete(DataStructure grid);

	public boolean check_play(int play, DataStructure grid);

	public void grey_out(GUI app, DataStructure grid);
}

