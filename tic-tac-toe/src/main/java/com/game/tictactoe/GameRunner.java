package com.game.tictactoe;

import java.util.Scanner;

import com.game.tictactoe.constants.Cons;
import com.game.tictactoe.exception.GameException;

public class GameRunner {

	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(System.in);
			System.out.println(Cons.MSG_INITIAL_PROMPT);
			int size = scan.nextInt();
			Game game = new Game();
			game.createGameBoard(size);
			game.startGame();
			scan.close();
		} catch (GameException ge) {
			System.out.println(ge.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println(Cons.ERR_GAME_STOPPED);
		}
	}

}
