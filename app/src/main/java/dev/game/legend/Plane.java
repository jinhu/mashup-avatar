package dev.game.legend;

public class Plane {
//	public Plane(Context c) {
//		super(c);
//	}

	int destX;

	int destY;

	int moveX;

	int moveY;

	int x;

	int y;

	public void move() {
		int deltaX = x - destX;
		int deltaY = y - destY;
		if (deltaX > 0 && deltaX < 20) {
			moveX = 0;
		}
		x = x + moveX;
		if (deltaY > 0 && deltaY < 20) {
			moveY = 0;
		}
		y = y + moveY;
	}

	public boolean arrived() {

		if (moveY == 0 && moveX == 0) {
			return true;
		}

		return false;
	}

	public void setDirection(int dx, int dy) {
		destX = dx;
		destY = dy;
		if (x - destX > 0) {
			moveX = -10;
		} else {
			moveX = 10;
		}
		if (y - destY > 0) {
			moveY = -10;
		} else {
			moveY = 10;
		}

	}
}
