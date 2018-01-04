package data;

import java.util.List;

public class OpenPoll extends Poll {
	List <String> answers;

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}
