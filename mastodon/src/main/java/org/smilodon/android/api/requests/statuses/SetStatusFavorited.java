package org.smilodon.android.api.requests.statuses;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Status;

public class SetStatusFavorited extends MastodonAPIRequest<Status>{
	public SetStatusFavorited(String id, boolean favorited){
		super(HttpMethod.POST, "/statuses/"+id+"/"+(favorited ? "favourite" : "unfavourite"), Status.class);
		setRequestBody(new Object());
	}
}
