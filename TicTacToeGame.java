package com.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {

	// Create game board and assign empty space to each index
	private char[] createBoard() {
		char ticTacToeBoard[] = new char[10];
		for (int indexBoard = 0; indexBoard < ticTacToeBoard.length; indexBoard++) {
			ticTacToeBoard[indexBoard] = ' ';
		}
		return ticTacToeBoard;
	}

	// Allow player to choose a letter X or O
	private char chooseLetter(Scanner userInputLetter) {
		System.out.println("Enter your choice either X or O");
		char userChoice = userInputLetter.next().toUpperCase().charAt(0);
		return userChoice;
	}

	// Display the board
	private void showBoard(char gameBoard[]) {
		for(int indexBoard = 1; indexBoard<gameBoard.length; indexBoard++) {
			System.out.print(gameBoard[indexBoard]+" |");
			if(indexBoard % 3 == 0 )
				System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");

		char ticTacToeBoard[] = new char[10];
		TicTacToeGame gameObject = new TicTacToeGame();
		ticTacToeBoard = gameObject.createBoard();

		Scanner userInputLetter = new Scanner(System.in);
		char userChoice = gameObject.chooseLetter(userInputLetter);
		char computerChoice = ((userChoice == 'X')?'O':'X');
		gameObject.showBoard(ticTacToeBoard);
	}
}
