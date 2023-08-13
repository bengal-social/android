package org.smilodon.android.fragments.settings;

import android.os.Bundle;

import org.smilodon.android.api.session.AccountActivationInfo;
import org.smilodon.android.api.session.AccountSession;
import org.smilodon.android.api.session.AccountSessionManager;
import org.smilodon.android.fragments.HomeFragment;
import org.smilodon.android.fragments.onboarding.AccountActivationFragment;
import org.smilodon.android.model.viewmodel.ListItem;
import org.smilodon.android.ui.utils.DiscoverInfoBannerHelper;
import org.smilodon.android.updater.GithubSelfUpdater;

import java.util.List;

import me.grishka.appkit.Nav;

public class SettingsDebugFragment extends BaseSettingsFragment<Void>{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setTitle("Debug settings");
		ListItem<Void> selfUpdateItem, resetUpdateItem;
		onDataLoaded(List.of(
				new ListItem<>("Test email confirmation flow", null, this::onTestEmailConfirmClick),
				selfUpdateItem=new ListItem<>("Force self-update", null, this::onForceSelfUpdateClick),
				resetUpdateItem=new ListItem<>("Reset self-updater", null, this::onResetUpdaterClick),
				new ListItem<>("Reset search info banners", null, this::onResetDiscoverBannersClick)
		));
		if(!GithubSelfUpdater.needSelfUpdating()){
			resetUpdateItem.isEnabled=selfUpdateItem.isEnabled=false;
			selfUpdateItem.subtitle="Self-updater is unavailable in this build flavor";
		}
	}

	@Override
	protected void doLoadData(int offset, int count){}

	private void onTestEmailConfirmClick(){
		AccountSession sess=AccountSessionManager.getInstance().getAccount(accountID);
		sess.activated=false;
		sess.activationInfo=new AccountActivationInfo("test@email", System.currentTimeMillis());
		Bundle args=new Bundle();
		args.putString("account", accountID);
		args.putBoolean("debug", true);
		Nav.goClearingStack(getActivity(), AccountActivationFragment.class, args);
	}

	private void onForceSelfUpdateClick(){
		GithubSelfUpdater.forceUpdate=true;
		GithubSelfUpdater.getInstance().maybeCheckForUpdates();
		restartUI();
	}

	private void onResetUpdaterClick(){
		GithubSelfUpdater.getInstance().reset();
		restartUI();
	}

	private void onResetDiscoverBannersClick(){
		DiscoverInfoBannerHelper.reset();
		restartUI();
	}

	private void restartUI(){
		Bundle args=new Bundle();
		args.putString("account", accountID);
		Nav.goClearingStack(getActivity(), HomeFragment.class, args);
	}
}
