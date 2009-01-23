package src;

public class CPU {

	private int mode;
	private DataStructure cpugrid;
	private int last_played;

	CPU(DataStructure grid, int difficulty) {
		cpugrid = grid;
		mode = difficulty;
	};

	int play(int played) {
		last_played = played;
		if (mode == 1)
			return easy_cpu();
		return perfect_cpu();
	}

	int easy_cpu() {
		for (int i = 1; i < 4; ++i) { // human attempt a column 3
			if (cpugrid.getValue(6 - i, last_played) == cpugrid.getValue(6 - (i + 1),
					last_played)
					&& cpugrid.getValue(6 - i, last_played) == cpugrid
							.getValue(6 - (i + 2), last_played)
					&& cpugrid.getValue(6 - (i + 3), last_played) == 0 && cpugrid.getValue(6 - i,last_played)!=0)
				return last_played;
		}
		if (last_played < 6 && last_played > 1) // human attempt a line 3
			for (int i = 1; i < 6; ++i) {
				if (cpugrid.getValue(6 - i, last_played-2) == cpugrid.getValue(6 - i, last_played-1) && cpugrid.getValue(6 - i, last_played-1) == cpugrid.getValue(6 - i, last_played) && cpugrid.getValue(6 - i, last_played+1)==0 && cpugrid.getValue(6-i, last_played) != 0)
					return last_played + 1;
			}
		if (last_played > 0 && last_played < 4) // human attempt a line 3
			for (int i = 1; i < 6; ++i) {
				if (cpugrid.getValue(6 - i, last_played+2) == cpugrid.getValue(6 - i, last_played+1) && cpugrid.getValue(6 - i, last_played+1) == cpugrid.getValue(6 - i, last_played) && cpugrid.getValue(6 - i, last_played-1)==0 && cpugrid.getValue(6-i, last_played) != 0)
					return last_played - 1;
			}
		
		for (int i = 1; i < 4; ++i) { // human attempt a column 2
			if (cpugrid.getValue(6 - i, last_played) == cpugrid.getValue(6 - (i + 1),
					last_played)
					&& cpugrid.getValue(6 - (i + 2), last_played) == 0 && cpugrid.getValue(6 - i,last_played)!=0)
				return last_played;
		}
		if (last_played < 6 && last_played > 1) // human attempt a line 2
			for (int i = 1; i < 6; ++i) {
				if (cpugrid.getValue(6 - i, last_played-1) == cpugrid.getValue(6 - i, last_played) && cpugrid.getValue(6 - i, last_played+1)==0 && cpugrid.getValue(6-i, last_played) != 0 && cpugrid.getValue(6 - (i+1), last_played+1)!=0)
					return last_played + 1;
			}
		if (last_played > 0 && last_played < 6) // human attempt a line 2
			for (int i = 1; i < 6; ++i) {
				if (cpugrid.getValue(6 - i, last_played+1) == cpugrid.getValue(6 - i, last_played) && cpugrid.getValue(6 - i, last_played-1)==0 && cpugrid.getValue(6-i, last_played) != 0 && cpugrid.getValue(6 - (i+1), last_played-1)!=0)
					return last_played - 1;
			}
		for(int i=0;i<7;++i)
			if (cpugrid.getValue(0, i) == 0)
				return i;
		return -1;
	}

	int perfect_cpu() {

		return 1;
	}
}
