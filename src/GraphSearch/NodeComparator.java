/**
 * 
 */
package GraphSearch;

import java.util.Comparator;

/**
 * 
 */
public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node node1, Node node2) {
        int value =Double.compare(node1.getPathCost(), node2.getPathCost());
        // elements are sorted in reverse order
        if(value==0) {
        	value=node1.compareTo(node2);
        }
        return value;
    }

}
