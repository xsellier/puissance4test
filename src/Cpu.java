package src;

public interface Cpu {

	/* 
	 * We make an interface to may change Cpu IA
	 * int play(...);
	 * initialize and makes play Cpu
	 * 
	 * void initialize(...)
	 * choose IA difficulty
	 */
	public int play(Rules new_rule);

	public void initialize(DataStructure grid, int difficulty);

	public int[] getPlayable();

	public int getHeight();
	
	public int getWidth();
	
	public int getMode();
	
	public DataStructure getCpuGrid();
	
	public void setPlayable(int i, int value);
}

