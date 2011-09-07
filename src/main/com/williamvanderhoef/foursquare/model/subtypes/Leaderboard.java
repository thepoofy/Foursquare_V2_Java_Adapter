package com.williamvanderhoef.foursquare.model.subtypes;

import com.williamvanderhoef.foursquare.model.User;

/**
 * 
 * move Leaderboard to separate class if it is referenced anywhere else
 * 
 */
public class Leaderboard {
	private User user;
	private Scores scores;
	private Integer rank;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
}