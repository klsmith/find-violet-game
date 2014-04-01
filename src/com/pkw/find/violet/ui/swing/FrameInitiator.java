package com.pkw.find.violet.ui.swing;

import javax.swing.JFrame;

import com.pkw.find.violet.Game;

public class FrameInitiator {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new GridComponent(Game.start()));
		frame.pack();
		frame.setVisible(true);
	}
}
