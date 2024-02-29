package Wordle.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchWorldInFile {

    public static boolean checkWordInFile(String input){
        Scanner scanner;

            try {
                scanner = new Scanner(new File("worlds.txt"));
                while (scanner.hasNextLine()) {
                    if (input.equals(scanner.nextLine())) return true;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        return false;
    }

}