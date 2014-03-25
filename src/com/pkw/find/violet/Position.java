package com.pkw.find.violet;

public class Position {

	int x, y;

	private Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Position createAt(int x, int y) {
		return new Position(x, y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Position clone() {
		return new Position(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// public void move(Direction direction) {
	// switch (direction) {
	// case RIGHT:
	// moveRight();
	// break;
	// case UP:
	// moveUp();
	// break;
	// case LEFT:
	// moveLeft();
	// break;
	// case DOWN:
	// moveDown();
	// break;
	// }
	// }

	public void moveRight() {
		x++;
	}

	public void moveUp() {
		y--;
	}

	public void moveLeft() {
		x--;
	}

	public void moveDown() {
		y++;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (other instanceof Position) {
			Position otherPosition = (Position) other;
			return (x == otherPosition.x) && (y == otherPosition.y);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Position(" + x + ", " + y + ")";
	}
}