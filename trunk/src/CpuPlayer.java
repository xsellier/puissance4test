/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

/**
 *
 * @author ErGoPrOxY
 */
public class CpuPlayer implements Player {

   private int mode;
   public int currently_played;
   private rules rule;


    public CpuPlayer(int mode, rules rule){
          this.mode = mode;
        this.rule = rule;
    }

    public int play(DataStructure grid, GUI gui) {
        Cpu cpu1 = new Ia_foor_in_a_row();
        cpu1.initialize(grid, mode);
        currently_played = cpu1.play(gui.choice,rule);
        return currently_played;
    }

}


 // change this line to use another ai
				
				