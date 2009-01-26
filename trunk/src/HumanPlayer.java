
package src;


public class HumanPlayer implements Player {

   public int currently_played;

    public HumanPlayer(){
    }

    public int play(DataStructure grid, GUI gui){
        while(!gui.played && !gui.reset);
        if(gui.reset)
        	return -2;
        currently_played = gui.choice;
        gui.played = false;
       return currently_played;
    }
}