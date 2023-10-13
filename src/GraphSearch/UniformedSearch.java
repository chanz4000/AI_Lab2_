/**
 * 
 */
package GraphSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 */
public class UniformedSearch implements ISearchAlgo{

	
	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		 boolean started = false;
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			if (current.getLabel().equals(goal)&& started ==true) {
				return current;
			}
			if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);
			}

			List<Edge> list = current.getChildren();
				for (int i = 0; i < list.size(); i++) {
					Edge nodeEdge = list.get(i);
					Node newNode = nodeEdge.getEnd();
					if(newNode.getLabel().equals(start)) {
						frontier.clear();
						frontier.add(newNode);
						
					}
					
					if (!explored.contains(newNode) && !frontier.contains(newNode)) {
						frontier.add(newNode);
						newNode.setParent(current);
						newNode.setPathCost(nodeEdge.getWeight() + current.getPathCost());
					}else if(frontier.contains(newNode)&& (newNode.getPathCost()>nodeEdge.getWeight() + current.getPathCost() )) {
						newNode.setParent(current);
						newNode.setPathCost(nodeEdge.getWeight() + current.getPathCost());
					}
			}
			System.out.println(frontier);

		
	}
	return null;
}

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explorer = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explorer.add(current);
			if (current.getLabel().equals(goal)) {
				return current;
			}

			List<Edge> list = current.getChildren();
				for (int i = 0; i < list.size(); i++) {
					Edge nodeEdge = list.get(i);
					Node newNode = nodeEdge.getEnd();
					
					if (!explorer.contains(newNode) && !frontier.contains(newNode)) {
						frontier.add(newNode);
						newNode.setParent(current);
						newNode.setPathCost(nodeEdge.getWeight() + current.getPathCost());
					}else if(frontier.contains(newNode)&& (newNode.getPathCost()>nodeEdge.getWeight() + current.getPathCost() )) {
						newNode.setParent(current);
						newNode.setPathCost(nodeEdge.getWeight() + current.getPathCost());
					}
			}
			System.out.println(frontier);

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
		ISearchAlgo algo1 = new UniformedSearch();
		Node result = algo1.execute(nodeS,"A", "G");
		NodeUtils util = new NodeUtils();
		List<String> node = NodeUtils.printPath(result);
		for (String object : node) {
			System.out.println(object);
		}
	}

}
