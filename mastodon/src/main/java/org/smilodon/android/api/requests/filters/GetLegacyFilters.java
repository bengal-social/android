package org.smilodon.android.api.requests.filters;

import com.google.gson.reflect.TypeToken;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.LegacyFilter;

import java.util.List;

public class GetLegacyFilters extends MastodonAPIRequest<List<LegacyFilter>>{
	public GetLegacyFilters(){
		super(HttpMethod.GET, "/filters", new TypeToken<>(){});
	}
}
