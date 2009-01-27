package src;

public interface GUI {

	// initialize GUI
	public abstract void initGui(DataStructure grid);

	// update window
	public abstract void updateScreen(DataStructure my_grid);

	// Game end with a winner
	public abstract void game_ended(boolean winner);

	// Game end with a draw
	public abstract void game_ended();

	// disable all button
	public abstract void grey_all_button();

	// enable all button
	public abstract void enable_all_button();

	// disable a button
	public abstract void grey_button(int num);

	// define window size
	public void setSize(int i, int j);

	// define window location
	public void setLocation(int i, int j);

	// it is a deprecated method, we don't have to implement it
	public void show();
	
	// return played variable
	public boolean get_Played();

	// return choice variable
	public int get_Choice();
	
	// set played variable 
	public void set_Played(boolean played);
	
	// return reset variable
	public boolean get_Reset();
	
	// set reset variable
	public void set_Reset(boolean reset);

	// we don't have to implement it.
	public abstract void dispose();
}
