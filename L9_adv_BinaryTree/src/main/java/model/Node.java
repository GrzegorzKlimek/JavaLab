package model;

public class Node< K extends Comparable<K> , V> implements Comparable<Node < K , V> > {

    private K key;
    private V value;
    private Node left;
    private Node right;
    private Node father;

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public V getValue() {

        return value;
    }

    public void setValue(V value) {

        this.value = value;
    }


    public K getKey() {

        return key;
    }

    public void setKey(K key) {

        this.key = key;
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

    public boolean isChild() {

        return father != null;
    }

    public boolean isLeftChild() {

        return isChild() && father.getLeft() == this;
    }

    public boolean isRightChild() {

        return isChild() && father.getRight() == this;
    }

    @Override
    public int compareTo(Node <K, V> o) {
        return key.compareTo(o.getKey());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isLeftChild()) {
            sb.append("L");
        }

        if (isRightChild()) {
            sb.append("R");
        }
        sb.append("Node: ").append("k:").append(key).append(", ").append("v:").append(value);
        return sb.toString();
    }


}
