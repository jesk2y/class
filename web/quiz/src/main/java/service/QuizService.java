package service;

import domain.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizService {
	
	private List<Quiz> quizList;

	public QuizService() {
		
		quizList = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			quizList.add(new Quiz(i, "문제"+i, "보기1,보기2..","1"));
		}
		
	}
	
	public Quiz getQuiz(int qno) throws Exception{
		
		return quizList.get(qno -1);
	}
	
	

}
