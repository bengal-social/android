package org.smilodon.android.fragments.account_list;

import android.os.Bundle;

import org.smilodon.android.model.Account;
import org.parceler.Parcels;

public abstract class AccountRelatedAccountListFragment extends PaginatedAccountListFragment{
	protected Account account;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		account=Parcels.unwrap(getArguments().getParcelable("targetAccount"));
		setTitle("@"+account.acct);
	}
}
