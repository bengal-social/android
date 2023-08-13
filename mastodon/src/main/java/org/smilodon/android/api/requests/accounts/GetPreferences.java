package org.smilodon.android.api.requests.accounts;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Preferences;

public class GetPreferences extends MastodonAPIRequest<Preferences> {
    public GetPreferences(){
        super(HttpMethod.GET, "/preferences", Preferences.class);
    }
}
