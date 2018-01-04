package logic;

import java.util.ArrayList;
import java.util.List;

import data.Poll;

public class PollsManager {
	private List<Poll> polls;
	
	public PollsManager() {
		polls = new ArrayList <Poll> ();
	}
	public void addNewPoll (Poll poll) {
		polls.add(poll);
	}
	public List<Poll> getPolls() {
		return polls;
	}
	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}

}
