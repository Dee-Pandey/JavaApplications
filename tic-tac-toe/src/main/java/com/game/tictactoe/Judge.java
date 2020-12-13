package com.game.tictactoe;

import java.util.HashSet;
import java.util.Set;

import com.game.tictactoe.constants.Constants;
import com.game.tictactoe.exception.GameException;

public class Judge {

	private GameBoard gameBoard;

	public Judge(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public boolean isGameComplete() {
		String result = "";
		int positionsFilled = 0;
		char[][] gameGrid = gameBoard.getGameGrid();
		Set<Character> winningRow = new HashSet<>();
		Set<Character> winningCol = new HashSet<>();
		Set<Character> winningDiagonal = new HashSet<>();
		Set<Character> winningCrossDiagonal = new HashSet<>();
		for (int i = 0; i <= gameBoard.getSizeOfBoard(); i += 2) {
			winningRow.clear();
			winningCol.clear();
			winningDiagonal.clear();
			winningCrossDiagonal.clear();
			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				winningRow.add(gameGrid[i][j]);
			}
			if (isStripComplete(winningRow)) {
				return true;
			}

			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				winningCol.add(gameGrid[j][i]);
			}
			if (isStripComplete(winningCol)) {
				return true;
			}

			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				for (int k = 0; k <= gameBoard.getSizeOfBoard(); k += 2) {
					if (j == k)
						winningDiagonal.add(gameGrid[j][k]);
				}
			}

			if (isStripComplete(winningDiagonal)) {
				return true;
			}

			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				for (int k = 0; k <= gameBoard.getSizeOfBoard(); k += 2) {
					if ((j + k) == (gameBoard.getSizeOfBoard() - 1))
						winningCrossDiagonal.add(gameGrid[j][k]);
				}
			}
			if (isStripComplete(winningCrossDiagonal)) {
				return true;
			}

			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				if (gameGrid[i][j] != Constants.CHAR_SPACE)
					positionsFilled += 1;
			}
		}
		if (positionsFilled == (gameBoard.getSizeOfSquare() * gameBoard.getSizeOfSquare()) && result.isEmpty()) {
			throw new GameException(Constants.MSG_NONE_WINS);
		}

		return result.isEmpty() ? false : true;
	}

	private boolean isStripComplete(Set<Character> strip) {
		return strip.size() == 1 && !strip.contains(Constants.CHAR_SPACE);
	}

}
