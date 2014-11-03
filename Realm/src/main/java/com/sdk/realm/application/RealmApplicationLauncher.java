package com.sdk.realm.application;


public class RealmApplicationLauncher {

	public RealmApplicationLauncher() {
	}

	public static void main(String[] args) {

		// create the application launcher ui and launch it
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				RealmApplicationLauncherJFrame aFrame = new RealmApplicationLauncherJFrame();
				aFrame.setTitle("Realm - Application Launcher");
				RealmApplicationLauncherController aController = new RealmApplicationLauncherController(aFrame);
				aFrame.setController(aController);
				aController.makeFrameVisable();
			}
		});


	}

}
