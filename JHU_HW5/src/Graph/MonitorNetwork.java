/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glender
 */
public class MonitorNetwork {
	
	/**
	 * This is our Network Graph.
	 */
	public static Graph networkGraph = new Graph();

	/**
	 * This is our Infection.
	 */
	public static Infection infection = new Infection();
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		
		// Set up our Nodes.
		Node c1 = new Node("C1");
		Node c2 = new Node("C2");
		Node c3 = new Node("C3");
		Node c4 = new Node("C4");
		
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(c1);
		nodes.add(c2);
		nodes.add(c3);
		nodes.add(c4);
		
		// Set up our Edges.
		Edge c1Toc2 = new Edge(c1, c2, 4);
		Edge c2Toc4 = new Edge(c2, c4, 8);
		Edge c3Toc4 = new Edge(c3, c4, 8);
		Edge c1Toc4 = new Edge(c1, c4, 12);
		
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(c1Toc2);
		edges.add(c2Toc4);
		edges.add(c3Toc4);
		edges.add(c1Toc4);
		
		// Set up our Graph.
		networkGraph.edges.addAll(edges);
		networkGraph.nodes.addAll(nodes);
		
		// Set up our Infection.
		infection.startingComputerName = c1.computerName;
		infection.time = 2;
		
		// Initialise our Infection
		networkGraph.insertInfection(infection);
		
		// Determine Infection spread
		networkGraph.determineInfection(infection);
		
		// Display Infection results
		networkGraph.displayResults();
		
		System.out.println("------------------------------------------------- \n \n");
		
		// Clear the Nodes for the next test
		c1.ClearButLeaveComputerName();
		c2.ClearButLeaveComputerName();
		c3.ClearButLeaveComputerName();
		c4.ClearButLeaveComputerName();
		
		// Create new Edges
		Edge c2Toc3 = new Edge(c2, c3, 8);
		c1Toc4.reinitialise(c1, c4, 12);
		c1Toc2.reinitialise(c1, c2, 14);
		
		// Clear our Edge list, as we have a new Network Configuration
		edges.clear();
		edges.add(c2Toc3);
		edges.add(c1Toc4);
		edges.add(c1Toc2);
		
		// Remove the Communications from our Network Configuration
		networkGraph.edges.clear();
		
		networkGraph.edges.addAll(edges);
		
		// Reinitialise our Infection
		infection.reinitialise(2, c1.computerName);
		
		// Initialise our Infection
		networkGraph.insertInfection(infection);
		
		// Determine Infection spread
		networkGraph.determineInfection(infection);
		
		// Display Infection results
		networkGraph.displayResults();

	}
	
	
}
