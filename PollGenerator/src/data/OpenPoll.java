package data;

import java.util.List;

public class OpenPoll extends Poll {
    List<String> answers;

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        String newLine = System.lineSeparator();

        stringBuilder.append(super.toString());

        if (answers != null) {

            for (String answer : answers) {
                stringBuilder.append(answer).append(newLine);
            }
        }
        return stringBuilder.toString();
    }

}
