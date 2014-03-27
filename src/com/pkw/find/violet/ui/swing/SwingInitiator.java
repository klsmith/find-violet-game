package com.pkw.find.violet.ui.swing;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.pkw.find.violet.Game;
import com.pkw.find.violet.Grid;

public class SwingInitiator {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new GridComponent(Game.start()));
		int size = Grid.GRID_SIZE_IN_PIXELS * Grid.SIZE;
		frame.setPreferredSize(new Dimension(size, size));
		frame.pack();
		frame.setVisible(true);
	}
}
