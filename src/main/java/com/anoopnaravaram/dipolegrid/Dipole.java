/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anoopnaravaram.dipolegrid;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author anoop
 */
public class Dipole {
	
	private double x;
	private double y;		// position
	private double theta;	// angle
	private double r;		// radius
	
	private double omega;	// angular velocity
	private double alpha;	// angular acceleration
	
	private final double angularFriction;
	
	public Dipole(double x, double y) {
		this.x = x;
		this.y = y;
		this.theta = 2 * Math.PI * Math.random();
		this.r = 8;
		this.omega = (2 * Math.random() - 1) * .1;
		this.alpha = 0;
		this.angularFriction = .98;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @return the theta
	 */
	public double getTheta() {
		return theta;
	}
	
	public void move() {
		theta += omega;
		omega += getAlpha();
		omega *= angularFriction;
	}

	public void attractFrom(Point2D.Double m) {
//		double distanceSq = pt.distanceSq(x, y);
//		double angle = theta - Math.atan2(pt.y - y, pt.x - x);
//		alpha = - 20 / distanceSq * Math.sin(angle);
		double d1x = x + r * Math.cos(theta) - m.x;
		double d1y = y + r * Math.sin(theta) - m.y;
		double d1 = Math.sqrt(d1x * d1x + d1y * d1y);
		
		double d2x = x - r * Math.cos(theta) - m.x;
		double d2y = y - r * Math.sin(theta) - m.y;
		double d2 = Math.sqrt(d2x * d2x + d2y * d2y);
		
		alpha = -.005 * ((d1y / d1 + d2y / d2) * Math.cos(theta)
						- (d1x / d1 + d2x / d2) * Math.sin(theta));
	}

	void stopAttract() {
		alpha = 0;
	}

	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}

	/**
	 * @return the alpha
	 */
	public double getAlpha() {
		return alpha;
	}
}
