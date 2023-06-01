package quizshow;

import java.util.Arrays;

public class MultipleChoiceQuize extends Quiz{

    String[] options;

    @Override
    public String getQuestion() {
        return super.getQuestion() + "\n" + Arrays.toString(options);
    }

    public MultipleChoiceQuize(String text, String answer, String[] options) {
        super(text, answer);
        this.options = options;
    }
}
