package data;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Poll {
	static int globalID = 1;
	protected String question;
	private  int id;

	public Poll() {
		id = globalID;
		globalID ++;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		String newLine = System.lineSeparator();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" Poll id =").append(id);
		stringBuilder.append(newLine);
		stringBuilder.append("Question: ").append(question).append(".");
		return stringBuilder.toString();
	}

}
