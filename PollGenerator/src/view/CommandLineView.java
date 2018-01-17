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

    public static final String WRONG_COMMANT_MESSAGE = "Not understandeble command";
    public static final String WRONG_NUMBER_OF_ARGUMENTS = "Wrong number of arguments";

    private PollsManager controller;
    private BufferedReader bufferedReader;
    private  PollDoerFabric pollDoerFabric;


    public  CommandLineView () {
        controller = new PollsManager();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        pollDoerFabric = new PollDoerFabric();

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
        if (commands.length < 1) {
            System.out.println(WRONG_COMMANT_MESSAGE);
            return;
        }
        String firstCommand = commands[0];

        String [] restOfCommands = PollDoer.tail(commands);

        PollDoer pollDoer = pollDoerFabric.produce(firstCommand, controller, bufferedReader);

        if (pollDoer != null) {
            pollDoer.doJob(restOfCommands);
        } else {
            System.out.println(WRONG_COMMANT_MESSAGE);
            return;
        }
    }



}


