package view;

import data.Poll;
import logic.PollsManager;

import java.io.BufferedReader;
import java.io.IOException;

public class PollAnswerer extends PollDoer {

    public PollAnswerer(PollsManager controller, BufferedReader bufferedReader) {
        super(controller, bufferedReader);
    }
    @Override
    public void doJob(String[] commands)  {
        Poll poll = super.getPoll(commands);

        if (poll != null) {
            return;
        }



    }

}

