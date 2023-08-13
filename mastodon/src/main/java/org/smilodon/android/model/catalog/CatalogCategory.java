package org.smilodon.android.model.catalog;

import org.smilodon.android.api.AllFieldsAreRequired;
import org.smilodon.android.model.BaseModel;

@AllFieldsAreRequired
public class CatalogCategory extends BaseModel{
	public String category;
	public int serversCount;

	@Override
	public String toString(){
		return "CatalogCategory{"+
				"category='"+category+'\''+
				", serversCount="+serversCount+
				'}';
	}
}
