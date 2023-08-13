package org.smilodon.android.api.requests.accounts;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Account;
import org.smilodon.android.model.Preferences;
import org.smilodon.android.model.StatusPrivacy;

public class UpdateAccountCredentialsPreferences extends MastodonAPIRequest<Account>{
	public UpdateAccountCredentialsPreferences(Preferences preferences, Boolean locked, Boolean discoverable){
		super(HttpMethod.PATCH, "/accounts/update_credentials", Account.class);
		setRequestBody(new Request(locked, discoverable, new RequestSource(preferences.postingDefaultVisibility, preferences.postingDefaultLanguage)));
	}

	private static class Request{
		public Boolean locked, discoverable;
		public RequestSource source;

		public Request(Boolean locked, Boolean discoverable, RequestSource source){
			this.locked=locked;
			this.discoverable=discoverable;
			this.source=source;
		}
	}

	private static class RequestSource{
		public StatusPrivacy privacy;
		public String language;

		public RequestSource(StatusPrivacy privacy, String language){
			this.privacy=privacy;
			this.language=language;
		}
	}
}
