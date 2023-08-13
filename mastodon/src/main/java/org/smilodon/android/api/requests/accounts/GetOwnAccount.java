package org.smilodon.android.api.requests.accounts;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Account;

public class GetOwnAccount extends MastodonAPIRequest<Account>{
	public GetOwnAccount(){
		super(HttpMethod.GET, "/accounts/verify_credentials", Account.class);
	}
}
