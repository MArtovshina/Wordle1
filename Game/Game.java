package Wordle.Game;

import java.util.Random;

import Wordle.Util.Color;
import Wordle.Util.Letter;

import static Wordle.Util.Color.*;

public class Game {
    private int attempt = 0;
    private int maxAttempts = 6;
    private static int lenString = 5;
    private String[] worlds = new String[]{"леток", "папеж", "ранец", "сойка", "крапп", "живьё", "юферс", "обвоз", "тугун",
            "мадам", "умора", "ляссе", "леска", "плешь", "врата", "лыжня", "отара", "кулич", "отдых",
            "мысок", "косая", "синец", "согра", "цевка", "сленг", "невер", "занос", "униат", "санки",
            "грань", "зельц", "отжим", "силач", "тодес", "досев", "негус", "фасад", "взлом", "обряд",
            "гуцул", "покой", "гольф", "культ", "обнос", "скорм", "умище", "рычаг", "фатюй", "вымор",
            "метол", "шпала", "хапун", "побои", "наезд", "мотор", "сплин", "мазар", "джинн", "копия",
            "мураш", "отчёт", "нитка", "коник", "брешь", "шейка", "совок", "вепрь", "ерник", "шипун",
            "абрек", "плюха", "биток", "отлуп", "ордер", "цыбик", "ласка", "кореш", "герма", "жулик",
            "газон", "аргус", "ламут", "минор", "ствол", "таган", "разок", "задел", "адрес", "киста",
            "мётка", "лазок", "каноэ", "севок", "бурда", "пшено", "ткань", "парня", "злато", "солод", "накол"};

    public void startGame() {
        AttemptHistory attemptHistory = new AttemptHistory(maxAttempts, lenString, attempt);
        WordCheck wordCheck = new WordCheck(randomWord());

        while (true) {
            if (attemptHistory.AttemptsLimitReached()) {
                System.out.println("Вы исчерпали все попытки.\n" +
                        "искомое слово \"" + wordCheck.getWord() + "\"\n" +
                        "Игра завершена.\n");
                break;
            }
            try {
                System.out.print("Попытка " + (attempt + 1) + ". Введите слово: ");
                String inputWord = InputValidator.inputValidate(System.console().readLine().strip(), lenString);
                Letter[] letters = checkWord(wordCheck, inputWord);
                attemptHistory.addAttempt(letters);
                attempt++;

                if (allLettersMatch(letters)) {
                    System.out.println("Поздравляем! Вы угадали слово.\n");
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
            if (attempt > 0) attemptHistory.printHistory();
            System.out.println("Осталось попыток: " + (maxAttempts - attempt) + "\n");
        }
    }

    private boolean allLettersMatch(Letter[] letters) {
        for (Letter letter : letters) {
            if (letter.getColor() != GREEN) {
                return false;
            }
        }
        return true;
    }

    private Letter[] checkWord(WordCheck wordChecker, String inputWord) {
        Letter[] letters = new Letter[lenString];
        for (int index = 0; index < inputWord.length(); index++) {
            char inputChar = inputWord.charAt(index);
            Color color = wordChecker.getColor(inputChar, index);
            letters[index] = new Letter(inputChar, color);
        }
        return letters;
    }


    private String randomWord() {
        int index = new Random().nextInt(worlds.length);
        return worlds[index];
    }
}
