package src;

public interface Rules {

	/*
	 * this interface define rules of 4 in a row
	 * but we can change these rules to another like tic tac toe
	 * if we change rule, you may change GUI and AI
	 */
	
	public boolean checkDiag(int i, int j, int color, DataStructure grid);

	public boolean checkCol(int i, int j, int color, DataStructure grid);

	public boolean checkLine(int i, int j, int color, DataStructure grid);

	public boolean isComplete(DataStructure grid);

	public boolean checkPlay(int play, DataStructure grid);

	public void greyOut(GUI app, DataStructure grid);
}

