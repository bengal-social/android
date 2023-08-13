package org.smilodon.android.api.requests.instance;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Instance;

public class GetInstance extends MastodonAPIRequest<Instance>{
	public GetInstance(){
		super(HttpMethod.GET, "/instance", Instance.class);
	}
}
