package org.smilodon.android.api.requests.statuses;

import com.google.gson.reflect.TypeToken;

import org.smilodon.android.api.requests.HeaderPaginationRequest;
import org.smilodon.android.model.Status;

public class GetFavoritedStatuses extends HeaderPaginationRequest<Status>{
	public GetFavoritedStatuses(String maxID, int limit){
		super(HttpMethod.GET, "/favourites", new TypeToken<>(){});
		if(maxID!=null)
			addQueryParameter("max_id", maxID);
		if(limit>0)
			addQueryParameter("limit", limit+"");
	}
}
