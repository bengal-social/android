package org.smilodon.android.api.requests.markers;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.api.gson.JsonObjectBuilder;
import org.smilodon.android.model.TimelineMarkers;

public class SaveMarkers extends MastodonAPIRequest<TimelineMarkers>{
	public SaveMarkers(String lastSeenHomePostID, String lastSeenNotificationID){
		super(HttpMethod.POST, "/markers", TimelineMarkers.class);
		JsonObjectBuilder builder=new JsonObjectBuilder();
		if(lastSeenHomePostID!=null)
			builder.add("home", new JsonObjectBuilder().add("last_read_id", lastSeenHomePostID));
		if(lastSeenNotificationID!=null)
			builder.add("notifications", new JsonObjectBuilder().add("last_read_id", lastSeenNotificationID));
		setRequestBody(builder.build());
	}
}
