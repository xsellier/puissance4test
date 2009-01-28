package src;

public interface GUI {

	// initialize GUI
	public abstract void initGui(DataStructure grid);

	// update window
	public abstract void updateScreen(DataStructure my_grid);

	// Game end with a winner
	public abstract void gameEnded(boolean winner);

	// Game end with a draw
	public abstract void gameEnded();

	// disable all button
	public abstract void greyAllButton();

	// enable all button
	public abstract void enableAllButton();

	// disable a button
	public abstract void greyButton(int num);

	// define window size
	public void setSize(int i, int j);

	// define window location
	public void setLocation(int i, int j);

	// it is a deprecated method, we don't have to implement it
	public void show();
	
	// return played variable
	public boolean getPlayed();

	// return choice variable
	public int getChoice();
	
	// set played variable 
	public void setPlayed(boolean played);
	
	// return reset variable
	public boolean getReset();
	
	// set reset variable
	public void setReset(boolean reset);

	// we don't have to implement it.
	public abstract void dispose();
}
