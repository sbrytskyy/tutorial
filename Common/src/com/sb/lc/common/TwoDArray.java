package com.sb.lc.common;

public class TwoDArray {

	public static void print(int[][] board) {

		int width = board[0].length;
		int height = board.length;
		System.out.println(width + ":" + height);

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				System.out.println(board[x][y] + "[" + x + ":" + y + "]");
			}
		}
		
		int[][] sameSize2dArray = new int[height][width];
		System.out.println(sameSize2dArray);
	}

	public static void main(String[] args) {

		int[][] board;

		board = new int[][] {
			//@formatter:off
			{ 'A', 'B', 'C', 'E' }, 
			{ 'S', 'F', 'C', 'S' },
			{ 'A', 'D', 'E', 'E' } 
			//@formatter:on
		};
		
		print(board);
	}
}
