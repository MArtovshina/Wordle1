package Wordle.Game;

import Wordle.Util.SearchWorldInFile;
public class InputValidator {
    public static String inputValidate(String input, int lenString) {
        if (input.length() != lenString)
            throw new IllegalArgumentException("Длина строки должна быть равна 5");

        if (!input.matches("[а-яА-Я]+"))
            throw new IllegalArgumentException("Строка должна состоять только из русских букв");

        if (!SearchWorldInFile.checkWordInFile(input))
            throw new IllegalArgumentException("Такого слова нет");

        return input.toLowerCase();
    }
}
