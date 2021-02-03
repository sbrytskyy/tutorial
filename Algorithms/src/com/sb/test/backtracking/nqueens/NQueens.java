package com.sb.test.backtracking.nqueens;

public class NQueens {

	private final int[][] board;
	private final int queensNum;

	public NQueens(int queensNum) {
		this.queensNum = queensNum;
		this.board = new int[queensNum][queensNum];
	}

	public void solve() {
		if (setQueen(0)) {
			printBoard();
		} else {
			System.out.println("No solution");
		}
	}

	private boolean setQueen(int col) {
		if (col == queensNum) {
			return true;
		}

		for (int row = 0; row < queensNum; row++) {
			board[row][col] = 1;
			if (isValidPos(row, col)) {
				if (setQueen(col + 1)) {
					return true;
				}
			}
			board[row][col] = 0;
		}

		return false;
	}

	private boolean isValidPos(int row, int col) {
		for (int c = 0; c < col; c++) {
			if (board[row][c] == 1) {
				return false;
			}
		}

		for (int c = col - 1, r = row - 1; c >= 0 && r >= 0; c--, r--) {
			if (board[r][c] == 1) {
				return false;
			}
		}

		for (int c = col - 1, r = row + 1; c >= 0 && r < queensNum; c--, r++) {
			if (board[r][c] == 1) {
				return false;
			}
		}

		return true;
	}

	private void printBoard() {
		for (int row = 0; row < queensNum; row++) {
			for (int col = 0; col < queensNum; col++) {
				if (board[row][col] == 1) {
					System.out.print(" Q ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		int queensNum = 8;
		NQueens sol = new NQueens(queensNum);
		sol.solve();
		System.out.println();

		long begin = System.currentTimeMillis();
		queensNum = 32;
		sol = new NQueens(queensNum);
		sol.solve();
		long end = System.currentTimeMillis();
		System.out.println("Runtime: " + (end - begin));
	}
}
