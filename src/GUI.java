package src;

public interface GUI {

	public abstract void initGui(DataStructure grid);

	public abstract void updateScreen(DataStructure my_grid);

	public abstract void game_ended(boolean winner);

	public abstract void game_ended();

	public abstract void grey_all_button();

	public abstract void enable_all_button();

	public abstract void grey_button(int num);

	public void setSize(int i, int j);

	public void setLocation(int i, int j);

	public void show();
	
	public boolean get_Played();

	public int get_Choice();
	
	public void set_Played(boolean played);
	
	public boolean get_Reset();
	
	public void set_Reset(boolean reset);
}