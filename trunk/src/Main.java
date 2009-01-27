package src;

public class Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Menu my_menu = new Menu();
		my_menu.initMenu();
		my_menu.setSize(200, 300);
		my_menu.setLocation(100, 100);
		my_menu.show();
		while (!my_menu.pushed)
			System.out.print("");
		while (true) {
			GameEngine g = new GameEngine();
			my_menu.setVisible(false);
			g.start(my_menu.choice);
			my_menu.pushed=false;
			my_menu.setVisible(true);
			while (!my_menu.pushed)
				System.out.print("");
			g.close();
		}
	}
}

