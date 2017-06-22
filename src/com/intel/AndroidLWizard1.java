package com.intel;

import android.os.RemoteException;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AndroidLWizard1 extends UiAutomatorTestCase {

	public void testDemo() throws UiObjectNotFoundException {
		//package:com.google.android.setupwizard
		//class:android.widget.LinearLayout
		UiDevice device = getUiDevice();
		try {
			device.wakeUp();
			sleep(1000);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		sleep(2000);
		
		if ( ! getUiDevice().getCurrentPackageName().equals("com.google.android.setupwizard") ){
			System.out.println("Currect package is not setupwizard,exit it.");
			String currectPackeageName = getUiDevice().getCurrentPackageName();
			System.out.printf("The currect package is %s \n",currectPackeageName);
			System.exit(0);
		}
		
		UiObject start = new UiObject(new UiSelector().description("Start"));
		start.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject skip1 = new UiObject(new UiSelector().text("Skip"));
		skip1.clickAndWaitForNewWindow();
		sleep(1000);
		
		if ( new UiObject(new UiSelector().text("Skip")).exists() ){
			UiObject skip2 = new UiObject(new UiSelector().text("Skip"));
			skip2.clickAndWaitForNewWindow();
			sleep(1000);
		}
		
		UiObject skipAnyway1 = new UiObject(new UiSelector().text("Skip anyway"));
		skipAnyway1.clickAndWaitForNewWindow();
		sleep(1000);
		
		UiObject next1 = new UiObject(new UiSelector().text("Next"));
		next1.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject next2 = new UiObject(new UiSelector().text("Next"));
		next2.clickAndWaitForNewWindow();
		sleep(1000);
				
		UiObject skip3 = new UiObject(new UiSelector().text("Skip"));
		skip3.clickAndWaitForNewWindow();
		sleep(1000);
		
		UiObject skipAnyway2 = new UiObject(new UiSelector().text("Skip anyway"));
		skipAnyway2.clickAndWaitForNewWindow();
		sleep(1000);
		
		if ( new UiObject(new UiSelector().text("More")).exists() ){
			UiObject more = new UiObject(new UiSelector().text("More"));
			more.clickAndWaitForNewWindow();
			sleep(1000);
		}
		
		UiObject next4 = new UiObject(new UiSelector().text("Next"));
		next4.clickAndWaitForNewWindow();
		sleep(1000);
		
		if ( new UiObject(new UiSelector().text("GOT IT")).exists() ){
			UiObject getit = new UiObject(new UiSelector().text("GOT IT"));
			getit.clickAndWaitForNewWindow();
			sleep(1000);
		}
		getUiDevice().pressHome();

	}
}
