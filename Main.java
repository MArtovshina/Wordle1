package Wordle;

import Wordle.Menu.*;

public class Main {
    public static void main(String[] args) {
        String userChoice;

        do {
            MenuPrinter.printMenu();
            userChoice = System.console().readLine();
            MenuHandler.handleUserChoice(userChoice);

        } while (!userChoice.equals(MenuOption.EXIT.getOption()));
    }
}