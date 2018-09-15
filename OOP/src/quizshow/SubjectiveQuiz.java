package quizshow;
public class SubjectiveQuiz extends Quiz {

    private String other;

    public SubjectiveQuiz(String text, String answer, String other) {
        super(text, answer);
        this.other = other;
    }
}
