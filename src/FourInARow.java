package src;

public class FourInARow implements Rules {

	// look for a 4 in a line
	public boolean checkLine(int i, int j, int color, DataStructure grid) {
		int count_left = 0;
		int count_right = 0;

		int real_j = j;
		if (j < 0 || i < 0 || i >= grid.getHeight() || j >= grid.getWidth()) {
			System.err
					.println("src.FourInARow.checkLine()\nWarning : invalid indice");
			return false;
		}
		if (j > 0) {
			j = real_j - 1;
			while ((j >= 0) && (j > (real_j - 4))
					&& (grid.getValue(i, j) == color)) {
				count_left++;
				j--;
			}
		}

		if (j < grid.getHeight()) {
			j = real_j + 1;
			while ((j < grid.getWidth()) && (j < (real_j + 4))
					&& (grid.getValue(i, j) == color)) {
				count_right++;
				j++;
			}
		}
		if ((count_left + count_right) >= 3)
			return true;
		return false;
	}

	// look for 4 in a column
	public boolean checkCol(int i, int j, int color, DataStructure grid) {
		int count_up = 0;
		int count_down = 0;

		int real_i = i;

		if (j < 0 || i < 0 || i >= grid.getHeight() || j >= grid.getWidth()) {
			System.err
					.println("src.FourInARow.checkCol()\nWarning : invalid indice");
			return false;
		}
		if (i > 0) {
			i = real_i - 1;
			while ((i >= 0) && (i > (real_i - 4))
					&& (grid.getValue(i, j) == color)) {
				count_down++;
				i--;
			}
		}
		if (i < (grid.getHeight() - 1)) {
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
	public boolean checkDiag(int i, int j, int color, DataStructure grid) {

		int count1 = 0;
		int count2 = 0;

		int real_i = i;
		int real_j = j;

		if (j < 0 || i < 0 || i >= grid.getHeight() || j >= grid.getWidth()) {
			System.err
					.println("src.FourInARow.checkDiag()\nWarning : invalid indice");
			return false;
		}
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

		if ((i < (grid.getHeight() - 1)) && (j < (grid.getWidth() - 1))) {
			i = real_i + 1;
			j = real_j + 1;
			while ((i < grid.getHeight()) && (i < (real_i + 4))
					&& (j < grid.getWidth()) && (j < (real_j + 4))
					&& (grid.getValue(i, j) == color)) {
				count2++;
				i++;
				j++;
			}
		}

		if ((count1 + count2) >= 3)
			return true;

		count1 = 0;
		count2 = 0;

		if ((i > 0) && (j < (grid.getWidth() - 1))) {
			i = real_i - 1;
			j = real_j + 1;
			while ((i >= 0) && (i > (real_i - 4)) && (j < grid.getWidth())
					&& (j < (real_j + 4)) && (grid.getValue(i, j) == color)) {
				count1++;
				i--;
				j++;
			}
		}

		if ((i < (grid.getHeight() - 1)) && (j > 0)) {
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
		for (int i = 0; i < grid.getHeight(); i++) {
			for (int j = 0; j < grid.getWidth(); j++) {
				color = grid.getValue(i, j);
				if (color != 0) {
					if (checkLine(i, j, color, grid))
						return true;
					if (checkCol(i, j, color, grid))
						return true;
					if (checkDiag(i, j, color, grid))
						return true;
				}
			}
		}
		return false;
	}

	// validate play into grid
	public boolean checkPlay(int play, DataStructure grid) {
		if (play >= 0 && play < grid.getWidth())
			if (grid.getValue(0, play) == 0)
				return true;
		System.err.println("src.FourInARow.checkPlay()\nWarning: invalid choice");
		return false;
	}

	// grey out a button if it column is full
	public void greyOut(GUI app, DataStructure grid) {
		int i;
		for (i = 0; i < grid.getWidth(); i++)
			if (grid.getValue(0, i) != 0)
				app.greyButton(i);
	}

}
