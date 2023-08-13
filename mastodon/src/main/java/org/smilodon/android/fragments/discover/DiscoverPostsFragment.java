package org.smilodon.android.fragments.discover;

import android.os.Bundle;

import org.smilodon.android.api.requests.trends.GetTrendingStatuses;
import org.smilodon.android.fragments.StatusListFragment;
import org.smilodon.android.model.Status;
import org.smilodon.android.ui.utils.DiscoverInfoBannerHelper;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import me.grishka.appkit.api.SimpleCallback;
import me.grishka.appkit.utils.MergeRecyclerAdapter;

public class DiscoverPostsFragment extends StatusListFragment{
	private DiscoverInfoBannerHelper bannerHelper;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		bannerHelper=new DiscoverInfoBannerHelper(DiscoverInfoBannerHelper.BannerType.TRENDING_POSTS, accountID);
	}

	@Override
	protected void doLoadData(int offset, int count){
		currentRequest=new GetTrendingStatuses(offset, count)
				.setCallback(new SimpleCallback<>(this){
					@Override
					public void onSuccess(List<Status> result){
						onDataLoaded(result, !result.isEmpty());
						bannerHelper.onBannerBecameVisible();
					}
				}).exec(accountID);
	}

	@Override
	protected RecyclerView.Adapter getAdapter(){
		MergeRecyclerAdapter adapter=new MergeRecyclerAdapter();
		bannerHelper.maybeAddBanner(list, adapter);
		adapter.addAdapter(super.getAdapter());
		return adapter;
	}
}
