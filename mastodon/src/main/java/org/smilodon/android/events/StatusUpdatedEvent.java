package org.smilodon.android.events;

import org.smilodon.android.model.Status;

public class StatusUpdatedEvent{
	public Status status;

	public StatusUpdatedEvent(Status status){
		this.status=status;
	}
}
