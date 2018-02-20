package com.leadercoach.rest.services.entity;

import org.mongodb.morphia.annotations.Embedded;

/**
 * To get all questions
 * @author CodaGlobal
 */
@Embedded
public class QuestionsEntity {

	private String questionId;
	private String[] question;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String[] getQuestion() {
		return question;
	}

	public void setQuestion(String[] question) {
		this.question = question;
	}

	public QuestionsEntity(String questionId, String[] question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public QuestionsEntity() {

	}
}
