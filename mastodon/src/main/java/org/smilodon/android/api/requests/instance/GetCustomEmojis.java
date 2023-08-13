package org.smilodon.android.api.requests.instance;

import com.google.gson.reflect.TypeToken;

import org.smilodon.android.api.MastodonAPIRequest;
import org.smilodon.android.model.Emoji;

import java.util.List;

public class GetCustomEmojis extends MastodonAPIRequest<List<Emoji>>{
	public GetCustomEmojis(){
		super(HttpMethod.GET, "/custom_emojis", new TypeToken<>(){});
	}
}
