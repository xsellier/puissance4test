
package src;


public class HumanPlayer implements Player {

   public int currently_played;

    public HumanPlayer(){
    }

    public int play(DataStructure grid, GUI gui){
        while(!gui.get_Played() && !gui.get_Reset());
        if(gui.get_Reset())
        	return -2;
        currently_played = gui.get_Choice();
        gui.set_Played(false);
       return currently_played;
    }
}