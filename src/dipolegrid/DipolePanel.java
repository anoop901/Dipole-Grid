/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dipolegrid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author anoop
 */
class DipolePanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	
	private Dipole[] dipoles;
	private Timer timer;
	
	private Point mouse;

	public DipolePanel() {
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.BLACK);
		int numDs = 100;
		dipoles = new Dipole[numDs];
		for (int i = 0; i < numDs; i++) {
			dipoles[i] = new Dipole(i / 10 * 40 + 20, i % 10 * 40 + 20);
		}
		timer = new Timer(10, this);
		timer.start();
		mouse = null;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Dipole d : dipoles) {
			double x = d.getX();
			double y = d.getY();
			double th = d.getTheta();
			double r = d.getR();
			Shape s1 = new Ellipse2D.Double(x + r * Math.cos(th) - r, y + r * Math.sin(th) - r, 2 * r, 2 * r);
			Shape s2 = new Ellipse2D.Double(x - r * Math.cos(th) - r, y - r * Math.sin(th) - r, 2 * r, 2 * r);
			g2.setColor(Color.RED);
			g2.fill(s1);
			g2.setColor(Color.BLUE);
			g2.fill(s2);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Dipole d : dipoles) {
			if (mouse != null) {
				d.attractFrom(new Point2D.Double(mouse.x, mouse.y));
			} else {
				d.stopAttract();
			}
			d.move();
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouse = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouse = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouse = null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouse = e.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
