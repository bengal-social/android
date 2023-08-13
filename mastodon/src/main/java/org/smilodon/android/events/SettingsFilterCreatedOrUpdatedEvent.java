package org.smilodon.android.events;

import org.smilodon.android.model.Filter;

public class SettingsFilterCreatedOrUpdatedEvent{
	public final String accountID;
	public final Filter filter;

	public SettingsFilterCreatedOrUpdatedEvent(String accountID, Filter filter){
		this.accountID=accountID;
		this.filter=filter;
	}
}
