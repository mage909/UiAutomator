package com.intel;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;

public class CameraSwitch extends UiAutomatorTestCase{
	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		UiObject camera_switch = new UiObject(new UiSelector().resourceId("com.arcsoft.camera2:id/btn_switch_camera"));
		camera_switch.clickAndWaitForNewWindow();
		sleep(2000);
	}
}
