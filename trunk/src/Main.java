package src;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                int i=3;
                System.out.println();
                System.out.println("Modes :");
                System.out.println("0 - Deux joueurs humains");
                System.out.println("1 - Humain vs CPU (facile)");
                System.out.println("2 - Humain vs CPU (difficile)");
                System.out.println();
                Scanner sc = new Scanner(System.in);
                while(i!=0 && i!=1 && i!=2){
                	System.out.println("Veuillez entrer un mode :");
                	i = sc.nextInt();
                	System.out.println();
                }
				@SuppressWarnings("unused")
				GameEngine g = new GameEngine(i);
        }
}

