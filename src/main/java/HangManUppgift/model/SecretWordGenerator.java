package HangManUppgift.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class SecretWordGenerator {
    //Jag inser att min path inte kommer vara din path om du kör programmet från din dator. Har ej hittat ett sätt runt det ännu.

    private static File file = new File ("C:\\Users\\Benjamin\\IdeaProjects\\HangManUppgift\\src\\main\\java\\HangManUppgift\\model\\Words.txt");


    public static String chooseSecretWord() {
        Random random = new Random();
        String[] wordList = wordlistToArray(file);
        String secretWord = wordList[random.nextInt(wordList.length)].toUpperCase();
        return secretWord;
    }

    public static String[] wordlistToArray(File words){
        String [] wordListArray = new String[213];
        try {
            Scanner scan = new Scanner(words);
            for (int i = 0; i < wordListArray.length ; i++) {
                wordListArray[i] = scan.next();
            }
            return wordListArray;
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }



}



