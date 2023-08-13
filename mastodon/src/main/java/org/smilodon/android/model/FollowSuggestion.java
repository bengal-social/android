package org.smilodon.android.model;

import org.smilodon.android.api.ObjectValidationException;
import org.smilodon.android.api.RequiredField;

public class FollowSuggestion extends BaseModel{
	@RequiredField
	public Account account;
//	public String source;

	@Override
	public void postprocess() throws ObjectValidationException{
		super.postprocess();
		account.postprocess();
	}
}
