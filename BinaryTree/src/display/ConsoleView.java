package display;

import java.util.List;
import java.util.Random;

import model.BinaryTree;
import model.Node;

public class ConsoleView {
	public static void main (String [] args) {
		BinaryTree tree = new BinaryTree();
		
		String [] keys = {"u", "ga", "yh", "kf", "g", "z"};
		String [] values = {"5", "6", "7", "8", "9", "10"};
		for (int i = 0; i < keys.length; i++) {

			tree.put(keys[i], values[i]);
		}
		System.out.println();

		
		tree.print();
		System.out.println(tree.get("ga"));


	}

}
