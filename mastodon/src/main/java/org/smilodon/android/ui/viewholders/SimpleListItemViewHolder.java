package org.smilodon.android.ui.viewholders;

import android.content.Context;
import android.view.ViewGroup;

import org.smilodon.android.R;
import org.smilodon.android.model.viewmodel.ListItem;

public class SimpleListItemViewHolder extends ListItemViewHolder<ListItem<?>>{
	public SimpleListItemViewHolder(Context context, ViewGroup parent){
		super(context, R.layout.item_generic_list, parent);
	}
}
