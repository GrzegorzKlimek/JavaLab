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
import logic.PollsManager;

public class ConsoleView {
	
	private final String ADD_OPTION_MESS = "Add option to poll or type 'exit' to sumbit poll";
	private final String ADD_QUESTION_MESS = "Add question to poll" ;
	private final String EXIT_MESS = "exit";
	private final String WRONG_INPUT_MESS = "Wrong input. Try again!";
	private BufferedReader br;
	private PollsManager pollsManager;
	
	public ConsoleView (PollsManager pollsManager) {
		br = new BufferedReader(new InputStreamReader(System.in));
		pollsManager = pollsManager;
	}
	
	
	public void run () {
		
	}
	

}
