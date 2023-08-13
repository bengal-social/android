package org.smilodon.android.ui.photoviewer;

import org.smilodon.android.model.Status;
import org.smilodon.android.ui.displayitems.MediaGridStatusDisplayItem;

public interface PhotoViewerHost{
	void openPhotoViewer(String parentID, Status status, int attachmentIndex, MediaGridStatusDisplayItem.Holder gridHolder);
}
