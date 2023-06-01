package quizshow;

import java.util.Scanner;

public class QuizUI {

    QuizService service;
    Scanner scanner;

    public QuizUI(QuizService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }
    public void startShow(){
        Quiz quiz = service.getNext();

        System.out.println(quiz.getQuestion());

        String userAnswer = scanner.next();

        if(quiz.checkAnswer(userAnswer)){
            System.out.println("정답입니다");
        }else{
            System.out.println("안녕");
            return;
        }
        startShow();
    }


}
