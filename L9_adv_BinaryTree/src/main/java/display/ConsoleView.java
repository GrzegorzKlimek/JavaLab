package display;

import model.MyTreeMap;

public class ConsoleView {
	public static void main (String [] args) {
		
		
		 MyTreeMap tree = new MyTreeMap();
		

		
		String [] keys = {"u", "ga", "yh", "kf", "g", "z"};
		String [] values = {"5", "6", "7", "8", "9", "10"};
		for (int i = 0; i < keys.length; i++) {

			tree.put(keys[i], values[i]);
		}
		
		System.out.println(tree);



	}

}
