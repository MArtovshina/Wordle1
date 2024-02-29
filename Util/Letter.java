package Wordle.Util;

public class Letter {
    private char letter;
    private Color color;

    public Letter(char letter, Color color) {
        this.letter = letter;
        this.color = color;
    }

    public char getLetter() {
        return letter;
    }

    public Color getColor() {
        return color;
    }
}