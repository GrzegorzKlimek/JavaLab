package view;

import data.Poll;
import logic.PollsManager;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;

public abstract class PollDoer {

    protected PollsManager controller;
    protected BufferedReader bufferedReader;

    protected PollDoer(PollsManager controller, BufferedReader bufferedReader) {
        this.controller = controller;
        this.bufferedReader = bufferedReader;
    }

    public static String [] tail (String [] commands) {

        return Arrays.copyOfRange(commands, 1,commands.length);
    }

    abstract public void doJob  (String [] commands);

    protected boolean validateCommand(String [] commands, String expectedCommand, int expectedNumberOfArguments) {

        boolean isCommandsLengthValid = commands.length > 0;
        boolean isCommandAccurate = commands[0].equals(expectedCommand);
        boolean accurateNumOfArguments = commands.length - 1 == expectedNumberOfArguments;

        if (!isCommandAccurate || !isCommandsLengthValid) {
            System.out.println(CommandLineView.WRONG_COMMANT_MESSAGE);
        }

        if(!accurateNumOfArguments) {
            System.out.println(CommandLineView.WRONG_NUMBER_OF_ARGUMENTS);
        }

        return isCommandsLengthValid && isCommandAccurate && accurateNumOfArguments;

    }

    protected  boolean validateIDInput(List<Poll> polls, String strId) {
        boolean result = false;
        try {
            int id = Integer.parseInt(strId);
            polls.get(id -1);
            result = true;

        } catch (NumberFormatException exeption) {
            System.out.println("insert number as id!");
        } catch (IndexOutOfBoundsException exeption) {
            System.out.println("There are no poll with such id!");
        } finally {
            return result;
        }

    }
    protected Poll getPoll (String [] commands) {
        if (!validateCommand( commands, "id", 1)) {
            return null;
        }
        List <Poll> polls = controller.getPolls();
        String pollStrId = commands[1] ;

        if (!validateIDInput(polls , pollStrId)) {
            return null;
        }

        int pollID = Integer.parseInt(pollStrId) - 1;
        return polls.get(pollID);

    }
}
