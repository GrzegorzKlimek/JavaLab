package display;

import java.util.List;
import java.util.Random;

import model.BinaryTree;
import model.Node;

public class ConsoleView {
	public static void main (String [] args) {
		BinaryTree tree = new BinaryTree();
		
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			String key = Integer.toString(r.nextInt(65));
			String value = Integer.toString(r.nextInt(65));
			tree.add(key, value);
		}
		List<List<Node>> listOfTree = tree.BSF();
		System.out.println(listOfTree);
	}

}
