package data;

import java.util.ArrayList;
import java.util.List;

public class OpenPoll extends Poll {
    List<String> answers;

    public OpenPoll () {
        answers = new ArrayList<String>();
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        String newLine = System.lineSeparator();

        stringBuilder.append(super.toString());

        if (answers != null) {
            stringBuilder.append(newLine);
            stringBuilder.append("Answers of people: ").append(newLine);
            int i = 1;
            for (String answer : answers) {
                stringBuilder.append(i).append(") ").append(answer).append(newLine);
                i++;
            }
        }
        return stringBuilder.toString();
    }

}
