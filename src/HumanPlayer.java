
package src;


public class HumanPlayer implements Player {

   public int currently_played;

    public HumanPlayer(){
    }

    public int play(DataStructure grid, GUI gui){
        while(!gui.played);
        currently_played = gui.choice;
        gui.played = false;
       return currently_played;
    }
}