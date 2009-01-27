
package src;


public class HumanPlayer implements Player {

   public int currently_played;

    public HumanPlayer(){
    }

    public int play(DataStructure grid, GUI gui){
        while(!gui.get_Played() && !gui.get_Reset())
            System.out.print(""); //Instruction trivial pour Javac
        if(gui.get_Reset()) // reset button pushed
        	return -2;
        currently_played = gui.get_Choice(); 
        gui.set_Played(false); // to play just one time
       return currently_played;
    }
}
