package com.pkw.find.violet.ui.swing;

import java.applet.Applet;
import java.awt.Dimension;

import com.pkw.find.violet.Game;

public class AppletInitiator extends Applet {
	private static final long serialVersionUID = 1620319916520424064L;

	GridComponent screen;

	public static void main(String[] args) {
		new AppletInitiator();
	}

	@Override
	public void init() {
		Dimension dimension = screen.getPreferredSize();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		setSize(width, height + 5);
	}

	public AppletInitiator() {
		screen = new GridComponent(Game.start());
		add(screen);
	}
}
