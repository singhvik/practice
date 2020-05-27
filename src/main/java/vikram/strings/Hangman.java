package vikram.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1124/handouts/200%20Assignment%204.pdf
 * 
 * Game over on 8th wrong guess.
 */
public class Hangman {
    public static final int MAX_WRONG_GUESSES = 8;

    public static void main(String[] args) {
        HangmanLexicon hangmanLexicon = new Hangman().new HangmanLexicon();
        playHangman(hangmanLexicon.getWord());
    }

    public static void playHangman(String word) {
        int wrongGuesses = 0;
        List<Integer> correctlyGuessed = new ArrayList<>();
        boolean userWon = false;
        Scanner in = new Scanner(System.in);
        do {
            boolean pendingLetters = printWord(word, correctlyGuessed);
            if(!pendingLetters){
                userWon= true;
            break;
            }
            System.out.println();
            System.out.println("Number of guesses remaining are " + (MAX_WRONG_GUESSES - wrongGuesses));
            System.out.println("Please enter a letter");
            String input = in.nextLine();
            if (input.length() != 1 || !word.contains(input.toUpperCase())) {
                wrongGuesses++;
            } else {
                // its a match
                correctlyGuessed.add((int) input.toUpperCase().charAt(0));
            }

        } while (wrongGuesses < MAX_WRONG_GUESSES);

        if(userWon){
            System.out.println("\nCongratulations u guessed correctly.");
        }else {
            System.out.println("Sorry, game over!");
            System.out.println("Correct word is " + word);
        }


    }

    public static boolean printWord(String word, List<Integer> guessedLetters) {
        boolean pendingLetters =false;
        System.out.print("The word looks like this : ");
        for (int i = 0; i < word.length(); i++) {
            if (guessedLetters.contains((int)word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
                pendingLetters = true;
            }
        }
        return  pendingLetters;
    }

    public class HangmanLexicon {
        public final List<String> words = List.of("appetite",
                "undermine",
                "ordinary",
                "infrastructure",
                "inspiration",
                "permission",
                "constitutional",
                "syndrome",
                "judicial",
                "forecast",
                "repetition",
                "discipline",
                "hospitality",
                "inspector",
                "treatment",
                "prisoner",
                "operation",
                "deteriorate",
                "cupboard",
                "development",
                "sentence",
                "temporary",
                "execution",
                "profound",
                "exploration",
                "technique",
                "consciousness",
                "interactive",
                "perceive",
                "handicap",
                "entertainment",
                "represent",
                "constraint",
                "reflection",
                "strength",
                "hypothesis",
                "transparent",
                "restrict",
                "confusion",
                "distortion",
                "traction",
                "orientation",
                "memorial",
                "difficult",
                "buttocks",
                "disorder",
                "positive",
                "relaxation",
                "survival",
                "violation");

        public String getWord() {
            Random random = new Random();
            return words.get(random.nextInt(words.size())).toUpperCase();
        }
    }
}


