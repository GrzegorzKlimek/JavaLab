package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import logic.PollsManager;

public class ConsoleView {
	
	private BufferedReader br;
	private PollsManager pollsManager;
	private final String WELCOME_USER_MESS = "Welcome to our Poll program. "
			+ "Do you want to anser to some poll or to create one?"
			+ "choose 'a' to answer or 'p' to make new poll";

	
	public ConsoleView(PollsManager pollsManager) {
		this.pollsManager = pollsManager;
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	public void run () throws IOException {
		System.out.println(WELCOME_USER_MESS);
		String userInput = br.readLine();
		
		switch (userInput) {
		case "a" :
			new ConAnswerPollView(pollsManager).run();
			break;
		case "p":
			new ConMakeNewPollView(pollsManager).run();
			break;
		default:
			break;
		}
	}

}
