package com.pkw.find.violet.ui.swing;

import java.awt.Dimension;

import javax.swing.JApplet;

import com.pkw.find.violet.Game;

public class AppletInitiator extends JApplet {
	private static final long serialVersionUID = 1620319916520424064L;

	GridComponent screen;

	@Override
	public void init() {
		super.init();
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
