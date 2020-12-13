package com.game.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.game.tictactoe.constants.Constants;
import com.game.tictactoe.exception.GameException;

public class GameRunner {

	public static void main(String[] args) {
		int x=1;
		int size=0;
		do {
			try {
				Scanner scan=new Scanner(System.in);
				System.out.println(Constants.MSG_INITIAL_PROMPT);
				while(true) {
				size=scan.nextInt(); 
				if(size<2)
					System.out.println(Constants.MSG_ENTER_SIZE_PROMPT);
				else
				{
					Game game = new Game();
					game.createGameBoard(size);
					game.startGame();
					scan.close();
					break;
				}
				}
				x=2;
				}
	
			catch (GameException ge) {
				System.out.println(ge.getLocalizedMessage());
				break;										//Here break stops game once game is drawn.
			}catch(NumberFormatException e){
				System.out.println(Constants.ERR_INVALID_TYPE);
			}catch(InputMismatchException e){
				System.out.println(Constants.ERR_INVALID_TYPE);
			}
			catch(Exception e){
				System.out.println(e.getMessage());	
			}
		}while(x==1);
	}
}
