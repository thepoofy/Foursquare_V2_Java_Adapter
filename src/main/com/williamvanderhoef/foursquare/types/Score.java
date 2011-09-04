package com.williamvanderhoef.foursquare.types;
/**
	 * 
	 * TODO move Score to a separate class IF it is reused elsewhere
	 *
	 */
	public class Score{
		private Integer points;
		private String icon;
		private String message;
		public Integer getPoints() {
			return points;
		}
		public void setPoints(Integer points) {
			this.points = points;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
	}