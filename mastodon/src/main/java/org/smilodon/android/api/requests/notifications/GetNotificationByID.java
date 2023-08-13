package org.smilodon.android.api.requests.notifications;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Notification;

public class GetNotificationByID extends MastodonAPIRequest<Notification>{
	public GetNotificationByID(String id){
		super(HttpMethod.GET, "/notifications/"+id, Notification.class);
	}
}
