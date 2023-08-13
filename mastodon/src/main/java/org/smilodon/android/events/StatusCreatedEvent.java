package org.smilodon.android.events;

import org.smilodon.android.model.Status;

public class StatusCreatedEvent{
	public final Status status;
	public final String accountID;

	public StatusCreatedEvent(Status status, String accountID){
		this.status=status;
		this.accountID=accountID;
	}
}
