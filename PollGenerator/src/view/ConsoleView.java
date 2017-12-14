package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.management.OperationsException;

import data.Poll;

public class ConsoleView {
	
	private final String ADD_OPTION_MESS = "Add option to poll or type 'exit' to sumbit poll";
	private final String ADD_QUESTION_MESS = "Add question to poll" ;
	private final String EXIT_MESS = "exit";
	private final String WRONG_INPUT_MESS = "Wrong input. Try again!";
	private List<Poll> polls;
	
	public ConsoleView () {
		polls = new ArrayList<Poll>();
	}
	
	public void run () throws IOException {
		System.out.println("Press '1' to make new poll. Press '2' to vote on some poll");
		while (true) {
			String input = br.readLine();
			
			switch (input) {
			case "1":
				addNewPoll();
				break;
			case "2":
				break;
			default:
				System.out.println(WRONG_INPUT_MESS);
			}
			
		}
	}
	
	private void voteInPoll(int index) throws NumberFormatException, IOException {
		
		Poll poll = polls.get(index);
		
		System.out.println(poll.getQuestion());
		
		Set< Map.Entry<String, Integer> > options = poll.getOptions().entrySet();
		
		int i = 1;
		for (Map.Entry<String, Integer> entry: options) {
			System.out.println("Option " + i + " " + entry.getKey());
			i++;
		}
		
		String answer = br.readLine();
		
		poll.vote(answer);
	}
	
	private void choosePollToVote () throws NumberFormatException, IOException {
		int n = polls.size();
		
		int numberOfPoll;
		boolean outOfRange;
		
		do {
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append("Poll nr: ").append(i).append("question: ");
				sb.append(polls.get(i).getQuestion());
				System.out.println(sb.toString());
			}
			
			System.out.println("Choose number of poll to vote");
			 numberOfPoll = Integer.parseInt( br.readLine());
			 
			 outOfRange = numberOfPoll < 0 || numberOfPoll > n;
			 
			 if (outOfRange) {
				 System.out.println(WRONG_INPUT_MESS);
			 } else {
				 voteInPoll(numberOfPoll);
			 }
			
		} while(outOfRange);
		
		
	}
	
	private BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public void addNewPoll () throws IOException {
		boolean isPollComplete = false;
		Poll poll = new Poll();
		System.out.println(ADD_QUESTION_MESS);
		
		while (!isPollComplete) {
			System.out.println(ADD_OPTION_MESS);
			String input = br.readLine();
			
			if (input.equals(EXIT_MESS)) {
				isPollComplete = true;
			} else {
				poll.addOption(input);
			}
		}
		
		polls.add(poll);
	}

}
