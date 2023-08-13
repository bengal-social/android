package org.smilodon.android.api.requests.accounts;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Relationship;

public class SetAccountMuted extends MastodonAPIRequest<Relationship>{
	public SetAccountMuted(String id, boolean muted){
		super(HttpMethod.POST, "/accounts/"+id+"/"+(muted ? "mute" : "unmute"), Relationship.class);
		setRequestBody(new Object());
	}
}
