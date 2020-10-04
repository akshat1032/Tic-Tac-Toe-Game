package com.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {

	private static final int HEAD_FOR_USER = 1;
	private static int playerOption = 0;

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
		int indexChoice = 0;
		String activePlayer = "";
		if (playerOption == 1) {
			activePlayer = "User";
		} else {
			activePlayer = "Computer";
		}
		while (true) {
			System.out.println(activePlayer + ", enter your choice for index form 1 to 9");
			indexChoice = userInput.nextInt();
			try {
				if (gameBoard[indexChoice] == ' ') {
					break;
				} else {
					continue;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		return indexChoice;
	}

	// User move made
	private char[] userMoveMade(char gameBoard[], int indexChoice, char userChoice) {
		gameBoard[indexChoice] = userChoice;
		return gameBoard;
	}

	// Toss done
	private int tossFirstPlayer() {
		int toss = (int) (Math.floor(Math.random() * 10) % 2);
		return toss;
	}

	// Check for win, tie or turn change
	private int checkWinTieChange(char gameBoard[], char choice) {
		int optionWinTieChange = 0;
		int indexBoard = 1;
		if ((gameBoard[1] == gameBoard[2] && gameBoard[2] == gameBoard[3] && gameBoard[1] == choice)
				|| (gameBoard[4] == gameBoard[5] && gameBoard[5] == gameBoard[6] && gameBoard[4] == choice)
				|| (gameBoard[7] == gameBoard[8] && gameBoard[8] == gameBoard[9] && gameBoard[7] == choice)
				|| (gameBoard[1] == gameBoard[4] && gameBoard[4] == gameBoard[7] && gameBoard[1] == choice)
				|| (gameBoard[2] == gameBoard[5] && gameBoard[5] == gameBoard[8] && gameBoard[2] == choice)
				|| (gameBoard[3] == gameBoard[6] && gameBoard[6] == gameBoard[9] && gameBoard[3] == choice)
				|| (gameBoard[1] == gameBoard[5] && gameBoard[5] == gameBoard[9] && gameBoard[1] == choice)
				|| (gameBoard[3] == gameBoard[5] && gameBoard[5] == gameBoard[7] && gameBoard[3] == choice)) {
			if (playerOption == 1) {
				System.out.println("User is the winner");
				this.showBoard(gameBoard);
				optionWinTieChange = 1;
			} else if (playerOption == 0) {
				System.out.println("Computer is the winner");
				this.showBoard(gameBoard);
				optionWinTieChange = 1;
			}
		} else {
			for (indexBoard = 1; indexBoard < gameBoard.length; indexBoard++) {
				if (gameBoard[indexBoard] != ' ') {
					continue;
				} else {
					optionWinTieChange = 0;
					break;
				}
			}
			if (indexBoard == 10) {
				System.out.println("Game Tie");
				this.showBoard(gameBoard);
				optionWinTieChange = 1;
			}
		}
		if (playerOption == 1) {
			playerOption = 0;
		} else {
			playerOption = 1;
		}
		return optionWinTieChange;
	}

	// Check if user can win
	private char canUserWin(Scanner userInput) {
		char winOrNotWin = ' ';
		String activePlayer = "";
		if(playerOption == 1) {
			activePlayer = "User";
		}
		else {
			activePlayer = "Computer";
		}
		while (true) {
			System.out.println(activePlayer+", can you win (Y/N)?");
			winOrNotWin = userInput.next().toUpperCase().charAt(0);
			if (winOrNotWin != 'Y' && winOrNotWin != 'N') {
				System.out.println("You can only enter Y or N.");
				continue;
			}
			else {
				break;
			}
		}
		return winOrNotWin;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");

		char ticTacToeBoard[] = new char[10];
		TicTacToeGame gameObject = new TicTacToeGame();
		ticTacToeBoard = gameObject.createBoard();

		Scanner userInput = new Scanner(System.in);
		char userChoice = gameObject.chooseLetter(userInput);
		char computerChoice = ((userChoice == 'X') ? 'O' : 'X');
		int firstPlayer = gameObject.tossFirstPlayer();
		if (firstPlayer == HEAD_FOR_USER) {
			System.out.println("User will start");
			playerOption = 1;
		} else {
			System.out.println("Computer will start");
			playerOption = 0;
		}
		while (true) {
			char choice = ' ';
			if (playerOption == 1) {
				choice = userChoice;
			} else {
				choice = computerChoice;
			}
			gameObject.showBoard(ticTacToeBoard);
			char winOrNotWin = gameObject.canUserWin(userInput);
			if (winOrNotWin == 'Y') {
				System.out.println("Enter the index to win");
			}
			int indexChoice = gameObject.userLocationChoice(ticTacToeBoard, userInput);
			ticTacToeBoard = gameObject.userMoveMade(ticTacToeBoard, indexChoice, choice);
			int checkWinTieChange = gameObject.checkWinTieChange(ticTacToeBoard, choice);
			if (checkWinTieChange == 1) {
				break;
			} else {
				continue;
			}
		}
	}
}
