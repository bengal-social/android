package org.smilodon.android.api.requests.statuses;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Status;

public class SetStatusReblogged extends MastodonAPIRequest<Status>{
	public SetStatusReblogged(String id, boolean reblogged){
		super(HttpMethod.POST, "/statuses/"+id+"/"+(reblogged ? "reblog" : "unreblog"), Status.class);
		setRequestBody(new Object());
	}
}
