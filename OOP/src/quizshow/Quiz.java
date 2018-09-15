package quizshow;

public class Quiz {

    String text;
    String answer;

    public Quiz(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getQuestion(){
        return this.text;
    }

    public boolean checkAnswer(String userAnswer){
        return this.answer.equals(userAnswer);
    }
}
