import static org.junit.Assert.assertEquals;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;


import model.MyTreeMap;

public class TestBST {
	
	private MyTreeMap testedEntity;
	private Map<String, String> mock;
	private Set<Entry<String,String>> mockEntries;
	private static int numberOfTest = 1000;
	private Random rg;
	

	public TestBST () {
	
		rg = new Random();
		mock = new TreeMap<String, String>();
		mockEntries = mock.entrySet();
		testedEntity = new MyTreeMap();
		for (int i = 0; i < numberOfTest  ; i++) {
			String newKey = genRandString(rg.nextInt(20));
			String newValue = genRandString(rg.nextInt(20));
			mock.put(newKey, newValue);
			testedEntity.put(newKey, newValue);
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
	public void containsTest() {
		 for (Entry<String, String> entry : mockEntries) {
			 assertEquals(true, testedEntity.containsKey(entry.getKey()));
		 }
	}
	
	@Test
	public void valuesTest() {
		for (Entry<String, String> entry : mockEntries) {
			 assertEquals(entry.getValue(), testedEntity.get(entry.getKey()));
		 }
	}
	


}
