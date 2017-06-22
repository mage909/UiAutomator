package com.intel;

import java.io.IOException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;

public class AndroidMSetup extends UiAutomatorTestCase{
	public void testDemo() throws UiObjectNotFoundException {
		try {
			getUiDevice().wakeUp();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		getUiDevice().pressHome();
		sleep(2000);

		UiObject gotit = new UiObject(new UiSelector().text("知道了"));
		gotit.click();
		sleep(3000);

		
		try {
			Runtime.getRuntime().exec("am start -n com.android.settings/.Settings");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sleep(2000);
		
		UiScrollable settingItems = new UiScrollable(new UiSelector().scrollable(true));
		UiObject display = settingItems.getChildByText(new UiSelector().text("显示"), "显示");
		display.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject sleep = new UiObject(new UiSelector().text("休眠"));
		sleep.clickAndWaitForNewWindow();
		UiObject sleep30Minutes = new UiObject(new UiSelector().text("30分钟"));
		sleep30Minutes.click();	
		sleep(1000);
		getUiDevice().pressBack();
		sleep(2000);
		
		UiScrollable settingItems1 = new UiScrollable(new UiSelector().scrollable(true));
		UiObject security = settingItems1.getChildByText(new UiSelector().text("安全"), "安全");
		security.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject screenLock = new UiObject(new UiSelector().text("屏幕锁定方式"));
		screenLock.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject setToNone = new UiObject(new UiSelector().text("无"));
		setToNone.click();
		sleep(1000);
		getUiDevice().pressBack();
		sleep(2000);
		
		UiScrollable settingItems2 = new UiScrollable(new UiSelector().scrollable(true));
		UiObject lan = settingItems2.getChildByText(new UiSelector().text("语言和输入法"), "语言和输入法");
		lan.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject language = new UiObject(new UiSelector().text("语言"));
		language.clickAndWaitForNewWindow();
		sleep(1000);
		UiScrollable settingItems3 = new UiScrollable(new UiSelector().scrollable(true));
		UiObject l = settingItems3.getChildByText(new UiSelector().text("English (United States)"), "English (United States)");
		l.clickAndWaitForNewWindow();
		sleep(2000);
		getUiDevice().pressBack();
		sleep(2000);
		
		UiScrollable settingItems4 = new UiScrollable(new UiSelector().scrollable(true));
		UiObject aboutPhone = settingItems4.getChildByText(new UiSelector().text("About phone"), "About phone");
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
