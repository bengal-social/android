package org.smilodon.android.model;

import org.smilodon.android.api.AllFieldsAreRequired;
import org.parceler.Parcel;

@AllFieldsAreRequired
@Parcel
public class Mention extends BaseModel{
	public String id;
	public String username;
	public String acct;
	public String url;

	@Override
	public String toString(){
		return "Mention{"+
				"id='"+id+'\''+
				", username='"+username+'\''+
				", acct='"+acct+'\''+
				", url='"+url+'\''+
				'}';
	}
}
