package com.gunjan.ood;

public class DeckOfCard {


    public static void main(String[] args) {
        String[] suit = {"S", "D", "C", "H"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] deck = new String[52];

        // create deck of card
        System.out.println("creating deck of card");
        for(int i = 0 ; i < deck.length ; i++){
            deck[i] = rank[i%13] + suit[i/13];
            System.out.println(deck[i]);
        }

        // shuffle deck of card
        System.out.println("shuffling deck of card");
        for(int i = 0 ; i < deck.length ; i++){
            int index = (int)(Math.random() * deck.length);
            String temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
            System.out.println(deck[i]);
        }


    }
}
