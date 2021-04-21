package com.example.testpress_test.Model;

import java.util.ArrayList;
import java.util.List;

public class Question_Model {
	private List  qid = new ArrayList();
	private List question = new ArrayList(); ;
	private List choices = new ArrayList();
	private List answers = new ArrayList();
	public Question_Model(List qid, List question, List choices, List answers) {
		super();
		this.qid = qid;
		this.question = question;
		this.choices = choices;
		this.answers = answers;
	}
	
	

	public List getQid() {
		return qid;
	}



	public void setQid(List qid) {
		this.qid = qid;
	}



	public List getQuestion() {
		return question;
	}



	public void setQuestion(List question) {
		this.question = question;
	}



	public List getChoices() {
		return choices;
	}
	public void setChoices(List choices) {
		this.choices = choices;
	}
	public List getAnswers() {
		return answers;
	}
	public void setAnswers(List answers) {
		this.answers = answers;
	}
	
	
	
	
	
}
