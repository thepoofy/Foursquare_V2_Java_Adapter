package com.williamvanderhoef.foursquare.model.notification;

import java.util.List;

import com.williamvanderhoef.foursquare.types.Leaderboard;
import com.williamvanderhoef.foursquare.types.Score;

public class LeaderboardNotification extends Notification{

	private List<Leaderboard> leaderboard;
	private String message;
	private List<Score> scores;
	private Integer total;
	
	
	public List<Leaderboard> getLeaderboard() {
		return leaderboard;
	}

	public void setLeaderboard(List<Leaderboard> leaderboard) {
		this.leaderboard = leaderboard;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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
