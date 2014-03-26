package com.pkw.find.violet.ui.consol;

import java.util.Scanner;

import com.pkw.find.violet.Game;

public class FindVioletDriver {

	public static void main(String[] args) {
		Game game = Game.start();
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		while (exit == false) {
			game.printGrid();
			if (game.gridIsFull()) {
				System.out.println("Game Over!");
				exit = true;
			} else {
				System.out.println("Valid Input: Right, Left, Up, Down, Exit.");
				String input = scanner.nextLine();
				input = input.toLowerCase();
				input = input.trim();
				switch (input) {
				case "left":
					game.actionLeft();
					break;
				case "right":
					game.actionRight();
					break;
				case "up":
					game.actionUp();
					break;
				case "down":
					game.actionDown();
					break;
				case "exit":
					exit = true;
					break;
				default:
					System.out
							.println("Valid Input: Right, Left, Up, Down, Exit.");
					break;
				}
			}
		}
		scanner.close();
	}
}
