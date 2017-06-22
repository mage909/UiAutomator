package com.intel;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class DefaultVideoPlayer extends UiAutomatorTestCase {

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
		// 滑动launcher 1次：getUiDevice().swipe(300, 300, 50, 300, 1);
		// 启动gallery
		getUiDevice().click(290, 892);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UiObject gallery = new UiObject(new UiSelector().text("Gallery"));
		gallery.click();
		sleep(3000);
		// Disable google account
		UiObject googleAccount = new UiObject(new UiSelector().text("Not now"));
		googleAccount.clickAndWaitForNewWindow();
		sleep(3000);
		// click play video
		/*
		 * UiObject videoFolder = new UiObject(new UiSelector().text("video"));
		 * videoFolder.clickAndWaitForNewWindow();
		 */
		getUiDevice().click(285, 674);
		sleep(3000);
		getUiDevice().click(300, 512);
		sleep(3000);
		// select player
		UiObject selectGallery = new UiObject(
				new UiSelector().text("Video player"));
		selectGallery.click();
		UiObject always = new UiObject(new UiSelector().text("Always"));
		always.click();
		
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressBack();

	}
}
