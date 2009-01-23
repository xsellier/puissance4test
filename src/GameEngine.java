package src;

import java.util.*;

public class GameEngine {
    
    private DataStructure grid;
    private boolean current_player;
    private int currently_played;
    private GUI app;
    private int mode;
    int counter;
    
    public GameEngine(int my_mode) {
	this.grid = new DataStructure(6,7);
     	this.current_player = false;

        app = new GUI();
	app.initGui();
        app.setSize(500,550);
        app.setLocation(100,100);
        app.show();

	this.mode = my_mode;
	counter = 0;

	switch(mode){
	case 0:
	    {   start0(); // human vs human
		break;}
	case 1:
	    {	    start1();
		break;}
	case 2:
	    {	    start2();		
		break;}
	}
    }

	public void start0(){

	    while((!isComplete()) && (counter < 42) )
		{
		    while(!app.played);
		    app.played = false;
		    currently_played = app.choice;
		    if(check_play(currently_played)){
			update_grid();
			app.updateScreen(grid);
			current_player = !current_player;
			grey_out();
			counter++;
		    }else
			{
			    System.out.print("AHHHHHHHHHHH!!!");
			    System.out.println();
			}
			
		}
	    
	    app.game_ended(!current_player);
	}

    public void start1(){}
    public void start2(){}

	private void update_grid() {
	    int value = currently_played;
	    int i = 0;
	    boolean empty = true;
	    
	    while(i<6)
		{
		    if(grid.getValue(i,value) != 0)
			{
			    empty = false;
			    break;
			}
		    else
			i++;
		}

	    if(empty)
		{
		    if(current_player == false)
			grid.setValue(5,value,1);
		    else
			grid.setValue(5,value,2);
		}
	    else
		{
		    if(i != 0){
			if(current_player == false)
			    grid.setValue(i-1,value,1);
			else
			    grid.setValue(i-1,value,2);
		    }
		}
	    
	}

	private boolean isComplete() {
	    int color;
	    int i,j;
	    for(i = 0; i<6; i++)
		{
		    for(j = 0; j<7; j++)
			{
			    color = grid.getValue(i,j);
			    if(color != 0){
				if(check_line(i,j,color))
				    return true;
				if(check_col(i,j,color))
				    return true;
				if(check_diag(i,j,color))
				    return true;
			    }
			}
		}
	    return false;
	}

	private boolean check_line(int i,int j,int color) {
	    int count_left = 0;
	    int count_right = 0;

	    int real_j = j;

	    if(j>0){
	    j= real_j-1;
	    while((j>=0) && (j>(real_j-4)) && (grid.getValue(i,j) == color))
		{
		    count_left++;
		    j--;
		}
	    }
	    
	    if(j<6){
	    j= real_j+1;
	    while((j<7) && (j<(real_j+4)) && (grid.getValue(i,j) == color))
		{
		    count_right++;
		    j++;
		}
	    }	
	    if((count_left + count_right) >=3)
		return true;
	    else
		return false;
	}
	
	private boolean check_col(int i,int j,int color) {
	    int count_up = 0;
	    int count_down = 0;

	    int real_i = i;

	    if(i>0){
	    i= real_i-1;
	    while((i>=0) && (i>(real_i-4)) && (grid.getValue(i,j) == color))
		{
		    count_down++;
		    i--;
		}
	    }
	    if(i<5){
	    i= real_i+1;
	    while((i<6) && (i<(real_i+4)) && (grid.getValue(i,j) == color))
		{
		    count_up++;
		    i++;
		}
	    }

	    if((count_up + count_down) >=3)
		return true;
	    else
		return false;

	}
	
	private boolean check_diag(int i,int j,int color) {
	
	    int count1 = 0;
	    int count2 = 0;

	    int real_i = i;
	    int real_j = j;

	    if((i>0) && (j>0)){
	    i= real_i-1;
	    j= real_j-1;
	    while((i>=0) && (i>(real_i-4)) && (j>=0) && (j>(real_j-4)) && (grid.getValue(i,j) == color))
		{
		    count1++;
		    i--;
		    j--;
		}
	    }

	    if((i<5) && (j<6)){
	    i= real_i+1;
	    j= real_j+1;
	    while((i<6) && (i<(real_i+4)) && (j<7) && (j<(real_j+4)) && (grid.getValue(i,j) == color))
		{
		    count2++;
		    i++;
		    j++;
		}
	    }

	    if((count1 + count2) >=3)
		return true;


	    count1 = 0;
	    count2 = 0;

	    if((i>0) && (j<6)){
	    i= real_i-1;
	    j= real_j+1;
	    while((i>=0) && (i>(real_i-4)) && (j<7) && (j<(real_j+4)) && (grid.getValue(i,j) == color))
		{
		    count1++;
		    i--;
		    j++;
		}
	    }

	    if((i<5) && (j>0)){
	    i= real_i+1;
	    j= real_j-1;
	    while((i<6) && (i<(real_i+4)) && (j>=0) && (j>=(real_j-4)) && (grid.getValue(i,j) == color))
		{
		    count2++;
		    i++;
		    j--;
		}
	    }

	    if((count1 + count2) >=3)
		return true;

	    return false;
	}

    private boolean check_play(int play){
	if(grid.getValue(0,play) == 0)
	    return true;
	return false;
    }

    private ArrayList<Integer> playable(){
	int i;
	ArrayList<Integer> cols = new ArrayList<Integer>();
	for(i = 0; i<7; i++)
	    {
		if(check_play(i))
		    cols.add(i);
	    }
	return cols;
    }
    
    private void grey_out(){
	int i;
	for(i = 0; i<7; i++)
	    if(grid.getValue(0,i)!=0)
		app.grey_button(i);

    }
    
}
