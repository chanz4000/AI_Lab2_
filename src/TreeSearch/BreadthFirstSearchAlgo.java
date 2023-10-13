/**
 * 
 */
package TreeSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 */
public class BreadthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node>frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored=new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal))return current;
			explored.add(current);
			List<Node>children= current.getChildrenNodes();
			for (Node child : children) {
				
					frontier.add(child);
					child.setParent(current);
				
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node>frontier = new LinkedList<Node>();
		frontier.add(root);
		boolean started = false;
		List<Node> explored=new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);
			}
			if(current.getLabel().equals(goal)&& started==true)return current;
			explored.add(current);
			List<Node>children= current.getChildrenNodes();
			for (Node child : children) {
				
					frontier.add(child);
					child.setParent(current);
				
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		Node result = algo1.execute(nodeS, "G");
		NodeUtils util = new NodeUtils();
		List<String> node = NodeUtils.printPath(result);
		for (String object : node) {
			System.out.println(object);
		}
	}

}
