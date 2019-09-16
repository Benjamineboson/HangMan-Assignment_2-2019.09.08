package HangManUppgift;
import HangManUppgift.model.HangMan;
import java.util.Scanner;

public class Run {
    public static void run() {
        Scanner scan = new Scanner(System.in);
        HangMan hangManSession = new HangMan(); //("TEST");
            boolean keepAlive;
            hangManSession.printMethod(4);
            do {
                hangManSession.buildUnderScore();
                hangManSession.playTheGame(scan.nextLine().toUpperCase());
                keepAlive = hangManSession.isFound();
                if (hangManSession.getMaxGuesses() <= hangManSession.getUsedGuesses()) {
                    keepAlive = true;
                    hangManSession.printMethod(6);
                }
            } while (!keepAlive);
    }
}

