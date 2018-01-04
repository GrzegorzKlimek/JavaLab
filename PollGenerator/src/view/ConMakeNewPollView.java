package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import data.ClosePoll;
import data.OpenPoll;
import data.Option;
import data.Poll;
import logic.PollsManager;

public class ConMakeNewPollView {
	
	private PollsManager pollsManager;
	private final String  POLL_OPTION_MESSEAGE = "Choose option of messege. 'o' for open and 'c' for close";
	private final String WRONG_INPUT_MESSEAGE = "Wrong input";
	private final String POLL_QUESTION_MESSEAGE = "Insert question to the poll";
	private final String GET_NUM_FROM_USER = "insert number of options in poll";
	private BufferedReader br;
	
	public ConMakeNewPollView (PollsManager pollsManager) {
		this.pollsManager = pollsManager;
		br = new BufferedReader(new InputStreamReader( System.in));
	}
	
	private Option getOptionFromUser() throws IOException {
		System.out.println("Insert Option to poll");
		String optionContent = br.readLine();
		Option newOption = new Option();
		newOption.setContent(optionContent);
		return newOption;
	}
	
	private List <Option> getOptionsFromUser (int numberOfOptions) throws IOException {
		List<Option> options = new ArrayList<>();
		for (int i = 0; i < numberOfOptions; i++ ) {
			options.add(getOptionFromUser());
		}
		return options;
	}
	
	private String getQuestionFromUser() throws IOException {
		System.out.println(POLL_QUESTION_MESSEAGE);
		return br.readLine();
	}
	
	private int getNumberFromUser() throws IOException {
		System.out.println();
		String input = br.readLine();
		System.out.println(GET_NUM_FROM_USER);
		return Integer.parseInt(input);
	}
	
	private Poll makeNewPollFromUserInput() throws IOException {
		System.out.println(POLL_OPTION_MESSEAGE);
		String userInput;
		Poll poll;
		do {
			userInput = br.readLine();
		switch(userInput) {
		case "o" :
			poll = new OpenPoll() ;
			break;
		case "c" : 
			poll = new ClosePoll();
			break;
		default:
				poll = null;
				System.out.println(WRONG_INPUT_MESSEAGE);
				break;
			}
		} while (poll == null);
		
		
		poll.setQuestion(getQuestionFromUser());
		return poll;
	}
	
 
	
	public void run () throws IOException {

		Poll poll = makeNewPollFromUserInput();
	
		
		if ( poll instanceof ClosePoll) {
			 ((ClosePoll) poll).setOptions(getOptionsFromUser (getNumberFromUser()));
		}
		
		pollsManager.addNewPoll(poll);
		
	}
	
	
}
