package org.smilodon.android.fragments.account_list;

import android.os.Bundle;

import org.smilodon.android.model.Status;
import org.parceler.Parcels;

public abstract class StatusRelatedAccountListFragment extends PaginatedAccountListFragment{
	protected Status status;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		status=Parcels.unwrap(getArguments().getParcelable("status"));
	}

	@Override
	protected boolean hasSubtitle(){
		return false;
	}
}
