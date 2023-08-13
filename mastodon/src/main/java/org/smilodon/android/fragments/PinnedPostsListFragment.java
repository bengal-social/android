package org.smilodon.android.fragments;

import android.os.Bundle;

import org.smilodon.android.R;
import org.smilodon.android.api.requests.accounts.GetAccountStatuses;
import org.smilodon.android.model.Account;
import org.smilodon.android.model.Status;
import org.parceler.Parcels;

import java.util.List;

import me.grishka.appkit.api.SimpleCallback;

public class PinnedPostsListFragment extends StatusListFragment{
	private Account account;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		account=Parcels.unwrap(getArguments().getParcelable("profileAccount"));
		setTitle(R.string.posts);
		loadData();
	}

	@Override
	protected void doLoadData(int offset, int count){
		new GetAccountStatuses(account.id, null, null, 100, GetAccountStatuses.Filter.PINNED)
				.setCallback(new SimpleCallback<>(this){
					@Override
					public void onSuccess(List<Status> result){
						onDataLoaded(result, false);
					}
				}).exec(accountID);
	}
}
