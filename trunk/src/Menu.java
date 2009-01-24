
package src;

import javax.swing.JFrame;

public class Menu extends JFrame {
    
    private javax.swing.JButton close;
    private javax.swing.JButton hvh;
    private javax.swing.JButton hvc1;
    private javax.swing.JButton hvc2;
    private javax.swing.JPanel buttonZone;
    private javax.swing.JPanel jpanel;
    public int choice;
    public boolean pushed;
    
    public Menu() {
	super("Menu");
	pushed = false;
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
