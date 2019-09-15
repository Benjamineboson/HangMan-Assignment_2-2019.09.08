package HangManUppgift;

import HangManUppgift.model.HangMan;
import HangManUppgift.model.SecretWordGenerator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AppTest 
{

    private HangMan testObject;

    /**
     * For test purpose
     */
//    @Before
//    public void init (){
//    testObject = new HangMan("Test".toUpperCase());
//    }

  @Test
  public void test_Play_The_Game(){
      char[] test = new char[4];
      test[0] = 't';
      test[1] = 'e';
      test[2] = 's';
      test[3] = 't';
      String expected = String.valueOf(test).toUpperCase();
      String actual = testObject.playTheGame(expected.toUpperCase());
      assertEquals(expected,actual);
  }

  @Test
  public void test_Play_The_Game_Add_Letter(){
  String expected = "Letter appended";
  String actual = testObject.playTheGame("S");
  assertEquals(expected,actual);
  }

    @Test
    public void test_Play_The_Game_Wrong_Guess(){
        char[] test = new char[4];
        test[0] = 't';
        test[1] = 'e';
        test[2] = 's';
        test[3] = 'q';
        String testArray = String.valueOf(test).toUpperCase();
        String actual = testObject.playTheGame(testArray);
        assertEquals("Wrong Guess",actual);
    }

    @Test
    public void test_Play_The_Game_Guessing_Used_Letter_Contained(){
        testObject.getGuessedLetters().append("S");
        String inPut = "S";
        String expected = "You already guessed that letter";
        String actual = testObject.playTheGame(inPut);
        assertEquals(expected,actual);
    }

    @Test
    public void test_Play_The_Game_Guessing_Used_Letter_Not_Contained(){
        testObject.getGuessedLetters().append("R");
        String inPut = "R";
        String expected = "You already guessed that letter";
        String actual = testObject.playTheGame(inPut);
        assertEquals(expected,actual);
    }



    @Test
    public void test_Build_Under_Score(){
        String expected = "____";
        String actual = testObject.buildUnderScore();
        assertEquals(expected,actual);
    }

    @Test
    public void test_Choose_Secret_Word(){
        String expected = "TEST";
        String actual = SecretWordGenerator.chooseSecretWord();
        assertEquals(expected,actual);
    }

    @Test
    public void test_Call_Wrong_File(){
        File test = new File("");
        String[] actual = SecretWordGenerator.wordlistToArray(test);
        assertArrayEquals(null,actual);
    }
}
