package Wordle.Game;

import Wordle.Util.Color;

public class WordCheck {
    private String Word;

    public WordCheck(String Word) {
        this.Word = Word;
    }

    public String getWord() {
        return Word;
    }

    public Color getColor(char inputChar, int index) {
        if (!Word.contains(String.valueOf(inputChar))) {
            return Color.RED;
        } else {
            if (Word.charAt(index) == inputChar) return Color.GREEN;
            else return Color.YELLOW;
        }
    }
}