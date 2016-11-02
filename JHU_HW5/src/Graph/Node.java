/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.List;

/**
 *
 * @author glender
 */
public class Node {
	
	/**
	 * This is the computer name at this Node (i.e. C1).
	 */
	public String computerName;

	/**
	 * This is the time of infection for this Node. 
	 * This should initialise to zero so that we can 
	 * determine it one the Infection has been started.
	 */
	public double infectionTime = 0;

	/**
	 * This is all of the connection for the node (i.e. C1 communicates with C2, therefore
	 * we have an Edge connection C1 -> C2).
	 */
	public List<Edge> connections;
	
	/**
	 *
	 */
	public boolean infected = false;
	
	/**
	 * Empty constructor.
	 */
	Node() {}
	
	/**
	 * Constructor to fill the Node.
	 * Note, infection time is not initialised. This is 
	 * explained above.
	 * @param name
	 * @param time
	 * @param conns 
	 */
	Node(String name, List<Edge> conns) {
		this.computerName = name;
		this.connections.addAll(conns);
	}
	
	Node(String name) {
		this.computerName = name;
	}
	
	/**
	 * Sets the Infection time.
	 * @param t
	 */
	public void setInfectionTime(double t) {
		this.infectionTime = t;
	}
	
	/**
	 * Sets the Computer Name.
	 * @param s
	 */
	public void setComputerName(String s) {
		this.computerName = s;
	}
	
	/**
	 * Sets the Connections.
	 * Note, may not use this.
	 * @param e
	 */
	public void setConnections(List<Edge> e) {
		this.connections.addAll(e);
	}
	
	/**
	 * Sets the Node to Infected.
	 */
	public void setInfected() {
		this.infected = true;
	}
	
	/**
	 * Clears the Node.
	 */
	public void Clear() {
		this.computerName = "";
		
		if (null != connections) {
			this.connections.clear();
		}
		
		this.infectionTime = 0;
		this.infected = false;
	}
	
	/**
	 * Clears the Node but, leaves the Computer Name.
	 */
	public void ClearButLeaveComputerName() {
		
		if (null != connections) {
			this.connections.clear();
		}
		
		this.infectionTime = 0;
		this.infected = false;
	}
	
}
