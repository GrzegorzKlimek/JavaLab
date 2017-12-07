package model;

public class Node implements Comparable <Node>   {
	
	private String key;
	private String value;
	private Node left;
	private Node right;

	public String getKey() {
		return key;
	}

	public void setKey(String value) {
		this.key = value;
	}


	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public int compareTo(Node o) {
		return key.compareTo(o.getKey());
	}
	

}
