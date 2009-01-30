package src;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private javax.swing.JButton close;
	private javax.swing.JButton hvh;
	private javax.swing.JButton hvc1;
	private javax.swing.JButton hvc2;
	private javax.swing.JPanel buttonZone;
	private javax.swing.JPanel jpanel;
	
	public int choice;
	public boolean pushed;
	
	/*
	 * these buttons are enabled in testing mode
	 */
	private javax.swing.JButton hvcr; 
	private javax.swing.JButton hvcs;
	private javax.swing.JButton crvcr;
	private javax.swing.JButton crvcs;
	private javax.swing.JButton csvcs;

	public Menu() {
		super("Menu");
		pushed = false;
	}

	/*
	 * add buttons for test program
	 */
	public void initTestMenu(){
		hvcr = new javax.swing.JButton();
		hvcs = new javax.swing.JButton();
		crvcr = new javax.swing.JButton();
		crvcs = new javax.swing.JButton();
		csvcs = new javax.swing.JButton();
		
		hvcr.setText("Human vs Cpu Random");
		hvcs.setText("Human vs Cpu Switch");
		crvcr.setText("Cpu Random vs Cpu Random");
		crvcs.setText("Cpu Random vs Cpu Switch");
		csvcs.setText("Cpu Switch vs Cpu switch");
		
		hvcr.setEnabled(true);
		hvcs.setEnabled(true);
		crvcr.setEnabled(true);
		crvcs.setEnabled(true);
		csvcs.setEnabled(true);
		
		hvcr.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonActionPerformed(evt, 3);
			}
		});
		
		hvcs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonActionPerformed(evt, 4);
			}
		});
		
		crvcr.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonActionPerformed(evt, 5);
			}
		});
		
		crvcs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonActionPerformed(evt, 6);
			}
		});
		
		csvcs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonActionPerformed(evt, 7);
			}
		});
		
		buttonZone.add(hvcr);
		buttonZone.add(hvcs);
		buttonZone.add(crvcr);
		buttonZone.add(crvcs);
		buttonZone.add(csvcs);
	}
	
	public void initMenu() {
		close = new javax.swing.JButton();
		hvh = new javax.swing.JButton();
		hvc1 = new javax.swing.JButton();
		hvc2 = new javax.swing.JButton();
		jpanel = new javax.swing.JPanel();
		buttonZone = new javax.swing.JPanel();

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				System.exit(0);
			}
		});

		jpanel.setLayout(new java.awt.BorderLayout());
		buttonZone.setLayout(new java.awt.GridLayout(4, 3));

		hvh.setText("Human vs Human");
		hvc1.setText("Human vs Cpu - Easy");
		hvc2.setText("Human vs Cpu - Hard");
		close.setText("Exit");

		hvh.setEnabled(true);
		hvc1.setEnabled(true);
		hvc2.setEnabled(true);
		close.setEnabled(true);

		hvh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonActionPerformed(evt, 0);
			}
		});

		hvc1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonActionPerformed(evt, 1);
			}
		});

		hvc2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonActionPerformed(evt, 2);
			}
		});

		close.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});

		buttonZone.add(hvh);
		buttonZone.add(hvc1);
		buttonZone.add(hvc2);
		buttonZone.add(close);

		jpanel.add(buttonZone, java.awt.BorderLayout.CENTER);
		getContentPane().add(jpanel, java.awt.BorderLayout.CENTER);

		pack();
	}

	private void buttonActionPerformed(java.awt.event.ActionEvent evt, int i) {
		choice = i;
		pushed = true;
	}
}
