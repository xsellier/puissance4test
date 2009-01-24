package src;

public class Ia1 implements Cpu{

	private int mode;
	private DataStructure cpugrid;
	private int last_played;
	private int[] playable;
	/* 0 Playable */
	/* 1 Human wins */
	/* 2 Break strategy */
	/* 3 Cpu Wins */
	
	private int height; /* hauteur */
	private int width; /* largeur */
	
	public void initialize(DataStructure grid, int difficulty) {
		cpugrid = grid;
		mode = difficulty;
		height = cpugrid.getHeight();
		width = cpugrid.getWidth();
	};
	
	public int play(int played) {
		last_played = played;
		if (mode == 1)
			return easy_cpu();
		return perfect_cpu();
	}
	
	public int easy_cpu() {
		int result = -1;
		for (int i = 1; i < width-3; ++i) { // human attempt a column 3
			if (cpugrid.getValue(height - i, last_played) == cpugrid.getValue(
					height - (i + 1), last_played)
					&& cpugrid.getValue(height - i, last_played) == cpugrid
							.getValue(height - (i + 2), last_played)
					&& cpugrid.getValue(height - (i + 3), last_played) == 0
					&& cpugrid.getValue(6 - i, last_played) != 0)
				result = last_played;
		}
		if (last_played < height && last_played > 1 && result == -1) // human attempt
																// a line 3
			for (int i = 1; i < height; ++i) {
				if (cpugrid.getValue(height - i, last_played - 2) == cpugrid
						.getValue(height - i, last_played - 1)
						&& cpugrid.getValue(height - i, last_played - 1) == cpugrid
								.getValue(height - i, last_played)
						&& cpugrid.getValue(height - i, last_played + 1) == 0
						&& cpugrid.getValue(height - i, last_played) != 0)
					result = last_played + 1;
			}
		if (last_played > 0 && last_played < width-3 && result == -1) // human attempt
																// a line 3
			for (int i = 1; i < height; ++i) {
				if (cpugrid.getValue(height - i, last_played + 2) == cpugrid
						.getValue(height - i, last_played + 1)
						&& cpugrid.getValue(height - i, last_played + 1) == cpugrid
								.getValue(height - i, last_played)
						&& cpugrid.getValue(height - i, last_played - 1) == 0
						&& cpugrid.getValue(height - i, last_played) != 0)
					result = last_played - 1;
			}

		if (result == -1) {
			for (int i = 1; i < width-3; ++i) { // human attempt a column 2
				if (cpugrid.getValue(height - i, last_played) == cpugrid.getValue(
						height - (i + 1), last_played)
						&& cpugrid.getValue(height - (i + 2), last_played) == 0
						&& cpugrid.getValue(height - i, last_played) != 0)
					result = last_played;
			}
		}
		if (result == -1) {
			if (last_played < height && last_played > 1) // human attempt a line 2
				for (int i = 1; i < height; ++i) {
					if (cpugrid.getValue(height - i, last_played - 1) == cpugrid
							.getValue(height - i, last_played)
							&& cpugrid.getValue(height - i, last_played + 1) == 0
							&& cpugrid.getValue(height - i, last_played) != 0)
						result = last_played + 1;
				}
		}
		if (result == -1) {
			if (last_played > 0 && last_played < height) // human attempt a line 2
				for (int i = 1; i < height; ++i) {
					if (cpugrid.getValue(height - i, last_played + 1) == cpugrid
							.getValue(height - i, last_played)
							&& cpugrid.getValue(height - i, last_played - 1) == 0
							&& cpugrid.getValue(height - i, last_played) != 0)
						result = last_played - 1;
				}
		}
		if (result == -1) {
			for (int i = 0; i < width; ++i)
				if (cpugrid.getValue(0, i) == 0)
					result = i;
		}
		return result;
	}

	private void fill_playable(){
		for(int i=0; i < width; ++i)
			if(cpugrid.getValue(0, i)==0)
				playable[i]=0;
	}
	
	private void winning_playable(){
		
	}
	
	private void no_playable(){
		
	}
	
	public int perfect_cpu() {
		int result = -1;
		playable = new int[cpugrid.getWidth()];
		
		fill_playable();
				
		winning_playable();
				
		no_playable();
		
		
		return result;
	}
}
