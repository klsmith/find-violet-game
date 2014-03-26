package com.pkw.find.violet;

import java.util.Random;

public class Game {

	private Grid grid;

	public static Game start() {
		return new Game();
	}

	private Game() {
		grid = Grid.create();
		addRandomRedOrRedOrange();
		addRandomRedOrRedOrange();
	}

	private void addRandomRedOrRedOrange() {
		Random random = new Random();
		int randomX = random.nextInt(Grid.SIZE);
		int randomY = random.nextInt(Grid.SIZE);
		Position randomPosition = Position.createAt(randomX, randomY);
		while (grid.hasBlockAt(randomPosition)) {
			randomX = random.nextInt(Grid.SIZE);
			randomY = random.nextInt(Grid.SIZE);
			randomPosition = Position.createAt(randomX, randomY);
		}
		Boolean randomIsRed = random.nextBoolean();
		if (randomIsRed) {
			grid.addBlockAt(Block.RED, randomPosition);
		} else {
			grid.addBlockAt(Block.RED_ORANGE, randomPosition);
		}
	}

	public boolean gridIsFull() {
		Position currentPosition = Position.createAt(0, 0);
		while (isNotAtBottom(currentPosition)) {
			while (isNotAtRight(currentPosition)) {
				if (!grid.hasBlockAt(currentPosition)) {
					return false;
				}
				currentPosition.moveRight();
			}
			currentPosition.setX(0);
			currentPosition.moveDown();
		}
		return true;
	}

	private boolean isNotAtBottom(Position position) {
		return position.getY() <= Grid.BOTTOM_Y;
	}

	private boolean isNotAtRight(Position position) {
		return position.getX() <= Grid.RIGHT_X;
	}

	public void actionLeft() {
		Grid temp = grid.clone();
		grid.left();
		if (!grid.equals(temp)) {
			addRandomRedOrRedOrange();
		}
	}

	public void actionRight() {
		Grid temp = grid.clone();
		grid.right();
		if (!grid.equals(temp)) {
			addRandomRedOrRedOrange();
		}
	}

	public void actionUp() {
		Grid temp = grid.clone();
		grid.up();
		if (!grid.equals(temp)) {
			addRandomRedOrRedOrange();
		}
	}

	public void actionDown() {
		Grid temp = grid.clone();
		grid.down();
		if (!grid.equals(temp)) {
			addRandomRedOrRedOrange();
		}
	}

	public void printGrid() {
		System.out.println(grid);
	}
}
