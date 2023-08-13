package org.smilodon.android.fragments.settings;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;

import org.smilodon.android.R;
import org.smilodon.android.fragments.MastodonRecyclerFragment;
import org.smilodon.android.model.viewmodel.CheckableListItem;
import org.smilodon.android.model.viewmodel.ListItem;
import org.smilodon.android.ui.BetterItemAnimator;
import org.smilodon.android.ui.DividerItemDecoration;
import org.smilodon.android.ui.adapters.GenericListItemsAdapter;
import org.smilodon.android.ui.viewholders.ListItemViewHolder;
import org.smilodon.android.ui.viewholders.SimpleListItemViewHolder;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseSettingsFragment<T> extends MastodonRecyclerFragment<ListItem<T>>{
	protected GenericListItemsAdapter<T> itemsAdapter;
	protected String accountID;

	public BaseSettingsFragment(){
		super(20);
	}

	public BaseSettingsFragment(int perPage){
		super(perPage);
	}

	public BaseSettingsFragment(int layout, int perPage){
		super(layout, perPage);
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		accountID=getArguments().getString("account");
		setRefreshEnabled(false);
	}

	@Override
	protected RecyclerView.Adapter<?> getAdapter(){
		return itemsAdapter=new GenericListItemsAdapter<T>(data);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		list.addItemDecoration(new DividerItemDecoration(getActivity(), R.attr.colorM3OutlineVariant, 1, 0, 0, vh->vh instanceof SimpleListItemViewHolder ivh && ivh.getItem().dividerAfter));
		list.setItemAnimator(new BetterItemAnimator());
	}

	protected int indexOfItemsAdapter(){
		return 0;
	}

	protected void toggleCheckableItem(CheckableListItem<T> item){
		item.toggle();
		rebindItem(item);
	}

	protected void rebindItem(ListItem<T> item){
		if(list==null)
			return;
		if(list.findViewHolderForAdapterPosition(indexOfItemsAdapter()+data.indexOf(item)) instanceof ListItemViewHolder<?> holder){
			holder.rebind();
		}
	}

	@Override
	public void onApplyWindowInsets(WindowInsets insets){
		if(Build.VERSION.SDK_INT>=29 && insets.getTappableElementInsets().bottom==0){
			list.setPadding(0, 0, 0, insets.getSystemWindowInsetBottom());
			emptyView.setPadding(0, 0, 0, insets.getSystemWindowInsetBottom());
			progress.setPadding(0, 0, 0, insets.getSystemWindowInsetBottom());
			insets=insets.inset(0, 0, 0, insets.getSystemWindowInsetBottom());
		}else{
			list.setPadding(0, 0, 0, 0);
		}
		super.onApplyWindowInsets(insets);
	}
}
