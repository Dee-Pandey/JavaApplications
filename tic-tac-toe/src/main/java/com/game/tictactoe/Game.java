package com.game.tictactoe;

import com.game.tictactoe.constants.Cons;

public class Game {

	private GameBoard gameBoard;

	public void createGameBoard(int size) {
		int sizeOfBoard = size + size - 1;
		int sizeOfSquare = size;
		this.gameBoard = new GameBoard(sizeOfBoard, sizeOfSquare);
		char[][] board = new char[sizeOfBoard][sizeOfBoard];
		for (int i = 0; i < sizeOfBoard; i++) {
			for (int j = 0; j < sizeOfBoard; j++) {
				if (isEven(i)) {
					if (isEven(j)) {
						board[i][j] = Cons.SEPARATOR_SPACE;
					} else {
						board[i][j] = Cons.SEPARATOR_PIPE;
					}
				} else {
					if (isEven(j)) {
						board[i][j] = Cons.SEPARATOR_MINUS;
					} else {
						board[i][j] = Cons.SEPARATOR_PLUS;
					}
				}
			}
		}
		this.gameBoard.setGameGrid(board);
	}

	public void startGame() {
		gameBoard.display();
		System.out.println(Cons.MSG_BOARD_CREATION_SUCCESS);

		Player playerX = new Player(Cons.PLAYER_X, this.gameBoard);
		Player playerO = new Player(Cons.PLAYER_O, this.gameBoard);
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

		System.out.println(Cons.MSG_THANKS);
	}

	private boolean isEven(int coordinate) {
		return coordinate % 2 == 0;
	}
}
