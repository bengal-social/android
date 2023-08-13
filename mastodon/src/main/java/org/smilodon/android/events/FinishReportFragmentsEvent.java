package org.smilodon.android.events;

public class FinishReportFragmentsEvent{
	public final String reportAccountID;

	public FinishReportFragmentsEvent(String reportAccountID){
		this.reportAccountID=reportAccountID;
	}
}
