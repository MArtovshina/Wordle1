package Wordle.Menu;

public enum MenuOption {
    NEW_GAME("1", "Новая игра"),
    DESCRIPTION("2", "Описание"),
    EXIT("3", "Выход");

    private final String option;
    private final String description;

    MenuOption(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public String getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption getByOption(String option) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.getOption().equals(option)) {
                return menuOption;
            }
        }
        return null;
    }
}