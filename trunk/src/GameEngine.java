package src;

import java.awt.Component;
import java.awt.Window;

public class GameEngine {

	private DataStructure grid;
	private boolean current_player;
	private int currently_played;
	private GUI app;
	private int mode;
	private rules rule;
	private Player player1;
	private Player player2;
	int counter;

	@SuppressWarnings("deprecation")
	public GameEngine() {
		this.grid = new DataStructure(6, 7);
		this.current_player = false;
		rule = new Foor_in_a_row();
		app = new GUI_own(); // to change GUI
		app.initGui(grid);
		app.setSize(500, 550);
		app.setLocation(100, 100);
		app.show();
	}

	public void start(int my_mode) {
		this.mode = my_mode;
		counter = 0;
		player1 = new HumanPlayer();
		if (mode == 0) {
			player2 = new HumanPlayer();
			start(); // human vs human
		} else {
			player2 = new CpuPlayer(my_mode, rule);
			start();
		}
	}

	public void start() {

		while ((!rule.isComplete(grid))
				&& (counter < grid.getWidth() * grid.getHeight())) {
			if (!current_player) { // Player 1
				currently_played = player1.play(grid, app);
				if(currently_played==-2){
					reset_grid();
					continue;
				}
				while (!rule.check_play(currently_played, grid))
					currently_played = player1.play(grid, app);
			} else { // Player 2
				currently_played = player2.play(grid, app);
				if(currently_played==-2){
					reset_grid();
					current_player=!current_player;
					continue;
				}
				while (!rule.check_play(currently_played, grid))
					currently_played = player1.play(grid, app);
			}
			check_grid();
			rule.grey_out(app, grid);
			counter++;
		}
		if (rule.isComplete(grid))
			app.game_ended(!current_player);
		else
			app.game_ended();
	}

	public void reset_grid(){
		grid.reset_matrix();
		app.set_Reset(false);
		app.enable_all_button();
		app.updateScreen(grid);
		
	}
	
	public void check_grid() {
		if (rule.check_play(currently_played, grid)) {
			update_grid();
			current_player = !current_player;
			app.updateScreen(grid);
		} else {
			System.out.print("");
		}
	}
	
	private void update_grid() {
		int value = currently_played;
		int i = 0;
		boolean empty = true;

		while (i < grid.getHeight()) {
			if (grid.getValue(i, value) != 0) {
				empty = false;
				break;
			} else
				i++;
		}

		if (empty) {
			if (current_player == false)
				grid.setValue(grid.getHeight() - 1, value, 1);
			else
				grid.setValue(grid.getHeight() - 1, value, 2);
		} else {
			if (i != 0) {
				if (current_player == false)
					grid.setValue(i - 1, value, 1);
				else
					grid.setValue(i - 1, value, 2);
			}
		}

	}

	/*
	 * Unused method private ArrayList<Integer> playable() { int i;
	 * ArrayList<Integer> cols = new ArrayList<Integer>(); for (i = 0; i < 7;
	 * i++) { if (check_play(i)) cols.add(i); } return cols; }
	 */
}
