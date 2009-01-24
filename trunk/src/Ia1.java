package src;

public class Ia1 implements Cpu{

	private int mode;
	private DataStructure cpugrid;
	private int last_played;
	
	public void initialize(DataStructure grid, int difficulty) {
		cpugrid = grid;
		mode = difficulty;
	};
	
	public int play(int played) {
		last_played = played;
		if (mode == 1)
			return easy_cpu();
		return perfect_cpu();
	}
	
	public int easy_cpu() {
		int result = -1;
		for (int i = 1; i < 4; ++i) { // human attempt a column 3
			if (cpugrid.getValue(6 - i, last_played) == cpugrid.getValue(
					6 - (i + 1), last_played)
					&& cpugrid.getValue(6 - i, last_played) == cpugrid
							.getValue(6 - (i + 2), last_played)
					&& cpugrid.getValue(6 - (i + 3), last_played) == 0
					&& cpugrid.getValue(6 - i, last_played) != 0)
				result = last_played;
		}
		if (last_played < 6 && last_played > 1 && result == -1) // human attempt
																// a line 3
			for (int i = 1; i < 6; ++i) {
				if (cpugrid.getValue(6 - i, last_played - 2) == cpugrid
						.getValue(6 - i, last_played - 1)
						&& cpugrid.getValue(6 - i, last_played - 1) == cpugrid
								.getValue(6 - i, last_played)
						&& cpugrid.getValue(6 - i, last_played + 1) == 0
						&& cpugrid.getValue(6 - i, last_played) != 0)
					result = last_played + 1;
			}
		if (last_played > 0 && last_played < 4 && result == -1) // human attempt
																// a line 3
			for (int i = 1; i < 6; ++i) {
				if (cpugrid.getValue(6 - i, last_played + 2) == cpugrid
						.getValue(6 - i, last_played + 1)
						&& cpugrid.getValue(6 - i, last_played + 1) == cpugrid
								.getValue(6 - i, last_played)
						&& cpugrid.getValue(6 - i, last_played - 1) == 0
						&& cpugrid.getValue(6 - i, last_played) != 0)
					result = last_played - 1;
			}

		if (result == -1) {
			for (int i = 1; i < 4; ++i) { // human attempt a column 2
				if (cpugrid.getValue(6 - i, last_played) == cpugrid.getValue(
						6 - (i + 1), last_played)
						&& cpugrid.getValue(6 - (i + 2), last_played) == 0
						&& cpugrid.getValue(6 - i, last_played) != 0)
					result = last_played;
			}
		}
		if (result == -1) {
			if (last_played < 6 && last_played > 1) // human attempt a line 2
				for (int i = 1; i < 6; ++i) {
					if (cpugrid.getValue(6 - i, last_played - 1) == cpugrid
							.getValue(6 - i, last_played)
							&& cpugrid.getValue(6 - i, last_played + 1) == 0
							&& cpugrid.getValue(6 - i, last_played) != 0)
						result = last_played + 1;
				}
		}
		if (result == -1) {
			if (last_played > 0 && last_played < 6) // human attempt a line 2
				for (int i = 1; i < 6; ++i) {
					if (cpugrid.getValue(6 - i, last_played + 1) == cpugrid
							.getValue(6 - i, last_played)
							&& cpugrid.getValue(6 - i, last_played - 1) == 0
							&& cpugrid.getValue(6 - i, last_played) != 0)
						result = last_played - 1;
				}
		}
		if (result == -1) {
			for (int i = 0; i < 7; ++i)
				if (cpugrid.getValue(0, i) == 0)
					result = i;
		}
		return result;
	}

	public int perfect_cpu() {
		int result = -1;
		
		return result;
	}
}
