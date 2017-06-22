package com.intel;

import java.io.IOException;
import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;

public class VideoPlayback extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException{
		try {
			getUiDevice().wakeUp();
			getUiDevice().pressMenu();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		getUiDevice().pressHome();
		
		try {
			Runtime.getRuntime().exec("am start -n com.mxtech.videoplayer.ad/.ActivityMediaList");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//sleep(10000);
		getUiDevice().waitForIdle();
		int i;
		for ( i = 0; i < 5; i++){
			sleep(2000);
			if ( new UiObject(new UiSelector().text("OK")).exists() ){
				break;
			}
		}
		if ( i == 4 && !new UiObject(new UiSelector().text("OK")).exists()){
			System.out.print("wait OK button timeout,exit.");
			System.exit(0);
		}
		UiObject ok1 = new UiObject(new UiSelector().text("OK"));
		ok1.click();
		sleep(4000);
		UiObject ok2 = new UiObject(new UiSelector().text("OK"));
		ok2.click();
		
		
		UiObject settings = new UiObject(new UiSelector().descriptionContains("More options"));
		settings.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject settings1 = new UiObject(new UiSelector().text("Settings"));
		settings1.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject playButton = new UiObject(new UiSelector().text("Player"));
		playButton.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject controls = new UiObject(new UiSelector().text("Controls"));
		controls.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject moInterface = new UiObject(new UiSelector().resourceId("com.mxtech.videoplayer.ad:id/interface_auto_hide"));
		moInterface.click();
		sleep(1000);
		UiObject ok3 = new UiObject(new UiSelector().text("OK"));
		ok3.click();
		sleep(1000);
		getUiDevice().pressBack();
		sleep(1000);
		getUiDevice().pressBack();
		
		UiObject mediaScan = new UiObject(new UiSelector().resourceId("com.mxtech.videoplayer.ad:id/media_scan"));
		mediaScan.click();
		sleep(3000);
		//UiObject movies = new UiObject(new UiSelector().text("Movies New"));
		UiObject movies = new UiObject(new UiSelector().resourceId("com.mxtech.videoplayer.ad:id/title"));
		movies.clickAndWaitForNewWindow();
		sleep(1000);
		
		int videoCount = new UiCollection(new UiSelector().resourceId("android:id/list")).getChildCount();
		if ( videoCount > 0 ){
			UiObject video0 = new UiObject(new UiSelector().resourceId("android:id/list").index(0));
			video0.clickAndWaitForNewWindow();
		}
		sleep(3000);
		
		//getUiDevice().click(400, 500);
		UiObject pause = new UiObject(new UiSelector().resourceId("com.mxtech.videoplayer.ad:id/playpause"));
		pause.click();
		sleep(1000);
		UiObject moreOptions = new UiObject(new UiSelector().descriptionContains("More options"));
		moreOptions.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject playSetting = new UiObject(new UiSelector().text("Play"));
		playSetting.clickAndWaitForNewWindow();
		sleep(1000);
		UiObject loopAll = new UiObject(new UiSelector().text("Loop all"));
		loopAll.click();
		sleep(1000);
		UiObject play = new UiObject(new UiSelector().resourceId("com.mxtech.videoplayer.ad:id/playpause"));
		play.click();
	}
}
