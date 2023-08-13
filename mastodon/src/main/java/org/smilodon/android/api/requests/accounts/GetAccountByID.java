package org.smilodon.android.api.requests.accounts;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Account;

public class GetAccountByID extends MastodonAPIRequest<Account>{
	public GetAccountByID(String id){
		super(HttpMethod.GET, "/accounts/"+id, Account.class);
	}
}
