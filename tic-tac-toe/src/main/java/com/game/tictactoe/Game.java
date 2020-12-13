package com.game.tictactoe;

import com.game.tictactoe.constants.Constants;
import com.game.tictactoe.constants.PlayerSymbol;

public class Game {

	private GameBoard gameBoard;

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void createGameBoard(int size) {
		int sizeOfBoard = size + size - 1;
		int sizeOfSquare = size;
		this.gameBoard = new GameBoard(sizeOfBoard, sizeOfSquare);
		char[][] board = new char[sizeOfBoard][sizeOfBoard];
		for (int i = 0; i < sizeOfBoard; i++) {
			for (int j = 0; j < sizeOfBoard; j++) {
				if (isEven(i)) {
					if (isEven(j)) {
						board[i][j] = Constants.SEPARATOR_SPACE;
					} else {
						board[i][j] = Constants.SEPARATOR_PIPE;
					}
				} else {
					if (isEven(j)) {
						board[i][j] = Constants.SEPARATOR_MINUS;
					} else {
						board[i][j] = Constants.SEPARATOR_PLUS;
					}
				}
			}
		}
		this.gameBoard.setGameGrid(board);
	}

	public void startGame() {
		gameBoard.display();
		System.out.println(Constants.MSG_BOARD_CREATION_SUCCESS);

		Player playerX = new Player(PlayerSymbol.X, this.gameBoard);
		Player playerO = new Player(PlayerSymbol.O, this.gameBoard);
		Judge judge = new Judge(this.gameBoard);

		while (true) {
			playerX.move();
			if (judge.isGameComplete()) {
				playerX.celebrateVictory();
				break;
			}

			playerO.move();
			if (judge.isGameComplete()) {
				playerO.celebrateVictory();
				break;
			}
		}

	}

	private boolean isEven(int coordinate) {
		return coordinate % 2 == 0;
	}
}
