package org.example;
import java.util.Scanner;
import static org.example.Util.Result.SEMI_HIT;
import static org.example.Util.Result.MISS;
import static org.example.Util.Result.HIT;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int maxAttempts = 6;
        System.out.println("|||||||||||||||||||");
        System.out.println("Welcome to Wordle");
        System.out.println("|||||||||||||||||||");
        String RandomWord = Util.getRandomWord();
        while( count < maxAttempts) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nWhat is your guess");
            String userGuess = scanner.nextLine().toLowerCase();
            boolean isFiveLetters;
            isFiveLetters = userGuess.length() == 5;
            count = count + 1;
            System.out.println("Attempt " + count + "/6");

            while (!isFiveLetters) {
                System.out.println("Make sure to guess a 5 letter word!");
                System.out.println("\nWhat is your guess");
                userGuess = scanner.nextLine().toLowerCase();
                isFiveLetters = userGuess.length() == 5;
            }

            if(userGuess.equalsIgnoreCase(RandomWord)){
                //count = count + 1;
                System.out.println("\nYou got it in " + count + " tries");
                System.exit(0);
            }

            char[] userCharacter = userGuess.toCharArray();
            char[] randomwordchar = RandomWord.toCharArray();

            for (int i = 0; i < 5; i++) {
                if (RandomWord.indexOf(userCharacter[i]) != -1) {
                    if (randomwordchar[i] == userCharacter[i]) {
                        System.out.print(Util.getFormattedLetter(userCharacter[i], HIT));
                    } else System.out.print(Util.getFormattedLetter(userCharacter[i], SEMI_HIT));
                } else {
                    System.out.print(Util.getFormattedLetter(userCharacter[i], MISS));

                }

            }

            }
        System.out.println("\nYou loose. The word was " + RandomWord);
        }
    }


