package org.smilodon.android.api.requests.markers;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.TimelineMarkers;

public class GetMarkers extends MastodonAPIRequest<TimelineMarkers>{
	public GetMarkers(){
		super(HttpMethod.GET, "/markers", TimelineMarkers.class);
		addQueryParameter("timeline[]", "home");
		addQueryParameter("timeline[]", "notifications");
	}
}
