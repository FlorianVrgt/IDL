package main;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import main.Node;



public class Graph {
	 
    private Set<Node> nodes = new HashSet<>();
     
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
    
 

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}
 
    // getters and setters 
}
