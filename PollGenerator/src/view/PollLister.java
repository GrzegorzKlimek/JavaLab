package view;

import data.Poll;
import logic.PollsManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class PollLister {

    private PollsManager controller;
    private BufferedReader bufferedReader;

    public PollLister (PollsManager controller , BufferedReader bufferedReader) {
        this.controller = controller;
        this.bufferedReader = bufferedReader;
    }
    public void list (String[] commands) throws IOException {
        if (commands.length < 1) {
            System.out.println(ViewUtilis.WRONG_NUMBER_OF_ARGUMENTS);
        }
        String command = commands[0];
        switch (command) {
            case "poll":
                listPoll(ViewUtilis.tail(commands));
                break;
            case "polls":
                listPolls();
                break;
            default:
                System.out.println(ViewUtilis.WRONG_COMMANT_MESSAGE);
        }
    }

    private void listPolls () {
        List <Poll> polls = controller.getPolls();
        for (Poll poll : polls) {
            System.out.println(poll);
        }
    }

    private void listPoll (String[] commands) {
        if (commands.length < 2) {
            System.out.println(ViewUtilis.WRONG_NUMBER_OF_ARGUMENTS);
            return;
        }

        String comand = commands[0];

        if (!comand.equals("id")) {
            System.out.println(ViewUtilis.WRONG_COMMANT_MESSAGE);
            return;
        }

        try {
        int id =Integer.parseInt(commands[1]);

        Poll poll = controller.getPolls().get(id -1);
        System.out.println(poll);
        } catch (NumberFormatException exeption) {
            System.out.println("insert number as id!");
        } catch (IndexOutOfBoundsException exeption) {
            System.out.println("There are no poll with such id!");
        }


    }
}
