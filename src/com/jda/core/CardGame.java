package com.jda.core;

import com.jda.util.Queue;

public class CardGame {

	public static DeckOfCards newDeck = new DeckOfCards();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] shuffeledDeck = newDeck.shuffle();
		for(int i=0; i<4; i++) {
			sort(shuffeledDeck[i]);
			System.out.print("Player " + i + " sorted cards ");
			for(int j=0; j<9; j++)
				System.out.print("[" + shuffeledDeck[i][j] + "]");
			System.out.println();
		}

	}
	public static String[] sort(String[] deck){
		int[][] trace = new int[4][13];
		for(int i=0; i<deck.length; i++) {
			String[] temp = deck[i].split(":");
			for(int j=0; j<4; j++) {
				if(temp[0].equals(newDeck.suits[j])) {
					for(int k=0; k<13; k++) {
						if(temp[1].equals(newDeck.rank[k])) {
							trace[j][k] = 1;
						}
					}
				}
			}
		}
		int count = 0;
		for(int i=0; i<4; i++)
			for(int j=0; j<13; j++) {
				if(trace[i][j] == 1) {
					deck[count] = newDeck.suits[i] + ":" + newDeck.rank[j];
					count++;
				}
			}
		return deck;
	}
	public static Queue<String> addCardsToQueue(String[] cards) {
		Queue<String> cardsQ = new Queue<>();
		for(String s : cards) {
			cardsQ.enqueue(s);
		}
		return cardsQ;
	}

}
