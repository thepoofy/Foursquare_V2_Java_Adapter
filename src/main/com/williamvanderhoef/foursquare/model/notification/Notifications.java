package com.williamvanderhoef.foursquare.model.notification;


/**
 * com.williamvanderhoef.foursquare.model.notification.FoursquareObject is the base class for all Notification objects.
 * 
 */
public class Notifications
{
	private Notification item;
	private String type;
	
	
	public enum NotificationType {
		notificationTray(NotificationTray.class),
		tip(TipNotification.class),
		tipAlert(TipAlertNotification.class),
		leaderboard(LeaderboardNotification.class),
		mayorship(Mayorship.class),
		specials(SpecialsNotification.class),
		score(ScoreNotification.class),
		message(Message.class);
		
		private Class<? extends Notification> typeOf;
		
		private NotificationType(Class<? extends Notification> t)
		{
			this.typeOf = t;
		}
		public Class<? extends Notification> getTypeOf()
		{
			return this.typeOf;
		}
	}
	
	public Notification getItem() {
		return item;
	}
	
	public void setItem(Notification item) {
		this.item = item;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

