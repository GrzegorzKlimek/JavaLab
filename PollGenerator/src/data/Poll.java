package data;

import java.util.HashMap;
import java.util.Map;

public class Poll {

	private String question;

	private Map<String, Integer> options;

	public Poll() {
		options = new HashMap<String, Integer>();
	}

	public void addOption(String option) {
		if (!options.containsKey(option)) {
			options.put(option, 1);
		}
	}
	
	public void vote (String option) {
		int currrentCount = options.containsKey(option) ? options.get(option) + 1 : 1;
		options.put(option, currrentCount);
	}
	
	public void vote (int option) {
		int currrentCount = options.containsKey(option) ? options.get(option) + 1 : 1;
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Map<String, Integer> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Integer> options) {
		this.options = options;
	}

}
