package org.smilodon.android.api.requests.search;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.SearchResults;

public class GetSearchResults extends MastodonAPIRequest<SearchResults>{
	public GetSearchResults(String query, Type type, boolean resolve){
		super(HttpMethod.GET, "/search", SearchResults.class);
		addQueryParameter("q", query);
		if(type!=null)
			addQueryParameter("type", type.name().toLowerCase());
		if(resolve)
			addQueryParameter("resolve", "true");
	}

	public GetSearchResults limit(int limit){
		addQueryParameter("limit", String.valueOf(limit));
		return this;
	}

	@Override
	protected String getPathPrefix(){
		return "/api/v2";
	}

	public enum Type{
		ACCOUNTS,
		HASHTAGS,
		STATUSES
	}
}
