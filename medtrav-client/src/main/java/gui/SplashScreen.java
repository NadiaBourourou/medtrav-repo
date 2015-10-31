package gui;

import java.awt.Color;

import com.thehowtotutorial.splashscreen.JSplash;

public class SplashScreen {


	public static void main(String[] args) throws InterruptedException {
		JSplash splash = new JSplash(
				SplashScreen.class.getResource("/images/medtrav.JPG"), true,
				true, false, " ", null, null, Color.red);
		splash.splashOn();
		splash.setProgress(20, "Initialisation");
		Thread.sleep(1000);
		splash.setProgress(40, "Loading");
		Thread.sleep(1000);
		splash.setProgress(60, "Applying configs");
		Thread.sleep(1000);
		splash.setProgress(80, "Starting app");
		Thread.sleep(1000);
		
		splash.splashOff();
	}
}
