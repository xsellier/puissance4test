package src;

public class GameEngine {

	private DataStructure grid;
	private boolean current_player;
	private int currently_played;
	private GUI app;
	private int mode;
	/*
	 * mode contains 3 type 0 - Human vs Human 1 - Human vs Cpu Easy 2 - Human
	 * vs Cpu Hard
	 */
	private Rules rule;
	private Player player1;
	private Player player2;
	private int counter;

	/* start at 0 and top to grid.getHeight() grid.getWidth(); */

	public GameEngine() { // initialize game
		this.grid = new DataStructure(0, 0); // create a grid size 6*7
		this.current_player = false; // human player start
		rule = new FourInARow(); // define rule of the game, there 4 in a row
		app = new GUIOwn(); // create GUI, you can change this line to use
		// another GUI
		// app = new GUI_another_one();
		app.initGui(grid); // initialize GUI with grid
		app.setSize(500, 550);
		app.setLocation(100, 100);
		app.show();
	}

	public boolean initTestMode() { // to launch testing mode
		switch (mode){
		case 3:
			player1 = new HumanPlayer();
			player2 = new CpuPlayerTest(1, rule); 
			break;
		case 4:
			player1 = new HumanPlayer();
			player2 = new CpuPlayerTest(2, rule); 
			break;
		case 5:
			player1 = new CpuPlayerTest(1, rule); 
			player2 = new CpuPlayerTest(1, rule); 
			break;
		case 6:
			player1 = new CpuPlayerTest(1, rule); 
			player2 = new CpuPlayerTest(2, rule); 
			break;
		case 7:
			player1 = new CpuPlayerTest(2, rule); 
			player2 = new CpuPlayerTest(2, rule); 
			break;	
		}
		return true;
	}

	public boolean initMode(int my_mode) {
		this.mode = my_mode;
		counter = 0; // initialize counter
		if (mode > 2){
			initTestMode();
			return true;
		}
		else {
			player1 = new HumanPlayer(); // create a human player
			if (mode == 0) { // human vs human
				player2 = new HumanPlayer();
				return true;
			}
			if (mode == 1 || mode == 2) { // human vs cpu
				player2 = new CpuPlayer(my_mode, rule); // create a Cpu with
														// rule,
				// there 4 in a row
				return true;
			}
		}
		return false;
	}

	public void close() {
		app.dispose(); // make disappear GUI and close it
	}

	public void start() {

		while ((!rule.isComplete(grid))
				&& (counter < grid.getWidth() * grid.getHeight())) {
			if (!current_player) { // Player 1 plays
				currently_played = player1.play(grid, app);
				while (currently_played < 0
						&& currently_played >= grid.getWidth()
						&& currently_played != -2)
					currently_played = player1.play(grid, app);
				if (currently_played == -2) {
					resetGrid(); // reset grid xD
					continue;
				}
				while (!rule.checkPlay(currently_played, grid)) { // verify
					// currently_played
					// is an
					// available
					// position
					// on the
					// grid
					currently_played = player1.play(grid, app);
					if (currently_played == -2) {
						resetGrid(); // reset grid xD
						continue;
					}
				}

			} else { // Player 2 plays, can be a Cpu or an human
				currently_played = player2.play(grid, app);
				while (currently_played < 0
						&& currently_played >= grid.getWidth()
						&& currently_played != -2)
					currently_played = player2.play(grid, app);
				if (currently_played == -2) {
					resetGrid();
					current_player = !current_player; // change player to Player
					// 1 start
					continue;
				}
				while (!rule.checkPlay(currently_played, grid)) {
					currently_played = player2.play(grid, app);
					if (currently_played == -2) {
						resetGrid();
						current_player = !current_player; // change player to
						// Player 1 start
						continue;
					}
				}
			}
			updatePlay(); // validate grid
			rule.greyOut(app, grid); // if column is complete, grey out it
			// button
			counter++; // increment counter
		}
		if (rule.isComplete(grid))
			app.gameEnded(!current_player); // A player wins
		else
			app.gameEnded(); // it's a draw

	}

	public void resetGrid() {
		grid.reset_matrix(); // initialize grid to 0
		app.setReset(false);
		app.enableAllButton(); // columns are empty so enable buttons
		app.updateScreen(grid); // update screen ...
		counter = 0; // initialize counter
	}

	public void updatePlay() {
		if (rule.checkPlay(currently_played, grid)) { // validate player choice
			updateGrid();
			current_player = !current_player; // change player
			app.updateScreen(grid);
		} else {
			System.out.print("");
		}
	}

	private void updateGrid() {
		int value = currently_played;
		int i = 0;
		boolean empty = true;

		while (i < grid.getHeight()) { // initialize empty
			if (grid.getValue(i, value) != 0) {
				empty = false;
				break;
			} else
				i++;
		}

		if (empty) { // if column is empty
			if (current_player == false) // player 1
				grid.setValue(grid.getHeight() - 1, value, 1);
			else
				// player 2
				grid.setValue(grid.getHeight() - 1, value, 2);
		} else {
			if (i != 0) {
				if (current_player == false) // player 1
					grid.setValue(i - 1, value, 1);
				else
					// player 2
					grid.setValue(i - 1, value, 2);
			}
		}

	}

	public int getMode() {
		return mode;
	}

	public boolean getWinPlayer() {
		return current_player;
	}
	/*
	 * Unused method private ArrayList<Integer> playable() { int i;
	 * ArrayList<Integer> cols = new ArrayList<Integer>(); for (i = 0; i < 7;
	 * i++) { if (check_play(i)) cols.add(i); } return cols; }
	 */
}
