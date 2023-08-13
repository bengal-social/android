package org.smilodon.android.model.viewmodel;

import android.text.SpannableStringBuilder;

import org.smilodon.android.GlobalUserPreferences;
import org.smilodon.android.api.session.AccountSessionManager;
import org.smilodon.android.model.Account;
import org.smilodon.android.model.AccountField;
import org.smilodon.android.ui.text.HtmlParser;
import org.smilodon.android.ui.utils.CustomEmojiHelper;

import java.util.Collections;

import me.grishka.appkit.imageloader.requests.ImageLoaderRequest;
import me.grishka.appkit.imageloader.requests.UrlImageLoaderRequest;
import me.grishka.appkit.utils.V;

public class AccountViewModel{
	public final Account account;
	public final ImageLoaderRequest avaRequest;
	public final CustomEmojiHelper emojiHelper;
	public final CharSequence parsedName, parsedBio;
	public final String verifiedLink;

	public AccountViewModel(Account account, String accountID){
		this.account=account;
		avaRequest=new UrlImageLoaderRequest(GlobalUserPreferences.playGifs ? account.avatar : account.avatarStatic, V.dp(50), V.dp(50));
		emojiHelper=new CustomEmojiHelper();
		if(AccountSessionManager.get(accountID).getLocalPreferences().customEmojiInNames)
			parsedName=HtmlParser.parseCustomEmoji(account.displayName, account.emojis);
		else
			parsedName=account.displayName;
		parsedBio=HtmlParser.parse(account.note, account.emojis, Collections.emptyList(), Collections.emptyList(), accountID);
		SpannableStringBuilder ssb=new SpannableStringBuilder(parsedName);
		ssb.append(parsedBio);
		emojiHelper.setText(ssb);
		String verifiedLink=null;
		for(AccountField fld:account.fields){
			if(fld.verifiedAt!=null){
				verifiedLink=HtmlParser.stripAndRemoveInvisibleSpans(fld.value);
				break;
			}
		}
		this.verifiedLink=verifiedLink;
	}
}
