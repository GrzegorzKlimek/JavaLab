package model;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BinaryTree    {
	
	private Node root;
	
	private int size;
	
	public BinaryTree() {
		size = 0;
	}
	
	public void add (String newValue) {
		size ++;
		Node newNode =  new Node();
		newNode.setKey(newValue);
		
		if (root == null) {
			root = newNode;
		} else {
			insert(root, newNode);
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

	
}
