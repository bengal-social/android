package org.smilodon.android.api.requests.filters;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Filter;
import org.smilodon.android.model.FilterAction;
import org.smilodon.android.model.FilterContext;
import org.smilodon.android.model.FilterKeyword;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class CreateFilter extends MastodonAPIRequest<Filter>{
	public CreateFilter(String title, EnumSet<FilterContext> context, FilterAction action, int expiresIn, List<FilterKeyword> words){
		super(HttpMethod.POST, "/filters", Filter.class);
		setRequestBody(new FilterRequest(title, context, action, expiresIn==0 ? null : expiresIn, words.stream().map(w->new KeywordAttribute(null, null, w.keyword, w.wholeWord)).collect(Collectors.toList())));
	}

	@Override
	protected String getPathPrefix(){
		return "/api/v2";
	}
}
