package com.entity;

public class ContactChannel {
	private String channelId;
	private String channelName;
	
	public ContactChannel(String channelId, String channelName) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public String toString() {
		return "ContactChannel [channelId=" + channelId + ", channelName=" + channelName + "]";
	}
	
	

}
