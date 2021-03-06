package com.game.tictactoe;

import com.game.tictactoe.constants.Constants;
import com.game.tictactoe.constants.PlayerSymbol;

public class GameBoard {

	private int sizeOfBoard = 0;
	private int sizeOfSquare = 0;
	private char[][] gameGrid = null;

	public GameBoard(int sizeOfBoard, int sizeOfSquare) {
		this.sizeOfBoard = sizeOfBoard;
		this.sizeOfSquare = sizeOfSquare;
	}

	public char[][] getGameGrid() {
		return this.gameGrid;
	}

	public void setGameGrid(char[][] board) {
		this.gameGrid = board;
	}

	public int getSizeOfSquare() {
		return this.sizeOfSquare;
	}

	public void setSizeOfSquare(int sizeOfSquare) {
		this.sizeOfSquare = sizeOfSquare;
	}

	public int getSizeOfBoard() {
		return this.sizeOfBoard;
	}

	public void setSizeOfBoard(int sizeOfBoard) {
		this.sizeOfBoard = sizeOfBoard;
	}

	public boolean fillPlayerSymbolAtPosition(int row, int col, PlayerSymbol playerName) {
		char symbol = fetchPlayerSymbol(playerName);

		if (row % 2 != 0) {
			row = (row - 1) * 2;
		}
		if (col % 2 != 0) {
			col = (col - 1) * 2;
		}

		if (isPositionAlreadyFilled(row, col)) {
			return false;
		} else {
			gameGrid[row][col] = symbol;
		}
		return true;
	}

	/**
	 * Given a playerName, it fetches the symbol associated
	 * 
	 * @param playerName
	 * @return
	 */
	private char fetchPlayerSymbol(PlayerSymbol playerName) {
		char symbol = Constants.CHAR_SPACE;
		if (playerName.equals(PlayerSymbol.X)) {
			symbol = Constants.CHAR_X;
		} else if (playerName.equals(PlayerSymbol.O)) {
			symbol = Constants.CHAR_O;
		}
		return symbol;
	}

	/**
	 * Checks if the chosen position is already taken
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean isPositionAlreadyFilled(int row, int col) {
		return gameGrid[row][col] == Constants.CHAR_X || gameGrid[row][col] == Constants.CHAR_O;
	}

	public void display() {
		for (char[] row : gameGrid) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}