/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

/**
 *
 * @author ErGoPrOxY
 */
public class HumanPlayer implements Player {

   private GUI gui;
   private DataStructure data;
   public int currently_played;

    public HumanPlayer(GUI gui, DataStructure data){
        this.data = data;
        this.gui = gui ;
    }

    public int play(DataStructure grid, GUI gui){
        while(!gui.played);
        currently_played = gui.choice;
        gui.played = false;
       return currently_played;
    }
}