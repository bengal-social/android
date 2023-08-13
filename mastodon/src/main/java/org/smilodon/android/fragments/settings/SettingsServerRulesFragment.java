package org.smilodon.android.fragments.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import org.smilodon.android.R;
import org.smilodon.android.api.session.AccountSessionManager;
import org.smilodon.android.fragments.MastodonRecyclerFragment;
import org.smilodon.android.model.Instance;
import org.smilodon.android.ui.adapters.InstanceRulesAdapter;

import androidx.recyclerview.widget.RecyclerView;

public class SettingsServerRulesFragment extends MastodonRecyclerFragment<Instance.Rule>{
	private String accountID;

	public SettingsServerRulesFragment(){
		super(20);
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		accountID=getArguments().getString("account");
		Instance instance=AccountSessionManager.getInstance().getInstanceInfo(AccountSessionManager.get(accountID).domain);
		onDataLoaded(instance.rules);
		setRefreshEnabled(false);
	}

	@Override
	protected void doLoadData(int offset, int count){}

	@Override
	protected RecyclerView.Adapter<?> getAdapter(){
		return new InstanceRulesAdapter(data);
	}

	@Override
	protected View onCreateFooterView(LayoutInflater inflater){
		return inflater.inflate(R.layout.load_more_with_end_mark, null);
	}

	public RecyclerView getList(){
		return list;
	}
}
