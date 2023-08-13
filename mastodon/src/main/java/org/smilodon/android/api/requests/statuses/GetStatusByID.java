package org.smilodon.android.api.requests.statuses;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Status;

public class GetStatusByID extends MastodonAPIRequest<Status>{
	public GetStatusByID(String id){
		super(HttpMethod.GET, "/statuses/"+id, Status.class);
	}
}
