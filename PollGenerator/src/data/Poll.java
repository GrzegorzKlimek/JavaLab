package data;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Poll {

	protected String question;
	private  UUID id = UUID.randomUUID();
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

}
