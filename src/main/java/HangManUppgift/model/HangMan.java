package HangManUppgift.model;

public class HangMan {
    private String secretWord;
    private char[] wordBeingBuilt;
    private StringBuilder guessedLetters;
    private int maxGuesses;
    private int usedGuesses;

    // TEST: String SecretWord
    public HangMan() {
        this.secretWord = SecretWordGenerator.chooseSecretWord(); //TEST: secretWord;
        this.wordBeingBuilt = new char[secretWord.length()];
        this.guessedLetters = new StringBuilder();
        this.maxGuesses = 8;
        this.usedGuesses = 0;
    }

    public StringBuilder getGuessedLetters() {
        return guessedLetters;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public int getUsedGuesses() {
        return usedGuesses;
    }

    public String buildUnderScore(){
        if (guessedLetters.toString().length() < 1 )
            for (int i = 0; i < wordBeingBuilt.length; i++) {
                wordBeingBuilt[i] = '_';
            }
        return String.valueOf(wordBeingBuilt);
    }

    public String playTheGame(String guess) {
            if (guess.length() < 2) {
                if (secretWord.contains(guess)) {
                    if (guessedLetters.toString().contains(guess)) {
                        printMethod(8);
                        return "You already guessed that letter"; // For test purpose.
                    }
                    int index = secretWord.indexOf(guess);
                    wordBeingBuilt[index] = guess.toUpperCase().charAt(0);

                    while (index >= 0) {
                        wordBeingBuilt[index] = guess.charAt(0);
                        index = secretWord.indexOf(guess, index + 1);
                    }
                    guessedLetters.append("["+guess.charAt(0)+"]");
                    printMethod(3);
                } else {
                    if (guessedLetters.toString().contains(guess)) {
                        printMethod(8);
                        return "You already guessed that letter"; // For test purpose.
                    } else {
                        guessedLetters.append("["+guess.charAt(0)+"]");
                        printMethod(3);
                        usedGuesses++;
                        printMethod(5);
                    }
                }
            } else {
                if (guess.equalsIgnoreCase(secretWord)) {
                    for (int i = 0; i < wordBeingBuilt.length; i++) {
                        wordBeingBuilt[i] = secretWord.charAt(i);
                    }
                } else {
                    printMethod(7);
                    return "Wrong Guess"; // For test purpose.
                }
            }
            if (isFound()) {
                printMethod(2);
            }
            printMethod(1);
        return String.valueOf(wordBeingBuilt);
        }


    public void printMethod (int choice){
        if (choice == 1){
            System.out.print("Secret Word: ");
            for (char print:wordBeingBuilt){
                System.out.print(print+" ");
            }
            System.out.println("\nGuesses remaining: "+(maxGuesses-usedGuesses));
        }else if (choice == 2){
            System.out.println("\nYou Win!\n O - [Thanks!]\n/|\\\n/ \\");
        }else if (choice == 3){
            System.out.println(guessedLetters.toString());
        }else if (choice == 4){
            System.out.println("Welcome to Hang Man - Guess the secret word:");
        }else if (choice == 5){
            if (usedGuesses == 1) { System.out.println("|‾‾‾‾‾‾‾‾\n|\n|\n|\n☐‾‾‾‾‾‾‾☐"); }
            else if (usedGuesses == 2) { System.out.println("|‾‾‾‾‾‾‾‾|\n|\n|\n|\n☐‾‾‾‾‾‾‾☐"); }
            else if (usedGuesses == 3) { System.out.println("|‾‾‾‾‾‾‾‾|\n|\t\t O\n|\n|\n☐‾‾‾‾‾‾‾☐"); }
            else if (usedGuesses == 4) { System.out.println("|‾‾‾‾‾‾‾‾|\n|\t\t O\n|\t\t |\n|\n☐‾‾‾‾‾‾‾☐"); }
            else if (usedGuesses == 5) { System.out.println("|‾‾‾‾‾‾‾‾|\n|\t\t O\n|\t\t/|\n|\n☐‾‾‾‾‾‾‾☐"); }
            else if (usedGuesses == 6) { System.out.println("|‾‾‾‾‾‾‾‾|\n|\t\t O\n|\t\t/|\\\n|\n☐‾‾‾‾‾‾‾☐"); }
            else if (usedGuesses == 7) { System.out.println("|‾‾‾‾‾‾‾‾|\n|\t\t O\n|\t\t/|\\\n|\t\t/\n☐‾‾‾‾‾‾‾☐"); }
            else if (usedGuesses == 8) {  System.out.println("|‾‾‾‾‾‾‾‾|\n|\t\t O\n|\t\t/|\\\n|\t\t/ \\\n☐‾‾‾‾‾‾‾☐"); }
        }else if (choice == 6){
            System.out.println("You Lose!");
        }else if (choice == 7){
            System.out.println("Wrong Guess!\nGuess the secret word: ");
        }else if (choice == 8){
            System.out.println("You already guessed that letter!\nGuess the secret word: ");
        }
    }


    public boolean isFound(){
        return secretWord.equalsIgnoreCase(String.valueOf(wordBeingBuilt));
    }
}