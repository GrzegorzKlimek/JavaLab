package view;

import java.util.List;

import data.Poll;
import logic.PollsManager;

public class ConAnswerPollView {

	private PollsManager pollManager;
	
	public ConAnswerPollView (PollsManager pollManager) {
		this.pollManager = pollManager;
	}
	
	public void listPolls () {
		List<Poll> polls  = pollManager.getPolls();
		for (int i = 0; i < polls.size(); i++ ) {
			StringBuilder stringBuilder = new StringBuilder();
			Poll poll = polls.get(i);
			stringBuilder.append( String.valueOf(i) ).append(" ").append(poll.getQuestion());
			System.out.println(stringBuilder.toString());
		}
	}
	
	public void run () {
		
		listPolls();
		
	}

}
