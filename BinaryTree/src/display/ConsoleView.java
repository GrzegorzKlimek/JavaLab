package display;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.BinaryTree;
import model.Node;

public class ConsoleView {
	public static void main (String [] args) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext( new File ("beans.xml").getAbsolutePath());
		 BinaryTree tree= (BinaryTree) context.getBean("binaryTree");
		

		
		String [] keys = {"u", "ga", "yh", "kf", "g", "z"};
		String [] values = {"5", "6", "7", "8", "9", "10"};
		for (int i = 0; i < keys.length; i++) {

			tree.put(keys[i], values[i]);
		}
		
		System.out.println(tree);



	}

}
