package domain;

public class Quiz {

	private int qno;
	private String text;
	private String option;
	private String answer;
	
	
	public Quiz(int qno, String text, String option, String answer) {
		super();
		this.qno = qno;
		this.text = text;
		this.option = option;
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "Quiz [qno=" + qno + ", text=" + text + ", option=" + option + ", answer=" + answer + "]";
	}


	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
		
}
