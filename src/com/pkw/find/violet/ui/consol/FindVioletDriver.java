package com.pkw.find.violet.ui.consol;

import java.util.Random;
import java.util.Scanner;

import com.pkw.find.violet.Block;
import com.pkw.find.violet.Grid;
import com.pkw.find.violet.Position;

public class FindVioletDriver {

	private static Grid grid = Grid.create();

	public static void main(String[] args) {
		addRandomRedOrRedOrange();
		addRandomRedOrRedOrange();
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		while (exit == false) {
			System.out.println(grid);
			System.out.println("Valid Input: Right, Left, Up, Down, Exit.");
			String input = scanner.nextLine();
			input = input.toLowerCase();
			input = input.trim();
			switch (input) {
			case "left":
				grid.left();
				addRandomRedOrRedOrange();
				break;
			case "right":
				grid.right();
				addRandomRedOrRedOrange();
				break;
			case "up":
				grid.up();
				addRandomRedOrRedOrange();
				break;
			case "down":
				grid.down();
				addRandomRedOrRedOrange();
				break;
			case "exit":
				exit = true;
				break;
			default:
				System.out.println("Valid Input: Right, Left, Up, Down, Exit.");
				break;
			}
		}
		scanner.close();
	}

	private static void addRandomRedOrRedOrange() {
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

}
