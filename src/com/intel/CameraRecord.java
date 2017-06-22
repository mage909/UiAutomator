package com.intel;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;

public class CameraRecord extends UiAutomatorTestCase{
	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		UiObject record = new UiObject(new UiSelector().resourceId("com.arcsoft.camera2:id/record_button"));
		record.clickAndWaitForNewWindow();
		sleep(2000);
	}
}
