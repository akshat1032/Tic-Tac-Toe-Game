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
	private char chooseLetter(Scanner userInput) {
		System.out.println("Enter your choice either X or O");
		char userChoice = userInput.next().toUpperCase().charAt(0);
		return userChoice;
	}

	// Display the board
	private void showBoard(char gameBoard[]) {
		for (int indexBoard = 1; indexBoard < gameBoard.length; indexBoard++) {
			System.out.print(gameBoard[indexBoard] + " |");
			if (indexBoard % 3 == 0)
				System.out.println();
		}
	}

	// User location choice
	private int userLocationChoice(char gameBoard[], Scanner userInput) {
		boolean loopCondition = true;
		int indexChoice = 0;
		while(loopCondition) {
			
			System.out.println("Enter your choice for index form 1 to 9");
			indexChoice = userInput.nextInt();
			try {
				if (gameBoard[indexChoice] == ' ') {
					break;
				} else {
					continue;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		return indexChoice;
	}
	
	//User move made
	private char[] userMoveMade(char gameBoard[], int indexChoice, char userChoice) {
		gameBoard[indexChoice] = userChoice;
		return gameBoard;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");

		char ticTacToeBoard[] = new char[10];
		TicTacToeGame gameObject = new TicTacToeGame();
		ticTacToeBoard = gameObject.createBoard();

		Scanner userInput = new Scanner(System.in);
		char userChoice = gameObject.chooseLetter(userInput);
		char computerChoice = ((userChoice == 'X') ? 'O' : 'X');
		gameObject.showBoard(ticTacToeBoard);
		int indexChoice = gameObject.userLocationChoice(ticTacToeBoard, userInput);
		ticTacToeBoard = gameObject.userMoveMade(ticTacToeBoard, indexChoice, userChoice);
		gameObject.showBoard(ticTacToeBoard);
	}
}
