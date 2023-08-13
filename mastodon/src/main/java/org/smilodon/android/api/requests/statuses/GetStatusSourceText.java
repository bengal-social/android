package org.smilodon.android.api.requests.statuses;

import org.smilodon.android.api.AllFieldsAreRequired;
import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.BaseModel;

public class GetStatusSourceText extends MastodonAPIRequest<GetStatusSourceText.Response>{
	public GetStatusSourceText(String id){
		super(HttpMethod.GET, "/statuses/"+id+"/source", Response.class);
	}

	@AllFieldsAreRequired
	public static class Response extends BaseModel{
		public String id;
		public String text;
		public String spoilerText;
	}
}
