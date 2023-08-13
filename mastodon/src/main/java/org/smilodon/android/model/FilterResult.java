package org.smilodon.android.model;

import org.smilodon.android.api.ObjectValidationException;
import org.smilodon.android.api.RequiredField;
import org.parceler.Parcel;

import java.util.List;

@Parcel
public class FilterResult extends BaseModel{
	@RequiredField
	public Filter filter;

	public List<String> keywordMatches;

	@Override
	public void postprocess() throws ObjectValidationException{
		super.postprocess();
		filter.postprocess();
	}
}
