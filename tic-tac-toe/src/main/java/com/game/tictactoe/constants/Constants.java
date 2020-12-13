package com.game.tictactoe.constants;

public class Constants {

	/**
	 * Player constants
	 */
	public static final String MSG_WINS = "\nPLAYER %s WON\n";
	public static final String MSG_NONE_WINS = "GAME ENDS WITH A DRAW";

	public static final char CHAR_X = 'X';
	public static final char CHAR_O = 'O';
	public static final char CHAR_SPACE = ' ';

	/**
	 * Game constants
	 */
	public static final String MSG_INITIAL_PROMPT = "Please enter the size of the board:";
	public static final String MSG_BOARD_CREATION_SUCCESS = "Board Created.\nThe game will start with player X\n";
	public static final String MSG_YOUR_MOVE_PROMPT = "Hi player %s, enter your cell:";
	public static final String MSG_ENTER_ROW_PROMPT = "Enter row:";
	public static final String MSG_ENTER_COL_PROMPT = "Enter column:";
	public static final String MSG_THANKS = "Thanks for Playing Tic-Tac-Toe.";
	public static final String MSG_ENTER_SIZE_PROMPT = "Please enter the size greater than 1:";

	public static final String ERR_INVALID_TYPE = "Please enter an integer only:";
	public static final String ERR_POSITION_TAKEN = "This cell is already filled. Please re enter the cell: ";
	public static final String ERR_INVALID_MOVE = "Please enter both row and column less that size of the board and greater than 0:";
	public static final String ERR_GAME_STOPPED = "We faced some issue...\n Please restart the game again\n, If issue persist, please contact the Game developer";

	/**
	 * Board Layouts
	 */
	public static final char SEPARATOR_SPACE = ' ';
	public static final char SEPARATOR_PIPE = '|';
	public static final char SEPARATOR_MINUS = '-';
	public static final char SEPARATOR_PLUS = '+';
	

}
