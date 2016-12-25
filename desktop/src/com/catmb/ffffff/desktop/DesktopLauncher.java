package com.catmb.ffffff.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.catmb.ffffff.ffffff;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ffffff(), config);

		config.width = 800;
		config.height = 600;
		config.resizable = false;
		config.title = "ff ff ff";

	}
}
