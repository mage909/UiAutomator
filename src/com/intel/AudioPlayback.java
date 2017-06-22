package com.intel;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;

public class AudioPlayback extends UiAutomatorTestCase{
	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		if (new UiObject(new UiSelector().text("Allow")).exists()){
			UiObject allow = new UiObject(new UiSelector().text("Allow"));
			allow.click();
		}
		sleep(7000);
		UiObject play = new UiObject(new UiSelector().resourceId("com.google.android.music:id/li_center_icon"));
		play.click();
		sleep(3000);
		
		UiObject alum = new UiObject(new UiSelector().resourceId("com.google.android.music:id/album_small"));
		alum.clickAndWaitForNewWindow();
		sleep(3000);		
		
		UiObject repeat = new UiObject(new UiSelector().resourceId("com.google.android.music:id/repeat"));
		repeat.click();
		sleep(3000);
	}
}
