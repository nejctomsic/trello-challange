package com.nejctomsic;

import java.util.Arrays;

public class TrelloChallenge {

    private final char[] CHARACTERS = "acdegilmnoprstuw".toCharArray();
    private long mWantedHash;
    private int mResultLength;

    public static void main(String[] args) {
        new TrelloChallenge(8, 25180466553932L).run();
    }

    public TrelloChallenge(int resultLength, long wantedHash) {
        mResultLength = resultLength;
        mWantedHash = wantedHash;
    }

    void run() {
        System.out.println("Started looking for a string with the length of " + mResultLength +
            " and hash " + mWantedHash);
        char[] guessArray = new char[mResultLength];
        Arrays.fill(guessArray, CHARACTERS[0]);
        iterate(0, guessArray);
    }

    void iterate(int position, char[] guessArray) {
        long currentHash;
        for (char character : CHARACTERS) {
            if (position < guessArray.length - 1) {
                iterate(position + 1, guessArray);
            }

            currentHash = hash(new String(guessArray));
            if (currentHash == mWantedHash) {
                System.out.println("We have a winner: " + new String(guessArray));
                break;
            }
            guessArray[position] = character;
        }
    }

    long hash (String s) {
        long h = 7;
        String letters = "acdegilmnoprstuw";
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            h = (h * 37 + letters.indexOf(chars[i]));
        }
        return h;
    }
}
