package Wordle.Menu;

import Wordle.Game.*;
public class MenuHandler {

    public static void handleUserChoice(String userChoice) {
        MenuOption option = MenuOption.getByOption(userChoice);
        if (option != null) {
            switch (option) {
                case NEW_GAME:
                    startNewGame();
                    break;
                case DESCRIPTION:
                    System.out.println("\nОписание игры\n");
                    break;
                case EXIT:
                    System.out.println("\nВыход\n");
                    break;
            }
        } else {
            System.out.println("\nНекорректный ввод. Попробуйте снова.\n");
        }
    }

    private static void startNewGame() {
        Game game = new Game();
        game.startGame();
    }
}
