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
public class Edge {
	
	/**
	 * Starting Node.
	 */
	public Node start;

	/**
	 * Ending Node.
	 */
	public Node end;

	/**
	 * Communication Time between Nodes (i.e. Computers).
	 */
	public double communicationTime;
	
	/**
	 * Empty constructor.
	 */
	Edge() {}
	
	/**
	 * Constructor to fill the Edge.
	 * @param s
	 * @param e
	 * @param time 
	 */
	Edge(Node s, Node e, double time) {
		this.start = s;
		this.end = e;
		this.communicationTime = time;
	}
	
	/**
	 *
	 * @param s
	 * @param e
	 * @param time
	 */
	public void reinitialise(Node s, Node e, double time) {
		this.start = s;
		this.end = e;
		this.communicationTime = time;	
	}
	
	/**
	 * Sets start Node.
	 * @param s
	 */
	public void setStart(Node s) {
		this.start = s;
	}
	
	/**
	 * Sets end Node.
	 * @param e
	 */
	public void setEnd(Node e) {
		this.end = e;
	}
	
	/**
	 * Sets communication time.
	 * @param commTime
	 */
	public void setCommunicationTime(double commTime) {
		this.communicationTime = commTime;
	}
	
	/**
	 * Clears the Node.
	 */
	public void Clear() {
		this.communicationTime = 0;
		
		if (null != this.end) {
			this.end.Clear();
		}
		
		if (null != this.start) {
			this.start.Clear();
		}

	}
	
}
