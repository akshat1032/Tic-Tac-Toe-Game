package com.tictactoegame;

public class TicTacToeGame {

	private char ticTacToeBoard[];

	// Create game board and assign empty space to each index
	public void createBoard() {
		ticTacToeBoard = new char[10];
		for (int indexBoard = 0; indexBoard < ticTacToeBoard.length; indexBoard++) {
			ticTacToeBoard[indexBoard] = ' ';
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");

		TicTacToeGame gameObject = new TicTacToeGame();
		gameObject.createBoard();
	}
}
