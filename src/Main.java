package src;

public class Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Menu my_menu = new Menu();
		my_menu.initMenu();
		my_menu.setSize(200, 300);
		my_menu.setLocation(100, 100);
		my_menu.show();
		while (!my_menu.pushed) // wait for human choose
			System.out.print("");
		while (true) { // infinite loop can stopped by my_menu by Exiting, System.exit(1);
			GameEngine g = new GameEngine(); // initialize game
			my_menu.setVisible(false); // make disappear Menu
			g.initMode(my_menu.choice); // launch game
			my_menu.pushed=false; // re-initialize menu
			my_menu.setVisible(true); // show menu
			while (!my_menu.pushed) // wait for human choose
				System.out.print("");
			g.close(); // make disappear Grid
		}
	}
}

