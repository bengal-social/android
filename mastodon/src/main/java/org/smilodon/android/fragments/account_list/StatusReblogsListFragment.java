package org.smilodon.android.fragments.account_list;

import android.os.Bundle;

import org.smilodon.android.R;
import org.smilodon.android.api.requests.HeaderPaginationRequest;
import org.smilodon.android.api.requests.statuses.GetStatusReblogs;
import org.smilodon.android.model.Account;

public class StatusReblogsListFragment extends StatusRelatedAccountListFragment{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setTitle(getResources().getQuantityString(R.plurals.x_reblogs, (int)(status.reblogsCount%1000), status.reblogsCount));
	}

	@Override
	public HeaderPaginationRequest<Account> onCreateRequest(String maxID, int count){
		return new GetStatusReblogs(status.id, maxID, count);
	}
}
