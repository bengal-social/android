package org.smilodon.android.model;

import org.smilodon.android.api.AllFieldsAreRequired;

import java.time.Instant;

@AllFieldsAreRequired
public class Marker extends BaseModel{
	public String lastReadId;
	public long version;
	public Instant updatedAt;

	@Override
	public String toString(){
		return "Marker{"+
				"lastReadId='"+lastReadId+'\''+
				", version="+version+
				", updatedAt="+updatedAt+
				'}';
	}
}
