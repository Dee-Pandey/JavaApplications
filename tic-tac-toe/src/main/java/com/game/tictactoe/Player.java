package com.game.tictactoe;

import java.util.Scanner;

import com.game.tictactoe.constants.Constants;
import com.game.tictactoe.constants.PlayerSymbol;

public class Player {

	private GameBoard gameBoard;
	private PlayerSymbol playerName;

	public Player(PlayerSymbol x, GameBoard gameBoard) {
		this.playerName = x;
		this.gameBoard = gameBoard;
	}

	public void move() {
		System.out.println(String.format(Constants.MSG_YOUR_MOVE_PROMPT, playerName));

		while (true) {
			boolean isStepComplete = false;
			int row = 0;
			int col = 0;
			do {
				try {
					Scanner scan = new Scanner(System.in);
					System.out.println(Constants.MSG_ENTER_ROW_PROMPT);
					row = scan.nextInt();
					System.out.println(Constants.MSG_ENTER_COL_PROMPT);
					col = scan.nextInt();
					isStepComplete = true;
				} catch (Exception e) {
					System.out.println(Constants.ERR_INVALID_TYPE);
				}
			} while (!isStepComplete);

			if (isMoveInBoardBounds(row, col)) {
				if (!gameBoard.fillPlayerSymbolAtPosition(row, col, playerName)) {
					System.out.println(Constants.ERR_POSITION_TAKEN);
				} else {
					gameBoard.fillPlayerSymbolAtPosition(row, col, playerName);
					System.out.println("");
					System.out.println("Player " + playerName + ":");
					break;
				}
			} else {
				System.out.println(Constants.ERR_INVALID_MOVE);
			}
		}
		gameBoard.display();
	}

	public void celebrateVictory() {
		System.out.println();
		System.out.println(String.format(Constants.MSG_WINS, playerName));
	}

	private boolean isMoveInBoardBounds(int row, int col) {
		return row > 0 && row <= gameBoard.getSizeOfSquare() && col > 0 && col <= gameBoard.getSizeOfSquare();
	}

}
