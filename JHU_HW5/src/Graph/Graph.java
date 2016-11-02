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
public class Graph {
	
	/**
	 * Node list.
	 */
	List<Node> nodes = new ArrayList<Node>();
	
	/**
	 * Edge list.
	 */
	List<Edge> edges = new ArrayList<Edge>();
	
	/**
	 * Empty constructor.
	 */
	Graph() {}
	
	/**
	 * Constructor to fill out Graph.
	 * @param n
	 * @param e 
	 */
	Graph(List<Node> n, List<Edge> e) {
		this.nodes.addAll(n);
		this.edges.addAll(e);
	}
	
	/**
	 * Inserts the infection into our Network.
	 * @param infection
	 */
	public void insertInfection(Infection infection) {
		for (Node node : nodes) {
			if (node.computerName.equalsIgnoreCase(infection.startingComputerName)) {
				node.infectionTime = infection.time;
				node.setInfected();
			}
		}
	}
	
	/**
	 * Displays the results of our infection.
	 */
	public void displayResults() {
		for (Node node : nodes) {
			System.out.println("Computer Name: " + node.computerName 
							 + " Infected: " + node.infected
							 + " Infection Time: " + node.infectionTime);
		}
	}
	
	/**
	 * This determines if the infected computer will spread to other Nodes (i.e. other Computers).
	 * @param infection
	 */
	public void determineInfection(Infection infection) {
		
		for (Edge edge : this.edges) {
			
			if (!edge.start.infected || !edge.end.infected) {
			
				if (edge.communicationTime >= infection.time) {

					if (!edge.start.computerName.equalsIgnoreCase(infection.startingComputerName) && !edge.start.infected && edge.end.infected) {
						edge.start.infectionTime = edge.communicationTime;
						edge.start.setInfected();
					}

					if (!edge.end.computerName.equalsIgnoreCase(infection.startingComputerName) && !edge.end.infected && edge.start.infected) {
						edge.end.infectionTime = edge.communicationTime;
						edge.end.setInfected();
					}

				}
			}
			
		}
		
	}
	
}
