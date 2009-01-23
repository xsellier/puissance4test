/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.awt.event.WindowAdapter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame{
    
    //Variables graphiques
    private javax.swing.JButton NewBut;
    private javax.swing.JButton close;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel outPut;
    private javax.swing.JButton play;
    private javax.swing.JButton play2;
    private javax.swing.JButton play3;
    private javax.swing.JButton play4;
    private javax.swing.JButton play5;
    private javax.swing.JButton play6;
    private javax.swing.JButton play7;
    private javax.swing.JPanel playGroundPan;
    private javax.swing.JPanel playZone;
    private javax.swing.JLabel title;
    
    public int choice;
    public boolean played;

    public GUI(){
	played = false;
    }

    public void initGui(){
	initComponents();
	for(int i=0; i<42; i++) {
	    javax.swing.JButton tmpPan = new javax.swing.JButton();
	    tmpPan.setEnabled(false);
	    playZone.add( tmpPan );
	}
	outPut.setText("C'est parti !!!");
    }
    
    private void initComponents() {
	jToggleButton1 = new javax.swing.JToggleButton();
	playGroundPan = new javax.swing.JPanel();
	jPanel1 = new javax.swing.JPanel();
	play = new javax.swing.JButton();
	play2 = new javax.swing.JButton();
	play3 = new javax.swing.JButton();
	play4 = new javax.swing.JButton();
	play5 = new javax.swing.JButton();
	play6 = new javax.swing.JButton();
	play7 = new javax.swing.JButton();
	playZone = new javax.swing.JPanel();
	jPanel2 = new javax.swing.JPanel();
	NewBut = new javax.swing.JButton();
	jScrollPane1 = new javax.swing.JScrollPane();
	outPut = new javax.swing.JLabel();
	close = new javax.swing.JButton();
	title = new javax.swing.JLabel();
	
	jToggleButton1.setText("jToggleButton1");
	
	
	addWindowListener(new java.awt.event.WindowAdapter() {
		public void windowClosing(java.awt.event.WindowEvent evt) {
		    exitForm(evt);
		}
     });
	
     playGroundPan.setLayout(new java.awt.BorderLayout());

     jPanel1.setLayout(new java.awt.GridLayout(1, 7));

     play.setText("1");
     play.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     playIActionPerformed(evt,0);
     }
     });

     jPanel1.add(play);

     play2.setText("2");
     play2.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     playIActionPerformed(evt,1);
     }
     });

     jPanel1.add(play2);

     play3.setText("3");
     play3.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     playIActionPerformed(evt,2);
     }
     });

     jPanel1.add(play3);

     play4.setText("4");
     play4.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     playIActionPerformed(evt,3);
     }
     });

     jPanel1.add(play4);

     play5.setText("5");
     play5.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     playIActionPerformed(evt,4);
     }
     });

     jPanel1.add(play5);

     play6.setText("6");
     play6.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     playIActionPerformed(evt,5);
     }
     });

     jPanel1.add(play6);

     play7.setText("7");
     play7.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     playIActionPerformed(evt,6);
     }
     });

     jPanel1.add(play7);

     playGroundPan.add(jPanel1, java.awt.BorderLayout.SOUTH);

     playZone.setLayout(new java.awt.GridLayout(6, 7));

     playZone.setBackground(new java.awt.Color(51, 51, 255));
     playGroundPan.add(playZone, java.awt.BorderLayout.CENTER);

     getContentPane().add(playGroundPan, java.awt.BorderLayout.CENTER);

     jPanel2.setLayout(new java.awt.GridLayout(1, 3));

     NewBut.setText("Nouveau");
     NewBut.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     NewButActionPerformed(evt);
     }
     });

     jPanel2.add(NewBut);

     outPut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
     jScrollPane1.setViewportView(outPut);

     jPanel2.add(jScrollPane1);

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


    private void playIActionPerformed(java.awt.event.ActionEvent evt, int i) {//GEN-FIRST:event_play7ActionPerformed
	choice = i;
	played = true;
    }//GEN-LAST:event_play7ActionPerformed

     private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
     // Add your handling code here:
     System.exit(0);
     }//GEN-LAST:event_closeActionPerformed

     private void NewButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButActionPerformed
     // Add your handling code here:
  
     }
    // Exit the Application /
     private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
     System.exit(0);
     }

    public void updateScreen(DataStructure my_grid) {
     for(int i=0; i<6; i++)
         for(int j=0; j<7; j++){
             if(my_grid.getValue(i,j) == 0)
		 playZone.getComponent(j+(7*i)).setBackground(new java.awt.Color(240,240,240));
             if(my_grid.getValue(i,j) == 1)
             playZone.getComponent(j+(7*i)).setBackground(new java.awt.Color(255,0,0));
             if(my_grid.getValue(i,j) == 2)
             playZone.getComponent(j+(7*i)).setBackground(new java.awt.Color(255,255,0));
        }
     }

    public void game_ended(boolean winner){
	if(!winner)
	    outPut.setText("Joueur 1 a gagne !~");
	else
	    outPut.setText("Joueur 2 a gagne !~");

	//	play.setEnabled(false);
    }

    public void grey_button(int num){
	switch(num)
	    {
	    case 0:
		play.setEnabled(false);
		break;
	    case 1:
		play2.setEnabled(false);
		break;
	    case 2:
		play3.setEnabled(false);
		break;
	    case 3:
		play4.setEnabled(false);
		break;
	    case 4:
		play5.setEnabled(false);
		break;
	    case 5:
		play6.setEnabled(false);
		break;
	    case 6:
		play7.setEnabled(false);
		break;
	    }
    }

}
