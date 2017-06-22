package com.intel;

import java.io.IOException;

import android.os.Bundle;
import android.os.SystemClock;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ConnectAP extends UiAutomatorTestCase {
	public void testDemo() {
		try {
			Runtime.getRuntime().exec(
					"am start -n com.android.settings/.Settings");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//
		UiObject wifi = new UiObject(new UiSelector().text("Wi\u2011Fi"));
		try {
			wifi.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		Bundle bundle = getParams();
		String ap = bundle.getString("ap");
		String passwd = bundle.getString("passwd");
		//
		if (ap != null) {
			UiScrollable aps = new UiScrollable(
					new UiSelector().scrollable(true));
			try {
				UiObject targetAP = aps.getChildByText(
						new UiSelector().text(ap), ap);
				targetAP.clickAndWaitForNewWindow();
			} catch (UiObjectNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//
		UiObject passwdET = new UiObject(new UiSelector().resourceId("com.android.settings:id/password"));
		try {
			passwdET.click();
			passwdET.setText(passwd);
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SystemClock.sleep(2000);
		//
		UiObject connect = new UiObject(new UiSelector().text("Connect"));
		try {
			if(connect.isEnabled()){
				connect.click();
			}
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

