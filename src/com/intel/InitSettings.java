package com.intel;

import java.io.IOException;
import android.os.RemoteException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class InitSettings extends UiAutomatorTestCase {

	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
			getUiDevice().pressMenu();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		getUiDevice().pressHome();
		sleep(3000);


		try {
			Runtime.getRuntime().exec("am start -n com.android.settings/.Settings");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sleep(2000);
		
		UiScrollable settingItems = new UiScrollable(new UiSelector().scrollable(true));
		UiObject display = settingItems.getChildByText(new UiSelector().text("Display"), "Display");
		display.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject sleep = new UiObject(new UiSelector().text("Sleep"));
		sleep.clickAndWaitForNewWindow();
		UiObject sleep30Minutes = new UiObject(new UiSelector().text("30 minutes"));
		sleep30Minutes.click();	
		sleep(1000);
		getUiDevice().pressBack();
		sleep(2000);
		
		UiScrollable settingItems1 = new UiScrollable(new UiSelector().scrollable(true));
		UiObject security = settingItems1.getChildByText(new UiSelector().text("Security"), "Security");
		security.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject screenLock = new UiObject(new UiSelector().text("Screen lock"));
		screenLock.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject setToNone = new UiObject(new UiSelector().text("None"));
		setToNone.click();
		sleep(1000);
		getUiDevice().pressBack();
		sleep(2000);
		
		UiScrollable settingItems2 = new UiScrollable(new UiSelector().scrollable(true));
		UiObject aboutPhone = settingItems2.getChildByText(new UiSelector().text("About phone"), "About phone");
		aboutPhone.clickAndWaitForNewWindow();
		sleep(1000);
		
		if (new UiObject(new UiSelector().text("Build number")).exists()){
		    UiObject buildNo2 = new UiObject(new UiSelector().text("Build number"));
		    for (int i = 0;i < 10;i++){
			    buildNo2.click();
		    }
		}
		else{
			UiScrollable aboutPhoneItems = new UiScrollable(new UiSelector().scrollable(true));
			UiObject buildNo1 = aboutPhoneItems.getChildByText(new UiSelector().text("Build number"), "Build number");
		    for (int i = 0;i < 10;i++){
			    buildNo1.click();
		    }
		}
		sleep(1000);
		getUiDevice().pressBack();
		UiObject developerOptions = new UiObject(new UiSelector().text("Developer options"));
		developerOptions.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject stayAwake = new UiObject(new UiSelector().text("Stay awake"));
		stayAwake.click();
		sleep(1000);
		getUiDevice().pressBack();
		sleep(2000);
		
		getUiDevice().pressHome();

	}
}