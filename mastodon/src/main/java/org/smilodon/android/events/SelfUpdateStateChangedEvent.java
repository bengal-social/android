package org.smilodon.android.events;

import org.smilodon.android.updater.GithubSelfUpdater;

public class SelfUpdateStateChangedEvent{
	public final GithubSelfUpdater.UpdateState state;

	public SelfUpdateStateChangedEvent(GithubSelfUpdater.UpdateState state){
		this.state=state;
	}
}
