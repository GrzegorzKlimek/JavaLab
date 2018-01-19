package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyTreeMap < K extends Comparable<K> , V> implements Map<K, V>  {
	
	private Node <K, V> root;
	
	private int size;
	
	public MyTreeMap() {
		size = 0;
	}
	
	public int size() {
		return size;
	}

	@Override
	public V put (K newKey, V newValue) {
		Node <K, V> newNode =  new Node ();
		newNode.setKey(newKey);
		newNode.setValue(newValue);
		
		if (root == null) {
			root = newNode;
			size ++;
		} else {
			return insert(newNode, root);
		}
		return null;
	}
	
	@Override
	public V get (Object key) {
		V result = root != null ? findValueForKey((K)key, root): null;
		return result;
	}

	private V findValueForKey (K key, Node <K, V> currentNode) {
		int difference = key.compareTo(currentNode.getKey());
		V result;
		if (difference == 0) {
			result = currentNode.getValue();
		} else if (difference > 0) {
			result = currentNode.getRight() != null ? (V) findValueForKey(key, currentNode.getRight()) : null;

		} else {
			result = currentNode.getLeft() != null ? (V) findValueForKey(key, currentNode.getLeft()) : null;

		}
		return result;
	}
	
	
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public boolean containsKey(Object key) {
		return get(key) != null;
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
	@Override
	public boolean containsValue(Object value) {

		//TODO
		return false;
	}
	
	
	@Override
	public V remove(Object key) {
		//TODO
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		//TODO
	}

	@Override
	public void clear() {
		//TODO
	}

	@Override
	public Set<K> keySet() {
		//TODO
		return null;
	}

	@Override
	public Collection<V> values() {
		//TODO
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}


	private V insert(Node <K,V> insertNode, Node <K,V> rootNode) {

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
		return  null;


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


	
}
