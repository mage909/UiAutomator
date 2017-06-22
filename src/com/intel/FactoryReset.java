package com.intel;

import java.io.IOException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;

public class FactoryReset extends UiAutomatorTestCase{
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
		UiObject factoryreset = settingItems.getChildByText(new UiSelector().text("Backup & reset"), "Backup & reset");
		factoryreset.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject reset = new UiObject(new UiSelector().text("Factory data reset"));
		reset.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject reset_phone = new UiObject(new UiSelector().text("Reset phone"));
		reset_phone.click();	
		sleep(1000);
		UiObject erase_everything = new UiObject(new UiSelector().text("Erase everything"));
		erase_everything.click();	
		sleep(1000);
		
	}
}
