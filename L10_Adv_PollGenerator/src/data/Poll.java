package data;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Poll {
	static int globalID = 1;
	protected String question;
	private  int id;

	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void setID () {
		id = globalID;
		globalID ++;
	}

	@Override
	public String toString() {
		String newLine = System.lineSeparator();
		StringBuilder stringBuilder = new StringBuilder();
		String typeOfPoll = this instanceof OpenPoll ? "OPEN" : "CLOSE";
		stringBuilder.append(" Poll id =").append(id).append(" type: ").append(typeOfPoll);
		stringBuilder.append(newLine);
		stringBuilder.append("Question: ").append(question).append(".");
		return stringBuilder.toString();
	}

}
