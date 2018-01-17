package view;

import data.ClosePoll;
import data.OpenPoll;
import data.Option;
import data.Poll;
import logic.PollsManager;

import java.io.BufferedReader;
import java.io.IOException;

public class PollAnswerer extends PollDoer {

    public PollAnswerer(PollsManager controller, BufferedReader bufferedReader) {
        super(controller, bufferedReader);
    }

    @Override
    public void doJob(String[] commands) {
        Poll poll = super.getPoll(tail(commands));
        System.out.println(poll);

        if (poll == null) {
            return;
        }

        if (poll instanceof ClosePoll) {
            voteOnClosePoll((ClosePoll) poll);
        }

        if (poll instanceof OpenPoll) {
            voteOnOpenPoll((OpenPoll) poll);
        }

    }

    public void voteOnOpenPoll(OpenPoll openPoll) {

            System.out.println("Write anser to poll");
            String answer = null;
            try {
                answer = bufferedReader.readLine();
            } catch (IOException exception) {
               answer = null;
            } finally {
                if (answer != null) {
                openPoll.addAnswer(answer);
                } else {
                    System.out.println("You must enter some content of answer");
                }
            }
    }

    public void voteOnClosePoll(ClosePoll closePoll) {
        System.out.println("Chose opion of poll to vote");
        int indexOfOption = getIndex();
        if (validateIndex(closePoll, indexOfOption)) {
            getOptionOfPoll(closePoll, indexOfOption).vote();
        }
    }

    private Option getOptionOfPoll(ClosePoll closePoll, int indexOfPoll) {
        return closePoll.getOptions().get(indexOfPoll);

    }

    private boolean validateIndex(ClosePoll poll, int index) {
        return index > -1 && index < poll.getOptions().size();
    }

    private int getIndex() {
        int index = -1;
        try {
            index = Integer.parseInt(bufferedReader.readLine()) - 1;
        } catch (IOException exception) {
            System.out.println(CommandLineView.WRONG_COMMANT_MESSAGE);
            index = -1;
        } catch (NumberFormatException exception) {
            System.out.println("Not a number!");
            index = -1;
        } finally {
            return index;
        }
    }
}



