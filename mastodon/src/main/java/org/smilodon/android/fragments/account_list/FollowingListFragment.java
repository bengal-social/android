package org.smilodon.android.fragments.account_list;

import android.os.Bundle;

import org.smilodon.android.R;
import org.smilodon.android.api.requests.HeaderPaginationRequest;
import org.smilodon.android.api.requests.accounts.GetAccountFollowing;
import org.smilodon.android.model.Account;

public class FollowingListFragment extends AccountRelatedAccountListFragment{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setSubtitle(getResources().getQuantityString(R.plurals.x_following, (int)(account.followingCount%1000), account.followingCount));
	}

	@Override
	public HeaderPaginationRequest<Account> onCreateRequest(String maxID, int count){
		return new GetAccountFollowing(account.id, maxID, count);
	}
}
