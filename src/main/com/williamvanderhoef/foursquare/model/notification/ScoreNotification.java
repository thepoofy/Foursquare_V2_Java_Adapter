package com.williamvanderhoef.foursquare.model.notification;

import java.util.List;

import com.williamvanderhoef.foursquare.types.Score;

public class ScoreNotification extends Notification{

	private List<Score> scores;
	private Integer total;
	
	
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
}
