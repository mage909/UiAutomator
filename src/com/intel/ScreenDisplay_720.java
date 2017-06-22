package com.intel;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ScreenDisplay_720 extends UiAutomatorTestCase {

	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
			getUiDevice().pressMenu();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getUiDevice().pressHome();

				
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//getUiDevice().swipe(300, 300, 10, 300, 2);
		
		//UiObject settingApp = new UiObject(new UiSelector().text("Settings"));
		//settingApp.clickAndWaitForNewWindow();
		try {
			Runtime.getRuntime().exec("am start -n com.android.settings/.Settings");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UiScrollable settingItems = new UiScrollable(new UiSelector().scrollable(true));
		UiObject display = settingItems.getChildByText(new UiSelector().text("Display"), "Display");
		display.clickAndWaitForNewWindow();
		UiObject sleep = new UiObject(new UiSelector().text("Sleep"));
		sleep.clickAndWaitForNewWindow();
		//UiScrollable sleep_value = new UiScrollable(new UiSelector().scrollable(false));
		UiObject s15 = new UiObject(new UiSelector().text("30 minutes"));
		s15.click();
		
		/*
		UiObject display = new UiObject(new UiSelector().text("Display"));
		display.clickAndWaitForNewWindow();
		// sleep
		UiObject sleep = new UiObject(new UiSelector().text("Sleep"));
		sleep.clickAndWaitForNewWindow();
		// 30mins
		UiObject sleep_value = new UiObject(new UiSelector().text("30 minutes"));
		sleep_value.click();*/
		/*
		 * UiScrollable settingItems = new UiScrollable( new
		 * UiSelector().scrollable(true));
		 * 
		 * UiObject languageAndInputItem = settingItems.getChildByText( new
		 * UiSelector().text("Display"), "Display", true);
		 * languageAndInputItem.clickAndWaitForNewWindow();
		 */

		
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressBack();

	}
}
