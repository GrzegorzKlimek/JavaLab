package view;

import data.OpenPoll;
import logic.PollsManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CommandLineView {

    private static String WRONG_COMMANT_MESSAGE = "Not understandeble command";
    private static String WRONG_NUMBER_OF_ARGUMENTS = "Wrong number of customers";
    private PollsManager controller;
    private BufferedReader bufferedReader;

    public  CommandLineView () {
        controller = new PollsManager();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    public void run() {

    }

    private String[] readCommandFromUSer() throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String commandLine = bufferReader.readLine();
        return commandLine.split(" ");

    }

    private void executeCommand(String[] commands) {
        String firstCommand = commands[0];

        switch (firstCommand) {
            case "add":

                break;
            case "list":

                break;
            case "vote":

                break;
            default:
                System.out.println(WRONG_COMMANT_MESSAGE);
        }
    }

    private void adding(String[] commands) {
        if (commands.length < 2) {
            System.out.println(WRONG_NUMBER_OF_ARGUMENTS);
        } else if (commands[0].equals("poll")) {

        } else {
            System.out.println(WRONG_COMMANT_MESSAGE);
        }
    }

    private void addPoll (String[] commands) {
        if (commands.length < 2) {
            System.out.println(WRONG_NUMBER_OF_ARGUMENTS);
        }
        String command = commands[0];
        switch (command) {
            case "open":
                break;
            case "close":
                break;
            default:
                System.out.println(WRONG_COMMANT_MESSAGE);
        }
    }

    private void addOpenPoll (String [] commands) throws IOException {
        System.out.println("Add question to the poll");
        String question = bufferedReader.readLine();
        OpenPoll openPoll = new OpenPoll();
        openPoll.setQuestion(question);
        controller.addNewPoll(openPoll);

    }

    private void addClosePoll (String [] commands) {

    }

}


