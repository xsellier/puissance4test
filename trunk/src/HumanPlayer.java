package src;

public class HumanPlayer implements Player {

    private int currently_played;

    public int play(DataStructure grid, GUI gui){
        while(!gui.getPlayed() && !gui.getReset())
            System.out.print(""); // trivial instruction for Javac
        if(gui.getReset()) // reset button pushed
        	return -2;
        currently_played = gui.getChoice(); 
        gui.setPlayed(false); // to play just one time
       return currently_played;
    }
}
