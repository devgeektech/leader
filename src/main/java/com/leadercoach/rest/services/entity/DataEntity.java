package com.leadercoach.rest.services.entity;

import org.mongodb.morphia.annotations.Embedded;


/**
 * Data Entity Bean
 * @author CodaGlobal
 */
@Embedded
public class DataEntity {

	private String indicatorColor;
	private int percentage;

	public String getIndicatorColor() {
		return indicatorColor;
	}

	public void setIndicatorColor(String indicatorColor) {
		this.indicatorColor = indicatorColor;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public DataEntity() {}

	public DataEntity(String indicatorColor, int percentage) {
		super();
		this.indicatorColor = indicatorColor;
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "DataEntity [indicatorColor=" + indicatorColor + ", percentage=" + percentage + "]";
	}

}
