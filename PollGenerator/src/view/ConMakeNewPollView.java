package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.Option;
import logic.PollsManager;

public class ConMakeNewPollView {
	
	private PollsManager pollsManager;
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
	
	public void run () {
		
	}
	
}
