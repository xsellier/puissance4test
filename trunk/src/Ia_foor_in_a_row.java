package src;

public class Ia_foor_in_a_row implements Cpu{

	private int mode;
	private DataStructure cpugrid;
	private int last_played;
	private int[] playable;
	private rules rule;
	private int height; /* hauteur */
	private int width; /* largeur */

	public void initialize(DataStructure grid, int difficulty) {
		cpugrid = grid;
		mode = difficulty;
		height = cpugrid.getHeight();
		width = cpugrid.getWidth();
	};

	public int play(int played, rules new_rule) {
		last_played = played;
		rule = new_rule;
		if (mode == 1)
			return easy_cpu();
		return perfect_cpu();
	}

	public int easy_cpu() {
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
		if (result == -1) {
			for (int i = 0; i < width; ++i)
				if (cpugrid.getValue(0, i) == 0)
					result = i;
		}
		return result;
	}

	private void fill_playable() {
		for (int i = 0; i < width; ++i) {
			if (cpugrid.getValue(0, i) == 0)
				playable[i] = 0;
			else
				playable[i] = 4;
		}

	}



	private void winning_playable() {
		for (int i = width - 1; i >= 0; --i) { /* reach columns */
			for (int j = 0; j < height; ++j) { /* reach lines */
				if ((cpugrid.getValue(j, i) == 0 && j < height - 1 && cpugrid
						.getValue(j + 1, i) != 0)
						|| (cpugrid.getValue(j, i) == 0 && j == height - 1)) {

					cpugrid.setValue(j, i, 2);
					if (rule.check_diag(j, i, 2, cpugrid) || rule.check_col(j, i, 2, cpugrid)
							|| rule.check_line(j, i, 2, cpugrid)) {
						playable[i] = 3;
					}
					cpugrid.setValue(j, i, 0);
				}
			}
		}
	}

	private void no_playable() {
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
								if ((rule.check_diag(l, k, 1, cpugrid) || rule.check_col(l, k, 1, cpugrid) || rule.check_line(
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
								if ((rule.check_diag(l, k, 1, cpugrid) || rule.check_col(l, k, 1, cpugrid) || rule.check_line(
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
					if (rule.check_diag(j, i, 1, cpugrid) || rule.check_col(j, i, 1, cpugrid)
							|| rule.check_line(j, i, 1, cpugrid))
						playable[i] = 6;
					cpugrid.setValue(j, i, 0);
				}
			}
		}
	}

	private void break_strategy() {
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
								if ((rule.check_diag(l, k, 2, cpugrid) || rule.check_line(l, k, 2, cpugrid))
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
								if ((rule.check_diag(l, k, 2, cpugrid) || rule.check_line(l, k, 2, cpugrid))
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

	/* for variable result */
	/* -1 no choice */

	/* for variable playable */
	/* 0 Playable */
	/* 1 Human wins */
	/* 2 Break strategy */
	/* 3 Cpu Wins */
	/* 4 no Playable */
	/* 5 Strategy TODO */
	/* 6 Block human */

	private int next_choice() {
		int result = -1;
		for (int i = 0; i < width; ++i)
			if (playable[i] == 3)
				result = i;
		if (result == -1) {
			for (int i = 0; i < width; ++i)
				if (playable[i] == 6)
					result = i;
		}
		if (result == -1) {
			for (int i = 0; i < width; ++i) {
				if (playable[i] == 5)
					result = i;
				if (i < Math.round(width / 2) && playable[width / 2 + i] == 0 && result == -1)
					result = width / 2 + i;
				else if (i < Math.round(width / 2) && playable[width / 2 - i] == 0 && result == -1)
					result = width / 2 - i;
			}
		}
		if (result == -1) {
			for (int i = 0; i < width; ++i) {
				if (playable[i] == 0)
					result = i;
			}
		}
		if (result == -1) {
			for (int i = 0; i < width; ++i) {
				if (playable[i] == 2)
					result = i;
			}
		}
		if (result == -1) {
			for (int i = 0; i < width; ++i) {
				if (playable[i] == 1)
					result = i;
			}
		}

		return result;
	}

	public int perfect_cpu() {
		int nb_pos = 0;
		int tmp_result = -1;
		int result = -1;
		playable = new int[width];

		fill_playable();

		for (int i = 0; i < width; ++i) {
			if (playable[i] != 4) {
				tmp_result = i;
				nb_pos++;
			}
		}

		if (nb_pos == 1 && result == -1)
			result = tmp_result;
		nb_pos = 0;
		tmp_result = -1;

		if (result == -1) {
			winning_playable();

			for (int i = 0; i < width; ++i)
				if (playable[i] == 3)
					result = i;
		}

		if (result == -1) {
			no_playable();
			for (int i = 0; i < width; ++i) {
				if (playable[i] != 4 && playable[i] != 1 && playable[i] != 2
						&& playable[i] != 6) {
					tmp_result = i;
					nb_pos++;
				}
				if (playable[i] == 6) {
					result = i;
				}
			}
			if (nb_pos == 1 && result == -1)
				result = tmp_result;
			nb_pos = 0;
			tmp_result = -1;
		}

		if (result == -1) {
			break_strategy();
			for (int i = 0; i < width; ++i) {
				if (playable[i] != 4 && playable[i] != 1 && playable[i] != 2
						&& playable[i] != 6) {
					tmp_result = i;
					nb_pos++;
				}
			}
			if (nb_pos == 1 && result == -1)
				result = tmp_result;
			nb_pos = 0;
			tmp_result = -1;
		}

		if (result == -1) {
			strategy();
			result = next_choice();
		}

		return result;
	}
}
