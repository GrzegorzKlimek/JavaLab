package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node<K, V> root;

    private int size;

    public MyTreeMap() {
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public V put(K newKey, V newValue) {
        Node<K, V> newNode = new Node();
        newNode.setKey(newKey);
        newNode.setValue(newValue);

        if (root == null) {
            root = newNode;
            size++;
        } else {
            return insert(newNode, root);
        }
        return null;
    }

    @Override
    public V get(Object key) {

        Node<K, V> nodeWithKey = root != null ? getToNodeWithKey((K) key, root) : null;
        return nodeWithKey != null ? nodeWithKey.getValue() : null;
    }


    @Override
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

        List<List<Node<K, V>>> nodes = BSF();
        for (int i = 0; i < nodes.size(); i++) {
            List<Node<K, V>> row = nodes.get(i);
            for (int j = 0; j < row.size(); j++) {
                result.append(row.get(j) + " | ");
            }
            result.append(NEW_LINE);
        }

        return result.toString();

    }

    @Override
    public boolean containsValue(Object value) {
        List<List<Node<K, V>>> twoDimensionalListOfNodes = BSF();
        for (List<Node<K, V>> row : twoDimensionalListOfNodes) {
            for (Node<K, V> node : row) {
                if (node.getValue().equals(value)) {
                    return true;
                }
            }
        }

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
        //TODO
        return null;
    }


    private V insert(Node<K, V> insertNode, Node<K, V> rootNode) {

        int difference = insertNode.compareTo(rootNode);

        if (difference < 0) {
            if (rootNode.getLeft() == null) {
                rootNode.setLeft(insertNode);
                insertNode.setFather(rootNode);
                size++;
            } else {
                insert(insertNode, rootNode.getLeft());
            }
        } else if (difference == 0) {

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
        return null;


    }

    private Node<K, V> getToNodeWithKey(K key, Node<K, V> currentNode) {

        int difference = key.compareTo(currentNode.getKey());

        if (difference == 0) {
            return currentNode;
        } else if (difference > 0) {
            return currentNode.getRight() != null ? getToNodeWithKey(key, currentNode.getRight()) : null;

        } else {
            return currentNode.getLeft() != null ? getToNodeWithKey(key, currentNode.getLeft()) : null;

        }

    }

    private List<List<Node<K, V>>> BSF() {
        List<List<Node<K, V>>> result = new ArrayList<>();
        List<Node<K, V>> upperLevel = new ArrayList<>();
        if (root != null) {
            upperLevel.add(root);
            result.add(upperLevel);

            while (upperLevel.size() > 0) {
                List<Node<K, V>> bootomLevel = new ArrayList<>();
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
            }

        }
        return result;
    }


}
