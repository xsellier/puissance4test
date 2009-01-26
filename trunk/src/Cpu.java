package src;

public interface Cpu {

	public int play(int played, rules new_rule);
	
	public void initialize(DataStructure grid, int difficulty);
	
	public int easy_cpu();
	
	public int perfect_cpu();
	
}
