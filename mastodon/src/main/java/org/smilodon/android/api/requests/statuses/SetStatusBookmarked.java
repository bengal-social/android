package org.smilodon.android.api.requests.statuses;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Status;

public class SetStatusBookmarked extends MastodonAPIRequest<Status>{
	public SetStatusBookmarked(String id, boolean bookmarked){
		super(HttpMethod.POST, "/statuses/"+id+"/"+(bookmarked ? "bookmark" : "unbookmark"), Status.class);
		setRequestBody(new Object());
	}
}
