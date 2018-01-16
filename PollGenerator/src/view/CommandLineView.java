package view;

import data.ClosePoll;
import data.OpenPoll;
import data.Option;
import data.Poll;
import logic.PollsManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandLineView {

    private static String WRONG_COMMANT_MESSAGE = "Not understandeble command";
    private static String WRONG_NUMBER_OF_ARGUMENTS = "Wrong number of customers";
    private PollsManager controller;
    private BufferedReader bufferedReader;

    public  CommandLineView () {
        controller = new PollsManager();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    public void run()  {
        String[] commands = {""};
        try {
            while (true) {
                commands = readCommandFromUSer();
                executeCommand(commands);
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {

        }
    }

    private String[] readCommandFromUSer() throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String commandLine = bufferReader.readLine();
        return commandLine.split(" ");

    }

    private void executeCommand(String[] commands) throws IOException {
        String firstCommand = commands[0];

        switch (firstCommand) {
            case "add":
                adding(tail(commands));
                break;
            case "list":

                break;
            case "vote":

                break;
            default:
                System.out.println(WRONG_COMMANT_MESSAGE);
        }
    }

    private String [] tail (String [] commands) {
        return Arrays.copyOfRange(commands, 1,commands.length);
    }



    private void adding(String[] commands) throws IOException {
        if (commands.length < 2) {
            System.out.println(WRONG_NUMBER_OF_ARGUMENTS);
        } else if (commands[0].equals("poll")) {
            addPoll(tail(commands));
        } else {
            System.out.println(WRONG_COMMANT_MESSAGE);
        }
    }

    private void addPoll (String[] commands) throws IOException {
        if (commands.length < 2) {
            System.out.println(WRONG_NUMBER_OF_ARGUMENTS);
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
                System.out.println(WRONG_COMMANT_MESSAGE);
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


