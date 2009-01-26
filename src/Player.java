package src;

public interface Player {

	public int play(int played, rules new_rule);
	
	public void initialize(DataStructure grid, int difficulty);
}
