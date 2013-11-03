/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dipolegrid;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author anoop
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		
		JFrame frame = new JFrame("Dipole Grid");
		JPanel panel = new DipolePanel();
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
