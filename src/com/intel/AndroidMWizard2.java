package com.intel;

import android.os.RemoteException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class AndroidMWizard2 extends UiAutomatorTestCase{
	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		getUiDevice().pressHome();
		sleep(2000);

		UiObject gotit = new UiObject(new UiSelector().text("GOT IT"));
		gotit.click();
		sleep(3000);
		getUiDevice().pressHome();
	}
}
