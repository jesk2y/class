package org.zerock.web;

import java.util.Arrays;

public class Quiz {

	private String text;
	private String[] options;
	private String answer;
	
	
	public Quiz(String text, String[] options, String answer) {
		super();
		this.text = text;
		this.options = options;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Quiz [text=" + text + ", options=" + Arrays.toString(options) + ", answer=" + answer + "]";
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
