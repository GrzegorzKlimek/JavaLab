import static org.junit.Assert.assertEquals;


import java.util.*;
import java.util.Map.Entry;

import org.junit.Test;


import model.MyTreeMap;

public class TestBST {
	
	private Map<String, Integer>  testedEntity;
	private Map<String, Integer> mock;
	private List<String> keys;
	private  List<Integer> values;

	private static int numberOfTest = 1000;
	private Random rg;
	

	public TestBST () {
	
		rg = new Random();
		mock = new TreeMap();
		testedEntity = new MyTreeMap();
		keys = new ArrayList<>();
		values = new ArrayList<>();
		for (int i = 0; i < numberOfTest  ; i++) {
			String newKey = genRandString(rg.nextInt(20));
			int newValue = rg.nextInt(20);
			mock.put(newKey, newValue);
			testedEntity.put(newKey, newValue);
			keys.add(newKey);
			values.add(newValue);
		}
		
	}
	
	
	private String genRandString (int stringLenght) {
		if  (stringLenght == 0) {return ""; }
		char [] randCharAcc = new char [stringLenght];
		for (int i = 0; i < stringLenght; i++) {
			char randChar = rg.nextBoolean() ? (char) rg.nextInt(48) : (char) (49 + rg.nextInt(128 - 49));
			randCharAcc[i] = randChar;
		}
		
		return String.copyValueOf(randCharAcc);
	}
	

	@Test
	public void sizeTest () {

		assertEquals(mock.size(), testedEntity.size());
	}
	
	@Test
	public void containsKeyTest() {
		 for (String key : keys) {
			 assertEquals(mock.containsKey(key), testedEntity.containsKey(key));
		 }
	}
	
	@Test
	public void containsValueTest() {
		for (Integer value : values) {
			 assertEquals( "for value: " + value ,mock.containsValue(value), testedEntity.containsValue(value));
		 }
	}

	@Test
	public void getTest() {
		for (String key : keys) {
			assertEquals(mock.get(key), testedEntity.get(key));
		}
	}
	


}
