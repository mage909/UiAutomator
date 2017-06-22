package com.intel;

import android.os.RemoteException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AndroidLWizard2 extends UiAutomatorTestCase {

	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
			getUiDevice().pressMenu();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		getUiDevice().pressHome();
		sleep(2000);
		//OK
		UiObject ok = new UiObject(new UiSelector().text("OK"));
		//assertTrue("not found ok", ok.exists());
		
		ok.click();
		sleep(3000);
		UiObject appList = new UiObject(new UiSelector().descriptionMatches("Apps"));
        appList.clickAndWaitForNewWindow();
        sleep(2000);
        
        UiObject oktwo = new UiObject(new UiSelector().text("OK"));
        oktwo.click();
        sleep(2000);
        getUiDevice().pressHome();

	}
}
