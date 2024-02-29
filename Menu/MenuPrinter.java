package Wordle.Menu;

public class MenuPrinter {
    public static void printMenu() {
        System.out.println("Игра Worlde");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getOption() + ". " + option.getDescription());
        }
        System.out.print("Выберите действие: ");
    }
}
