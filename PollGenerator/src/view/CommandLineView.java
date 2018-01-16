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


    private PollsManager controller;
    private BufferedReader bufferedReader;
    private  PollAdder pollAdder;
    private  PollLister pollLister;

    public  CommandLineView () {
        controller = new PollsManager();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        pollAdder = new PollAdder(controller, bufferedReader);
        pollLister = new PollLister(controller, bufferedReader);
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
                adding(ViewUtilis.tail(commands));
                break;
            case "list":
                pollLister.list(ViewUtilis.tail(commands));
                break;
            case "vote":

                break;
            default:
                System.out.println(ViewUtilis.WRONG_COMMANT_MESSAGE);
        }
    }


    private void adding(String[] commands) throws IOException {
        if (commands.length < 2) {
            System.out.println(ViewUtilis.WRONG_NUMBER_OF_ARGUMENTS);
        } else if (commands[0].equals("poll")) {
            pollAdder.addPoll(ViewUtilis.tail(commands));
        } else {
            System.out.println(ViewUtilis.WRONG_COMMANT_MESSAGE);
        }
    }





}


