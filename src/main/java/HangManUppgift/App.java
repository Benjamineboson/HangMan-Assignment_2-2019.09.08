package HangManUppgift;

import HangManUppgift.model.HangMan;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HangMan test = new HangMan(); //("TEST");
        boolean keepAlive;
        test.printMethod(4);
        do {
            test.buildUnderScore();
            test.playTheGame(scan.nextLine().toUpperCase());
            keepAlive = test.isFound();
            if (test.getMaxGuesses() <= test.getUsedGuesses()){
                keepAlive = true;
                test.printMethod(6);
            }
        }while (!keepAlive);
    }
}