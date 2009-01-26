package src;

public class GameEngine {

	private DataStructure grid;
	private boolean current_player;
	private int currently_played;
	private GUI app;
	private int mode;
	private rules rule;
	int counter;

	@SuppressWarnings("deprecation")
	public GameEngine() {
		this.grid = new DataStructure(6, 7);
		this.current_player = false;
		rule = new Foor_in_a_row();
		app = new GUI();
		app.initGui();
		app.setSize(500, 550);
		app.setLocation(100, 100);
		app.show();
	}
	
	public void start(int my_mode){
		this.mode = my_mode;
		counter = 0;

		if(mode==0){
			start0(); // human vs human
		}
		else{
			start1();
		}
	}

	public void start0() {

		while ((!rule.isComplete(grid)) && (counter < grid.getWidth() * grid.getHeight())) {
			while (!app.played)
				;
			app.played = false;
			currently_played = app.choice;
			if (rule.check_play(currently_played, grid)) {
				update_grid();
				app.updateScreen(grid);
				current_player = !current_player;
				rule.grey_out(app,grid);
				counter++;
			} else {
				System.out.print("");
			}
		}

		app.game_ended(!current_player);
	}

	public void start1() {
		while ((!rule.isComplete(grid)) && (counter < grid.getWidth() * grid.getHeight())) {
			if (!current_player) { // human player
				while (!app.played)
					;
				app.played = false;
				currently_played = app.choice;
			} else { // launch Cpu
				Cpu cpu1 = new Ia_foor_in_a_row(); // change this line to use another ai
				cpu1.initialize(grid, mode);
				currently_played = cpu1.play(app.choice,rule);
			}
			if (rule.check_play(currently_played,grid)) {
				update_grid();
				app.updateScreen(grid);
				current_player = !current_player;
				rule.grey_out(app,grid);
				counter++;
			} else {
				System.out.print("");
			}
		}
		app.game_ended(!current_player);
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
				grid.setValue(grid.getHeight()-1, value, 1);
			else
				grid.setValue(grid.getHeight()-1, value, 2);
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
	 * Unused method
	private ArrayList<Integer> playable() {
		int i;
		ArrayList<Integer> cols = new ArrayList<Integer>();
		for (i = 0; i < 7; i++) {
			if (check_play(i))
				cols.add(i);
		}
		return cols;
	}
	*/
}
