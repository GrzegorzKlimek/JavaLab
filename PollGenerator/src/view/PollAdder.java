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

public class PollAdder extends PollDoer {

    public PollAdder(PollsManager controller, BufferedReader bufferedReader) {
        super(controller, bufferedReader);
    }

    @Override
    public void doJob(String[] commands) {
        if (!super.validateCommand(commands, "poll", 1)) {
            return;
        }
        String command = commands[1];

            switch (command) {
                case "open":
                    addOpenPoll();
                    break;
                case "close":
                    addClosePoll();
                    break;
                default:
                    System.out.println(CommandLineView.WRONG_COMMANT_MESSAGE);
            }

        }


    private Poll getPollWithQuestion(boolean isClose)  {
        System.out.println("Add question to the poll");
        Poll poll = null;
        String question = null;
        try {
            question = bufferedReader.readLine();
            poll = isClose ? new ClosePoll() : new OpenPoll();
        poll.setQuestion(question);
        } catch ( IOException exeption) {
            System.out.println(CommandLineView.WRONG_COMMANT_MESSAGE);
        }
        return poll;
    }

    private void addOpenPoll()  {

        OpenPoll openPoll = (OpenPoll) getPollWithQuestion(false);
        controller.addNewPoll(openPoll);

    }

    private void addClosePoll() {
        ClosePoll closePoll = (ClosePoll) getPollWithQuestion(true);
        List<Option> options = getPollOptions();
        if (options != null) {
        closePoll.setOptions(options);
        controller.addNewPoll(closePoll);
        } else {
            System.out.println(CommandLineView.WRONG_COMMANT_MESSAGE);
        }

    }

    private List<Option> getPollOptions() {
        System.out.println("Insert number of options in poll");
        int numberOfOptions = 0;
        List<Option> options = null;
        try {
            numberOfOptions = Integer.parseInt(bufferedReader.readLine());
            options = new ArrayList<Option>(numberOfOptions);
            for (int i = 0; i < numberOfOptions; i++) {
                options.add(getOption());
            }
        } catch (NumberFormatException exeption) {
            System.out.println("invalid number of options in poll");
        } catch ( IOException exeption) {
            System.out.println(CommandLineView.WRONG_COMMANT_MESSAGE);
        } finally {

        return options;
        }
    }



    private Option getOption() throws IOException {
        System.out.println("Insert option to poll");
        String contendOfOption = bufferedReader.readLine();
        Option newOption = new Option();
        newOption.setContent(contendOfOption);
        return newOption;
    }


}
