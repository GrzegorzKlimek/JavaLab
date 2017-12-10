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
	
	public int size() {
		return size;
	}
	
	public void put (String newKey, String newValue) {
		Node newNode =  new Node();
		newNode.setKey(newKey);
		newNode.setValue(newValue);
		
		if (root == null) {
			root = newNode;
			size ++;
		} else {
			insert(newNode, root);
		}
	}
	
	public String get (String key) {
		String result = root != null ? findValueForKey(key, root): null;
		return result;
	}
	
	public boolean cointainsKey (String key) {
		return get(key) != null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private String findValueForKey (String key, Node currentNode) {
		int diffrence = key.compareTo(currentNode.getKey());
		String result;
		if (diffrence == 0) {
			result = currentNode.getValue();
		} else if (diffrence > 0) {
			 result = currentNode.getRight() != null ? findValueForKey(key, currentNode.getRight()) : null;
			
		} else {
			result = currentNode.getLeft() != null ? findValueForKey(key, currentNode.getLeft()) : null;
			
		}
		return result;
	}
	
	private void insert(Node insertNode, Node rootNode) {
		
		int diffrence = insertNode.compareTo(rootNode);

		if (diffrence < 0) {
			if (rootNode.getLeft() == null) {
				rootNode.setLeft(insertNode);
				insertNode.setFather(rootNode);
				size++;
			} else {
				insert(insertNode, rootNode.getLeft());
			}
		} else if (diffrence == 0) {

			rootNode.setValue(insertNode.getValue());
		} else {

			if (rootNode.getRight() == null) {
				rootNode.setRight(insertNode);
				insertNode.setFather(rootNode);
				size++;
			} else {
				insert(insertNode, rootNode.getRight());
			}

		}
		
		
	}
	
	private List< List<Node> > BSF () {
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
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    
	    List<List<Node>> nodes = BSF();
		for (int i = 0; i < nodes.size(); i++) {
			List<Node> row = nodes.get(i);
			for(int j = 0; j < row.size(); j++) {
				result.append(row.get(j) + " | ");
			}
			result.append(NEW_LINE);
		}
		
		return result.toString();
	    
	}

	
}
