package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BinaryTree    {
	
	private Node root;
	
	private int size;
	
	public BinaryTree() {
		size = 0;
	}
	
	public void add (String newKey, String newValue) {
		size ++;
		Node newNode =  new Node();
		newNode.setKey(newValue);
		newNode.setValue(newKey);
		
		if (root == null) {
			root = newNode;
		} else {
			insert(newNode, root);
		}
	}
	
	private void insert(Node insertNode, Node rootNode) {
		if (insertNode.compareTo(rootNode) > 0) {
			if (rootNode.getRight() == null) {
				rootNode.setRight(insertNode);
			} else {
				insert(insertNode, rootNode.getRight());
			}
			
		} else {
			if (rootNode.getLeft()== null) {
				rootNode.setLeft(insertNode);
			} else {
				insert(insertNode, rootNode.getLeft());
			}
		}
	}
	
	public List< List<Node> > BSF () {
		List< List<Node> > result = new ArrayList<List<Node>>();
		List<Node> upperLevel = new ArrayList<Node>();
		if (root != null) {
			upperLevel.add(root);
			result.add(upperLevel);
			
			while (upperLevel.size() > 0) {
				List<Node> bootomLevel = new ArrayList<Node>();
				for (int i = 0; i < upperLevel.size(); i++) {
					Node left = upperLevel.get(i).getLeft();
					Node right = upperLevel.get(i).getRight();
					if (left != null) {
						bootomLevel.add(left);
					}
					if (right != null) {
						bootomLevel.add(right);
					}
				}
				result.add(bootomLevel);
				upperLevel = bootomLevel;
			};
	
		}
		return result;
	}

	
}
