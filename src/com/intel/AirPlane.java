package com.intel;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AirPlane extends UiAutomatorTestCase{
	public void testDemo(){
		UiDevice device = getUiDevice();
		try {
			device.wakeUp();			
			device.pressMenu();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		device.pressHome();
		
		
		try {
			Runtime.getRuntime().exec("am start -n com.android.settings/.Settings");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UiObject more = new UiObject(new UiSelector().text("More"));
		try {
			more.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UiObject air = new UiObject(new UiSelector().text("Airplane mode"));
		try {
			air.click();
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		device.pressBack();
		device.pressHome();
	}
}
