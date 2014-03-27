package com.pkw.find.violet.ui.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import com.pkw.find.violet.Game;

public class GridComponent extends JComponent {
	private static final long serialVersionUID = -8625472517625688212L;

	private final Game thisGame;

	public GridComponent(Game game) {
		this.thisGame = game;
		setFocusable(true);
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent event) {
				int keyCode = event.getExtendedKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_RIGHT:
					thisGame.actionRight();
					break;
				case KeyEvent.VK_LEFT:
					thisGame.actionLeft();
					break;
				case KeyEvent.VK_UP:
					thisGame.actionUp();
					break;
				case KeyEvent.VK_DOWN:
					thisGame.actionDown();
					break;
				case KeyEvent.VK_R:
					thisGame.actionRestart();
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent event) {
			}

			@Override
			public void keyTyped(KeyEvent event) {
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D drawer = (Graphics2D) g;
		thisGame.draw(drawer);
	}
}
