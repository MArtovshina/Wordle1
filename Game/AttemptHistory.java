package Wordle.Game;

import Wordle.Util.Color;
import Wordle.Util.Letter;

public class AttemptHistory {
    private final Letter[][] attemptHistory;
    private final int maxAttempts;
    private int attempt;

    public AttemptHistory(int maxAttempts, int lenString, int attempt) {
        this.maxAttempts = maxAttempts;
        this.attemptHistory = new Letter[maxAttempts][lenString];
        this.attempt = attempt;
    }

    public void addAttempt(Letter[] letters) {
        attemptHistory[attempt] = letters;
        attempt++;
    }

    public boolean AttemptsLimitReached() {
        return attempt == maxAttempts;
    }

    public void printHistory() {
        System.out.println("\nИстория попыток:");
        for (int i = 0; i < attempt; i++) {
            System.out.print("Попытка " + (i + 1) + ": ");
            for (Letter letter : attemptHistory[i]) {
                System.out.print(colorize(letter.getLetter(), letter.getColor()) + " ");
            }
            System.out.println();
        }
    }

    private String colorize(char ch, Color color) {
        return color.getCode() + ch + Color.RESET.getCode();
    }
}

