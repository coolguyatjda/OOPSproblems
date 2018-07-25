package com.jda.core;

import java.util.Random;

public class DeckOfCards {

	public static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	public static String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] str = shuffle();
		for(int i=0; i<4; i++) {
			System.out.print("Player " + i + ": ");
			for(int j=0; j<9; j++)
				System.out.print(str[i][j] + " ");
			System.out.println();
		}
		
	}
	public static String[][] shuffle() {
		String[][] cards = new String[4][9];
		int[][] track = new int[4][13];
		
		Random random = new Random();
		for(int x=0; x<4; x++) {
			for(int y=0; y<9; y++) {
				while(cards[x][y] == null) {
					int i = random.nextInt(3);
					int j = random.nextInt(12);
					if(track[i][j] != 1) {
						track[i][j] = 1;
						cards[x][y] = "[" + suits[i] + ":" + rank[j] + "]";
					}
				}
		}
		}
		return cards;
	}

}
