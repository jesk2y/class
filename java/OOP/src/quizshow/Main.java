package quizshow;

public class Main {

    public static void main(String[] args) {

        QuizService service = new QuizService();

        service.addQuize(new Quiz("도라에몽의 나이는?", "65"));
        service.addQuize(new Quiz("루피의 나이는?", "19"));
        service.addQuize(new MultipleChoiceQuize("4대 문이 아닌 것은?", "B", new String[]{"A", "B", "C"}));
        service.addQuize(new SubjectiveQuiz("빈센트 노래의 주인공은 누구인가?", "Vincent Van Gohg","고흐"));

        QuizUI ui= new QuizUI(service);

        ui.startShow();
    }
}
