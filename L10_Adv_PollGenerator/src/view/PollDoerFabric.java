package view;

import logic.PollsManager;

import java.io.BufferedReader;

public class PollDoerFabric {

    public PollDoer produce (String command, PollsManager controller, BufferedReader bufferedReader) {
        PollDoer product = null;
        switch (command) {
            case "add":
                product = new PollAdder(controller, bufferedReader);
                break;
            case "list":
                product = new PollLister(controller, bufferedReader);
                break;
            case "answer":
                product = new PollAnswerer(controller, bufferedReader);
                break;
            default:
                product = null;
        }
        return product;
    }
}
