package org.smilodon.android.events;

import org.smilodon.android.model.Poll;

public class PollUpdatedEvent{
	public String accountID;
	public Poll poll;

	public PollUpdatedEvent(String accountID, Poll poll){
		this.accountID=accountID;
		this.poll=poll;
	}
}
