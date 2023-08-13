package org.smilodon.android.fragments.account_list;

import android.os.Bundle;

import org.smilodon.android.R;
import org.smilodon.android.api.requests.HeaderPaginationRequest;
import org.smilodon.android.api.requests.accounts.GetAccountFollowers;
import org.smilodon.android.model.Account;

public class FollowerListFragment extends AccountRelatedAccountListFragment{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setSubtitle(getResources().getQuantityString(R.plurals.x_followers, (int)(account.followersCount%1000), account.followersCount));
	}

	@Override
	public HeaderPaginationRequest<Account> onCreateRequest(String maxID, int count){
		return new GetAccountFollowers(account.id, maxID, count);
	}
}
