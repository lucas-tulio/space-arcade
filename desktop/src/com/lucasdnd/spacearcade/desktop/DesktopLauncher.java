package com.lucasdnd.spacearcade.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lucasdnd.spacearcade.SpaceArcade;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 640; // 160 * 4
		config.height = 576; // 144 * 4
		config.foregroundFPS = 60;
		config.vSyncEnabled = true;
		new LwjglApplication(new SpaceArcade(), config);
	}
}
