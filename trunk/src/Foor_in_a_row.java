package src;

public class Foor_in_a_row implements rules{

	// look for a 4 in a line
	public boolean check_line(int i, int j, int color, DataStructure grid) {
		int count_left = 0;
		int count_right = 0;

		int real_j = j;

		if (j > 0) {
			j = real_j - 1;
			while ((j >= 0) && (j > (real_j - 4))
					&& (grid.getValue(i, j) == color)) {
				count_left++;
				j--;
			}
		}

		if (j < 6) {
			j = real_j + 1;
			while ((j < grid.getWidth()) && (j < (real_j + 4))
					&& (grid.getValue(i, j) == color)) {
				count_right++;
				j++;
			}
		}
		if ((count_left + count_right) >= 3)
			return true;
		else
			return false;
	}

	// look for 4 in a column
	public boolean check_col(int i, int j, int color, DataStructure grid) {
		int count_up = 0;
		int count_down = 0;

		int real_i = i;

		if (i > 0) {
			i = real_i - 1;
			while ((i >= 0) && (i > (real_i - 4))
					&& (grid.getValue(i, j) == color)) {
				count_down++;
				i--;
			}
		}
		if (i < (grid.getHeight()-1)) {
			i = real_i + 1;
			while ((i < grid.getHeight()) && (i < (real_i + 4))
					&& (grid.getValue(i, j) == color)) {
				count_up++;
				i++;
			}
		}

		if ((count_up + count_down) >= 3)
			return true;
		else
			return false;

	}

	// look for 4 in a diagonal
	public boolean check_diag(int i, int j, int color, DataStructure grid) {

		int count1 = 0;
		int count2 = 0;

		int real_i = i;
		int real_j = j;

		if ((i > 0) && (j > 0)) {
			i = real_i - 1;
			j = real_j - 1;
			while ((i >= 0) && (i > (real_i - 4)) && (j >= 0)
					&& (j > (real_j - 4)) && (grid.getValue(i, j) == color)) {
				count1++;
				i--;
				j--;
			}
		}

		if ((i < (grid.getHeight()-1)) && (j < (grid.getWidth()-1))) {
			i = real_i + 1;
			j = real_j + 1;
			while ((i < grid.getHeight()) && (i < (real_i + 4)) && (j < grid.getWidth())
					&& (j < (real_j + 4)) && (grid.getValue(i, j) == color)) {
				count2++;
				i++;
				j++;
			}
		}

		if ((count1 + count2) >= 3)
			return true;

		count1 = 0;
		count2 = 0;

		if ((i > 0) && (j < (grid.getWidth()-1))) {
			i = real_i - 1;
			j = real_j + 1;
			while ((i >= 0) && (i > (real_i - 4)) && (j < grid.getWidth())
					&& (j < (real_j + 4)) && (grid.getValue(i, j) == color)) {
				count1++;
				i--;
				j++;
			}
		}

		if ((i < (grid.getHeight()-1)) && (j > 0)) {
			i = real_i + 1;
			j = real_j - 1;
			while ((i < grid.getHeight()) && (i < (real_i + 4)) && (j >= 0)
					&& (j >= (real_j - 4)) && (grid.getValue(i, j) == color)) {
				count2++;
				i++;
				j--;
			}
		}

		if ((count1 + count2) >= 3)
			return true;

		return false;
	}

	// verify grid complete by a victory
	public boolean isComplete(DataStructure grid) {
		int color;
		int i, j;
		for (i = 0; i < grid.getHeight(); i++) {
			for (j = 0; j < grid.getWidth(); j++) {
				color = grid.getValue(i, j);
				if (color != 0) {
					if (check_line(i, j, color, grid))
						return true;
					if (check_col(i, j, color, grid))
						return true;
					if (check_diag(i, j, color, grid))
						return true;
				}
			}
		}
		return false;
	}

	// validate play into grid
	public boolean check_play(int play, DataStructure grid){
		if (grid.getValue(0, play) == 0)
			return true;
		if(play>=0 && play < grid.getWidth())
			return true;
		return false;
	}

	// grey out a button if it column is full
	public void grey_out(GUI app, DataStructure grid) {
		int i;
		for (i = 0; i < grid.getWidth(); i++)
			if (grid.getValue(0, i) != 0)
				app.grey_button(i);
	}

}

