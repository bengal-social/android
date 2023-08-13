package org.smilodon.android.api.requests.statuses;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Status;

public class DeleteStatus extends MastodonAPIRequest<Status>{
	public DeleteStatus(String id){
		super(HttpMethod.DELETE, "/statuses/"+id, Status.class);
	}
}
