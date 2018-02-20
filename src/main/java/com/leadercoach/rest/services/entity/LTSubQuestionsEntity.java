package com.leadercoach.rest.services.entity;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class LTSubQuestionsEntity {

	private String questionId;
	private String top;
	private String left;
	private String right;
	private String leftCode;
	private String rightCode;
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	
	public String getLeftCode() {
		return leftCode;
	}
	public void setLeftCode(String leftCode) {
		this.leftCode = leftCode;
	}
	
	public String getRightCode() {
		return rightCode;
	}
	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}
	
	@Override
	public String toString() {
		return "LTSubQuestions [questionId=" + questionId + ", top=" + top + ", left=" + left + ", right=" + right
				+ ", leftCode=" + leftCode + ", rightCode=" + rightCode + "]";
	}
	
}
