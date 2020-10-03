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
	
	//Allow player to choose a letter X or O
	private char chooseLetter(Scanner userInputLetter) {
		System.out.println("Enter your choice");
		char userChoice = userInputLetter.next().toUpperCase().charAt(0);
		return userChoice;
	}
	

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");
		
		char ticTacToeBoard[] = new char[10];
		TicTacToeGame gameObject = new TicTacToeGame();
		ticTacToeBoard = gameObject.createBoard();
		
		Scanner userInputLetter = new Scanner(System.in);
		char userChoice = gameObject.chooseLetter(userInputLetter);
		int computerInput = (int)Math.floor((Math.random() * 10) % 2);
		char computerChoice;
		if (computerInput == 0) {
			computerChoice = 'X';
		} else {
			computerChoice = 'O';
		}
	}
}
