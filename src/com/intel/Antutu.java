package com.intel;

import java.io.IOException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;

public class Antutu extends UiAutomatorTestCase{
	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (new UiObject(new UiSelector().resourceId("com.antutu.ABenchMark:id/start_test_text")).exists()){
			UiObject test = new UiObject(new UiSelector().resourceId("com.antutu.ABenchMark:id/start_test_text"));
			test.clickAndWaitForNewWindow();
			sleep(1000);
		}else{
			UiObject retest = new UiObject(new UiSelector().resourceId("com.antutu.ABenchMark:id/retest_text"));
			retest.clickAndWaitForNewWindow();
			sleep(2000);
			UiObject testagain = new UiObject(new UiSelector().resourceId("com.antutu.ABenchMark:id/retest_btn"));
			testagain.clickAndWaitForNewWindow();
			sleep(1000);
		}	
	}
}
