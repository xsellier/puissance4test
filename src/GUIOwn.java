package src;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GUIOwn extends JFrame implements GUI {

	private javax.swing.JButton NewButton;
	private javax.swing.JButton close;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane;
	private javax.swing.JToggleButton jToggleButton;
	private javax.swing.JLabel outPut;
	private ArrayList<javax.swing.JButton> play = new ArrayList<javax.swing.JButton>();
	private javax.swing.JPanel playGround;
	private javax.swing.JPanel playZone;
	private javax.swing.JLabel title;

	public int choice;
	public boolean played;
	public boolean reset;
	public boolean game_ended;
	
	public GUIOwn() {
		reset = false; // initialize reset
		played = false; // initialize played
		game_ended=false; // initialise game_ended
	}

	public boolean getPlayed(){
		return played;
	}

	public int getChoice(){
		return choice;
	}
	
	public void setPlayed(boolean played){
		this.played=played;
	}
	
	public boolean getReset(){
		return reset;
	}
	
	public void setReset(boolean reset){
		this.reset=reset;
	}
	
	public void initGui(DataStructure grid) {
		initComponents(grid);
		for (int i = 0; i < grid.getHeight() * grid.getWidth(); i++) {
			javax.swing.JButton tmpPan = new javax.swing.JButton();
			tmpPan.setEnabled(false);
			playZone.add(tmpPan);
		}
		outPut.setText("C'est parti !");
	}

	private void initComponents(DataStructure grid) {
		int j = 1;
		jToggleButton = new javax.swing.JToggleButton();
		playGround = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		for (int i = 0; i < grid.getWidth(); ++i)
			play.add(new javax.swing.JButton());
		playZone = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		NewButton = new javax.swing.JButton();
		jScrollPane = new javax.swing.JScrollPane();
		outPut = new javax.swing.JLabel();
		close = new javax.swing.JButton();
		title = new javax.swing.JLabel();

		jToggleButton.setText("jToggleButton1");

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm(evt);
			}
		});

		playGround.setLayout(new java.awt.BorderLayout());

		jPanel1.setLayout(new java.awt.GridLayout(1, grid.getWidth()));
		
		/* 
		 * create a button for each columns
		 */
		for (Iterator<JButton> i = play.iterator(); i.hasNext();) {
			final int k = j;
			JButton n = (JButton) i.next();
			n.setText(j + "");
			n.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					playIActionPerformed(evt, k - 1);
				}
			});
			j++;
			jPanel1.add(n);
		}

		playGround.add(jPanel1, java.awt.BorderLayout.SOUTH);

		playZone.setLayout(new java.awt.GridLayout(grid.getHeight(), grid
				.getWidth()));

		playZone.setBackground(new java.awt.Color(51, 51, 255));
		playGround.add(playZone, java.awt.BorderLayout.CENTER);

		getContentPane().add(playGround, java.awt.BorderLayout.CENTER);

		jPanel2.setLayout(new java.awt.GridLayout(1, 3));

		NewButton.setText("Reset");
		NewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NewButActionPerformed(evt);
			}
		});

		jPanel2.add(NewButton);

		outPut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jScrollPane.setViewportView(outPut);

		jPanel2.add(jScrollPane);

		close.setText("Fermer");
		close.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeActionPerformed(evt);
			}
		});

		jPanel2.add(close);

		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

		title.setBackground(new java.awt.Color(0, 102, 255));
		title.setFont(new java.awt.Font("Century Gothic", 1, 14));
		title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		title.setText(" Puissance 4 ");
		getContentPane().add(title, java.awt.BorderLayout.NORTH);

		pack();
	}

	// a player has played
	private void playIActionPerformed(java.awt.event.ActionEvent evt, int i) {
		choice = i;
		played = true;
	}

	// close game or window game
	private void closeActionPerformed(java.awt.event.ActionEvent evt) {
		if(game_ended) // if game is end, another menu has appear so we just close grid windows
			this.dispose();
		else
			System.exit(1);
	}

	// reset grid
	private void NewButActionPerformed(java.awt.event.ActionEvent evt) {
		reset = true;
	}

	// close game or window game
	private void exitForm(java.awt.event.WindowEvent evt) {
		if(game_ended) // if game is end, another menu has appear so we just close grid windows
			this.dispose();
		else
			System.exit(1);
	}

	/* (non-Javadoc)
	 * @see src.GUI2#updateScreen(src.DataStructure)
	 */
	public void updateScreen(DataStructure my_grid) {
		for (int i = 0; i < my_grid.getHeight(); i++)
			for (int j = 0; j < my_grid.getWidth(); j++) {
				if (my_grid.getValue(i, j) == 0)
					playZone.getComponent(j + (my_grid.getWidth() * i))
							.setBackground(new java.awt.Color(240, 240, 240));
				if (my_grid.getValue(i, j) == 1)
					playZone.getComponent(j + (my_grid.getWidth() * i))
							.setBackground(new java.awt.Color(255, 0, 0));
				if (my_grid.getValue(i, j) == 2)
					playZone.getComponent(j + (my_grid.getWidth() * i))
							.setBackground(new java.awt.Color(255, 255, 0));
			}
	}

	// a player wins
	public void gameEnded(boolean winner) {
		game_ended=true; // to close windows
		greyAllButton(); // to disable buttons
		if (!winner)
			outPut.setText("Joueur 1 a gagne !~");
		else
			outPut.setText("Joueur 2 a gagne !~");
	}

	// it is a draw
	public void gameEnded() {
		game_ended=true; // to close windows
		greyAllButton(); // to disable buttons
		outPut.setText("Match nul !~");
	}

	public void greyAllButton() {
		for (Iterator<JButton> i = play.iterator(); i.hasNext();) {
			JButton n = (JButton) i.next();
			n.setEnabled(false);
		}
		NewButton.setEnabled(false);
	}

	// enable all button
	public void enableAllButton() {
		for (Iterator<JButton> i = play.iterator(); i.hasNext();) {
			JButton n = (JButton) i.next();
			n.setEnabled(true);
		}
	}

	//	grey out button number num
	public void greyButton(int num) {
		int j = 0;
		for (Iterator<JButton> i = play.iterator(); i.hasNext();) {
			JButton n = (JButton) i.next();
			if (j == num)
				n.setEnabled(false);
			j++;
		}

	}

}

