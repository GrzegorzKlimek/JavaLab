package view;

import data.Poll;
import logic.PollsManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class PollLister  extends PollDoer {


    public PollLister(PollsManager controller, BufferedReader bufferedReader) {
        super(controller, bufferedReader);
    }

    @Override
    public void doJob(String[] commands)  {
        if (commands.length < 1) {
            System.out.println(CommandLineView.WRONG_NUMBER_OF_ARGUMENTS);
            return;
        }
        String command = commands[0];
        switch (command) {
            case "poll":
                listPoll(tail(commands));
                break;
            case "polls":
                listPolls();
                break;
            default:
                System.out.println(CommandLineView.WRONG_COMMANT_MESSAGE);
        }
    }

    private void listPolls() {
        List<Poll> polls = controller.getPolls();
        for (Poll poll : polls) {
            System.out.println(poll);
        }
    }

    private void listPoll(String[] commands) {
        Poll poll = super.getPoll(commands);
        System.out.println(poll);
    }
}
