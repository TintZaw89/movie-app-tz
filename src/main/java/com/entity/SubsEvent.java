package com.entity;

public class SubsEvent {
	
	private int eventId;
	private String eventName;
	
	public SubsEvent(int eventId, String eventName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Override
	public String toString() {
		return "SubsEvent [eventId=" + eventId + ", eventName=" + eventName + "]";
	}
	
	

}
