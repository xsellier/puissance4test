package src;

public class IaFourInARow implements Cpu{

	private int mode;
	private DataStructure cpugrid;
	private int last_played;
	private int[] playable;
	/* for variable playable */
	/* 0 Playable */
	/* 1 Human wins */
	/* 2 Break strategy */
	/* 3 Cpu Wins */
	/* 4 no Playable */
	/* 5 Strategy */
	/* 6 Block human */

	private Rules rule;
	private int height;
	private int width;

	public void initialize(DataStructure grid, int difficulty) {
		cpugrid = grid;
		mode = difficulty;
		height = cpugrid.getHeight();
		width = cpugrid.getWidth();
	};

	public int play(int played, Rules new_rule) {
		last_played = played; // last_position played (by a human player)
		rule = new_rule;
		if (mode == 1) // easy mode
			return easyCpu();
		return perfectCpu(); // hard mode
	}

	public int easyCpu() {
		/* for variable result */
		/* -1 no choice */
		int result = -1;
		for (int i = 1; i < width - 3; ++i) { // human attempt a column 3
			if (cpugrid.getValue(height - i, last_played) == cpugrid.getValue(
					height - (i + 1), last_played)
					&& cpugrid.getValue(height - i, last_played) == cpugrid
							.getValue(height - (i + 2), last_played)
					&& cpugrid.getValue(height - (i + 3), last_played) == 0
					&& cpugrid.getValue(6 - i, last_played) != 0)
				result = last_played;
		}
		if (last_played < height && last_played > 1 && result == -1) // human
			// attempt
			// a line 3
			for (int i = 1; i < height; ++i) {
				if (last_played+1 < height && cpugrid.getValue(height - i, last_played - 2) == cpugrid
						.getValue(height - i, last_played - 1)
						&& cpugrid.getValue(height - i, last_played - 1) == cpugrid
								.getValue(height - i, last_played)
						&& cpugrid.getValue(height - i, last_played + 1) == 0
						&& cpugrid.getValue(height - i, last_played) != 0)
					result = last_played + 1;
			}
		if (last_played > 0 && last_played < width - 3 && result == -1) // human
			// attempt
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
			for (int i = 1; i < width - 3; ++i) { // human attempt a column 2
				if (cpugrid.getValue(height - i, last_played) == cpugrid
						.getValue(height - (i + 1), last_played)
						&& cpugrid.getValue(height - (i + 2), last_played) == 0
						&& cpugrid.getValue(height - i, last_played) != 0)
					result = last_played;
			}
		}
		if (result == -1) {
			if (last_played < height && last_played > 1) // human attempt a line
				// 2
				for (int i = 1; i < height; ++i) {
					if (last_played+1 < height && cpugrid.getValue(height - i, last_played - 1) == cpugrid
							.getValue(height - i, last_played)
							&& cpugrid.getValue(height - i, last_played + 1) == 0
							&& cpugrid.getValue(height - i, last_played) != 0)
						result = last_played + 1;
				}
		}
		if (result == -1) {
			if (last_played > 0 && last_played < height) // human attempt a line
				// 2
				for (int i = 1; i < height; ++i) {
					if (last_played+1 < height && cpugrid.getValue(height - i, last_played + 1) == cpugrid
							.getValue(height - i, last_played)
							&& cpugrid.getValue(height - i, last_played - 1) == 0
							&& cpugrid.getValue(height - i, last_played) != 0)
						result = last_played - 1;
				}
		}
		if (result == -1) { // to choose a position
							// it is a sequential choice
			for (int i = 0; i < width; ++i)
				if (cpugrid.getValue(0, i) == 0)
					result = i;
		}
		return result;
	}

	// for IA Hard
	
	private void fillPlayable() {
		for (int i = 0; i < width; ++i) {
			if (cpugrid.getValue(0, i) == 0)
				playable[i] = 0;
			else
				playable[i] = 4;
		}

	}

	// if Cpu can win at next token playable[i] = 3
	private void winningPlayable() {
		for (int i = width - 1; i >= 0; --i) { /* reach columns */
			for (int j = 0; j < height; ++j) { /* reach lines */
				if ((cpugrid.getValue(j, i) == 0 && j < height - 1 && cpugrid
						.getValue(j + 1, i) != 0)
						|| (cpugrid.getValue(j, i) == 0 && j == height - 1)) {

					cpugrid.setValue(j, i, 2);
					if (rule.checkDiag(j, i, 2, cpugrid) || rule.checkCol(j, i, 2, cpugrid)
							|| rule.checkLine(j, i, 2, cpugrid)) {
						playable[i] = 3;
					}
					cpugrid.setValue(j, i, 0);
				}
			}
		}
	}

	// if human can win at next token by cpu playing i (column) playable[i] = 1
	// if human can win at next token or with tow tokens playable[i] = 6
	private void noPlayable() {
		for (int i = width - 1; i >= 0; --i) { /* reach columns */
			for (int j = 0; j < height; ++j) { /* reach lines */
				if ((cpugrid.getValue(j, i) == 0 && j < height - 1 && cpugrid
						.getValue(j + 1, i) != 0)
						|| (cpugrid.getValue(j, i) == 0 && j == height - 1)) {
					cpugrid.setValue(j, i, 2);
					for (int k = width - 1; k >= 0; --k) { /* reach columns */
						for (int l = 0; l < height; ++l) { /* reach lines */
							if ((cpugrid.getValue(l, k) == 0 && l < height - 1 && cpugrid
									.getValue(l + 1, k) != 0)
									|| (cpugrid.getValue(l, k) == 0 && l == height - 1)) {
								cpugrid.setValue(l, k, 1);
								if ((rule.checkDiag(l, k, 1, cpugrid) || rule.checkCol(l, k, 1, cpugrid) || rule.checkLine(
										l, k, 1, cpugrid))
										&& playable[i] != 3) {
									playable[k] = 1;
								}
								cpugrid.setValue(l, k, 0);
							}
						}
					}
					cpugrid.setValue(j, i, 1);
					for (int k = width - 1; k >= 0; --k) { /* reach columns */
						for (int l = 0; l < height; ++l) { /* reach lines */
							if ((cpugrid.getValue(l, k) == 0 && l < height - 1 && cpugrid
									.getValue(l + 1, k) != 0)
									|| (cpugrid.getValue(l, k) == 0 && l == height - 1)) {
								cpugrid.setValue(l, k, 1);
								if ((rule.checkDiag(l, k, 1, cpugrid) || rule.checkCol(l, k, 1, cpugrid) || rule.checkLine(
										l, k, 1, cpugrid))
										&& playable[i] == 0) {
									playable[k] = 6;
									cpugrid.setValue(l, k, 0);
									cpugrid.setValue(j, i, 0);
									return;
								}
								cpugrid.setValue(l, k, 0);
							}
						}
					}
					if (rule.checkDiag(j, i, 1, cpugrid) || rule.checkCol(j, i, 1, cpugrid)
							|| rule.checkLine(j, i, 1, cpugrid))
						playable[i] = 6;
					cpugrid.setValue(j, i, 0);
				}
			}
		}
	}

	// if by playing column i human player can block a 3 in a row playable[i] = 2
	// because human will be able to break cpu strategy
	private void breakStrategy() {
		for (int i = width - 1; i >= 0; --i) { /* reach columns */
			for (int j = 0; j < height; ++j) { /* reach lines */
				if ((cpugrid.getValue(j, i) == 0 && j < height - 1 && cpugrid
						.getValue(j + 1, i) != 0)
						|| (cpugrid.getValue(j, i) == 0 && j == height - 1)) {
					cpugrid.setValue(j, i, 2);
					for (int k = width - 1; k >= 0; --k) { /* reach columns */
						for (int l = 0; l < height; ++l) { /* reach lines */
							if ((cpugrid.getValue(l, k) == 0 && l < height - 1 && cpugrid
									.getValue(l + 1, k) != 0)
									|| (cpugrid.getValue(l, k) == 0 && l == height - 1)) {
								cpugrid.setValue(l, k, 2);
								if ((rule.checkDiag(l, k, 2, cpugrid) || rule.checkLine(l, k, 2, cpugrid))
										&& playable[i] == 0) {
									playable[k] = 2;
								}
								cpugrid.setValue(l, k, 0);
							}
						}
					}
					cpugrid.setValue(j, i, 0);
				}
			}
		}
	}

	// look for token in line, in column or in diagonal and playable[i] = 5
	private void strategy(){
		for (int i = width - 1; i >= 0; --i) { /* reach columns */
			for (int j = 0; j < height; ++j) { /* reach lines */
				if ((cpugrid.getValue(j, i) == 0 && j < height - 1 && cpugrid
						.getValue(j + 1, i) != 0)
						|| (cpugrid.getValue(j, i) == 0 && j == height - 1)) {
					cpugrid.setValue(j, i, 2);
					for (int k = width - 1; k >= 0; --k) { /* reach columns */
						for (int l = 0; l < height; ++l) { /* reach lines */
							if ((cpugrid.getValue(l, k) == 0 && l < height - 1 && cpugrid
									.getValue(l + 1, k) != 0)
									|| (cpugrid.getValue(l, k) == 0 && l == height - 1)) {
								cpugrid.setValue(l, k, 2);
								if ((rule.checkDiag(l, k, 2, cpugrid) || rule.checkLine(l, k, 2, cpugrid))
										&& playable[i] == 0) {
									playable[i] = 5;
								}
								cpugrid.setValue(l, k, 0);
							}
						}
					}
					cpugrid.setValue(j, i, 0);
				}
			}
		}
	}

	// to optimize calculation
	public int perfectCpu() {
		playable = new int[width];
		int result = -1;
		fillPlayable();
		winningPlayable();
		for (int i = 0; i < width; ++i)
			if (playable[i] == 3) // Cpu can win with next token
				result = i;
		if (result == -1) { // No choice
			noPlayable();
			for (int i = 0; i < width; ++i)
				if (playable[i] == 6) // Human can win if Cpu doesn't play i
					result = i;
		}
		if (result == -1) { // No choice
			breakStrategy();
			strategy();
			for (int i = 0; i < width; ++i) {
				if (playable[i] == 5) // Cpu has a strategy
					result = i;
				// if game is blocked, playable doesn't contain any 3 or 5, Cpu plays where he can without make human win
				// Cpu will play at grid center (best probability to win)
				if (i < Math.round(width / 2) && playable[width / 2 + i] == 0 && result == -1)
					result = width / 2 + i;
				else if (i < Math.round(width / 2) && playable[width / 2 - i] == 0 && result == -1)
					result = width / 2 - i;
			}
		}
		if (result == -1) { // choose a border column
			for (int i = 0; i < width; ++i) {
				if (playable[i] == 0)
					result = i;
			}
		}
		if (result == -1) { // choose to break strategy
			for (int i = 0; i < width; ++i) {
				if (playable[i] == 2)
					result = i;
			}
		}
		if (result == -1) { // Cpu lost, but continue to play
			for (int i = 0; i < width; ++i) {
				if (playable[i] == 1)
					result = i;
			}
		}
		return result;
	}
}

