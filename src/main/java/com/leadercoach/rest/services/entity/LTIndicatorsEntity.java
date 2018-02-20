package com.leadercoach.rest.services.entity;

import java.util.Arrays;

public class LTIndicatorsEntity {

	private String indicatorId;
	private String colorCode;
	private String title;
	private String name;
	private String assessmentCode;
	private String withLeaderImageId;
	private String withoutLeaderImageId;
	private String defaultImageId;
	private String[] brand;
	private String quote;
	private String[] values;
	private String[] strengths;
	private String[] developmentAreas;
	
	public String getIndicatorId() {
		return indicatorId;
	}
	public void setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
	}
	
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAssessmentCode() {
		return assessmentCode;
	}
	public void setAssessmentCode(String assessmentCode) {
		this.assessmentCode = assessmentCode;
	}
	
	public String getWithLeaderImageId() {
		return withLeaderImageId;
	}
	public void setWithLeaderImageId(String withLeaderImageId) {
		this.withLeaderImageId = withLeaderImageId;
	}
	
	public String getWithoutLeaderImageId() {
		return withoutLeaderImageId;
	}
	public void setWithoutLeaderImageId(String withoutLeaderImageId) {
		this.withoutLeaderImageId = withoutLeaderImageId;
	}
	
	public String getDefaultImageId() {
		return defaultImageId;
	}
	public void setDefaultImageId(String defaultImageId) {
		this.defaultImageId = defaultImageId;
	}
	
	public String[] getBrand() {
		return brand;
	}
	public void setBrand(String[] brand) {
		this.brand = brand;
	}
	
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
	
	public String[] getStrengths() {
		return strengths;
	}
	public void setStrengths(String[] strengths) {
		this.strengths = strengths;
	}
	
	public String[] getDevelopmentAreas() {
		return developmentAreas;
	}
	public void setDevelopmentAreas(String[] developmentAreas) {
		this.developmentAreas = developmentAreas;
	}
	
	@Override
	public String toString() {
		return "LTIndicatorsEntity [indicatorId=" + indicatorId + ", colorCode=" + colorCode + ", title=" + title
				+ ", name=" + name + ", assessmentCode=" + assessmentCode + ", withLeaderImageId=" + withLeaderImageId
				+ ", withoutLeaderImageId=" + withoutLeaderImageId + ", defaultImageId=" + defaultImageId + ", brand="
				+ Arrays.toString(brand) + ", quote=" + quote + ", values=" + Arrays.toString(values) + ", strengths="
				+ Arrays.toString(strengths) + ", developmentAreas=" + Arrays.toString(developmentAreas) + "]";
	}
	
}
