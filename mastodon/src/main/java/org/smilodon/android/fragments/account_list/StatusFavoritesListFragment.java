package org.smilodon.android.fragments.account_list;

import android.os.Bundle;

import org.smilodon.android.R;
import org.smilodon.android.api.requests.HeaderPaginationRequest;
import org.smilodon.android.api.requests.statuses.GetStatusFavorites;
import org.smilodon.android.model.Account;

public class StatusFavoritesListFragment extends StatusRelatedAccountListFragment{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setTitle(getResources().getQuantityString(R.plurals.x_favorites, (int)(status.favouritesCount%1000), status.favouritesCount));
	}

	@Override
	public HeaderPaginationRequest<Account> onCreateRequest(String maxID, int count){
		return new GetStatusFavorites(status.id, maxID, count);
	}
}
