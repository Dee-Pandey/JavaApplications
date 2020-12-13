package com.game.tictactoe;

import org.junit.Test;

import com.game.tictactoe.exception.GameException;

import junit.framework.TestCase;

public class TicTacToeTest 
    extends TestCase
{
	@Test
	public void testSize()
	{
		Game game = new Game();
		game.createGameBoard(3);
		assertEquals(5, game.getGameBoard().getSizeOfBoard());
		assertEquals(3, game.getGameBoard().getSizeOfSquare());
	}

	@Test
	public void testDraw()
	{
		Game game = new Game();
		game.createGameBoard(3);
		game.getGameBoard().fillPlayerSymbolAtPosition(1, 1, "X");
		game.getGameBoard().fillPlayerSymbolAtPosition(1, 2, "O");
		game.getGameBoard().fillPlayerSymbolAtPosition(1, 3, "X");
		game.getGameBoard().fillPlayerSymbolAtPosition(2, 1, "O");
		game.getGameBoard().fillPlayerSymbolAtPosition(2, 3, "X");
		game.getGameBoard().fillPlayerSymbolAtPosition(2, 2, "O");
		game.getGameBoard().fillPlayerSymbolAtPosition(3, 2, "X");
		game.getGameBoard().fillPlayerSymbolAtPosition(3, 3, "O");
		game.getGameBoard().fillPlayerSymbolAtPosition(3, 1, "X");
		Judge judge=null;
		try
		{
		 judge = new Judge(game.getGameBoard());
		}
		catch(GameException ge)
		{
			assertEquals("GAME ENDS WITH A DRAW", ge.getMessage());
		}
	}
	@Test
	public void testBoard()
	{
		Game game = new Game();
		game.createGameBoard(3);
		char [][] board = game.getGameBoard().getGameGrid();
		   System.out.println(board[0][1]);
		   assertEquals(board[0][1], '|');
		   assertEquals(board[1][0], '-');
		   assertEquals(board[1][1], '+');
	}
	
	@Test
	public void testWin()
	{
		Game game = new Game();
		game.createGameBoard(3);
		game.getGameBoard().fillPlayerSymbolAtPosition(1, 1, "X");
		game.getGameBoard().fillPlayerSymbolAtPosition(1, 2, "X");
		game.getGameBoard().fillPlayerSymbolAtPosition(1, 3, "X");
		Judge judge = new Judge(game.getGameBoard());
		
		assertEquals(true, judge.isGameComplete());
	}
}
