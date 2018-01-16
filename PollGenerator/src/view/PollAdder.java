package view;

import data.ClosePoll;
import data.OpenPoll;
import data.Option;
import data.Poll;
import logic.PollsManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PollAdder {
    private PollsManager controller;
    private BufferedReader bufferedReader;

    public PollAdder (PollsManager controller , BufferedReader bufferedReader) {
        this.controller = controller;
        this.bufferedReader = bufferedReader;
    }

    public void addPoll (String[] commands) throws IOException {
        if (commands.length != 1) {
            System.out.println(ViewUtilis.WRONG_NUMBER_OF_ARGUMENTS);
        }
        String command = commands[0];
        switch (command) {
            case "open":
                addOpenPoll();
                break;
            case "close":
                addClosePoll();
                break;
            default:
                System.out.println(ViewUtilis.WRONG_COMMANT_MESSAGE);
        }
    }

    private Poll getPollWithQuestion (boolean isClose) throws IOException {
        System.out.println("Add question to the poll");
        String question = bufferedReader.readLine();
        Poll poll = isClose ? new ClosePoll() : new OpenPoll();
        poll.setQuestion(question);
        return  poll;
    }

    private void addOpenPoll () throws IOException {

        OpenPoll openPoll = (OpenPoll) getPollWithQuestion(false);
        controller.addNewPoll(openPoll);

    }

    private void addClosePoll () throws IOException {
        ClosePoll closePoll = (ClosePoll) getPollWithQuestion(true);
        List<Option> options = getPollOptions();
        closePoll.setOptions(options);
        controller.addNewPoll(closePoll);

    }

    private List<Option> getPollOptions () throws IOException {
        System.out.println("Insert number of options in poll");
        int numberOfOptions = Integer.parseInt(bufferedReader.readLine());
        List<Option> options = new ArrayList<Option>(numberOfOptions);
        for (int i = 0; i < numberOfOptions; i++) {
            options.add(getOption());
        }
        return options;
    }

    private Option getOption () throws  IOException {
        System.out.println("Insert option to poll");
        String contendOfOption = bufferedReader.readLine();
        Option newOption = new Option();
        newOption.setContent(contendOfOption);
        return  newOption;
    }


}
