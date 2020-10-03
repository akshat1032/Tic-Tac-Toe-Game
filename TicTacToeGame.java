package com.tictactoegame;

public class TicTacToeGame {
	
	private char ticTacToeBoard[];
	
	public void createBoard() {
		
		ticTacToeBoard = new char[10];
		for(int i = 0; i<10; i++) {
			ticTacToeBoard[i] = ' ';
		}
	}

	public static void main(String[] args) {
	
		System.out.println("Welcome to Tic Tac Toe game");
		
		TicTacToeGame gameObject = new TicTacToeGame();
		gameObject.createBoard();
	}
}
