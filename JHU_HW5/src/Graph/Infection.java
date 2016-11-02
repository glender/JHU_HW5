/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author glender
 */
public class Infection {
	
	/**
	 * This is the time at which the Infection starts.
	 */
	public double time;

	/**
	 * This is the name of the computer that the 
	 * Infection starts on.
	 */
	public String startingComputerName;
	
	/**
	 * Empty Constructor.
	 */
	Infection() {}
	
	/**
	 * Constructor to fill our Infection data.
	 * @param t
	 * @param name 
	 */
	Infection(double t, String name) {
		this.time = t;
		this.startingComputerName = name;
	}
	
	/**
	 *
	 * @param t
	 * @param name
	 */
	public void reinitialise(double t, String name) {
		this.time = t;
		this.startingComputerName = name;
	}
	
}
