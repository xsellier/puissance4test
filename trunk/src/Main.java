package src;

public class Main {
        @SuppressWarnings("deprecation")
		public static void main(String[] args) {

		Menu my_menu = new Menu();
		my_menu.initMenu();
		my_menu.setSize(200, 300);
		my_menu.setLocation(100, 100);
		my_menu.show();

		while(!my_menu.pushed)
		    System.out.print("");
		GameEngine g = new GameEngine();
		g.start(my_menu.choice);
        }
}

