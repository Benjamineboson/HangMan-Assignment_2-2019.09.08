package HangManUppgift;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import HangManUppgift.model.HangMan;
import org.junit.Test;

public class AppTest 
{

    private HangMan testObject;

    // TEST
//    @Before
//    public void init (){
//    testObject = new HangMan("Test".toUpperCase());
//    }

  @Test
  public void test_Word_Being_Built_Display(){
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
    public void test_Word_Being_Built_Display_Wrong_Guess(){
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
    public void test_Word_Being_Built_Display_Guessing_Used_Letter_Contained(){
        testObject.getGuessedLetters().append("S");
        String inPut = "S";
        String expected = "You already guessed that letter";
        String actual = testObject.playTheGame(inPut);
        assertEquals(expected,actual);
    }

    @Test
    public void test_Word_Being_Built_Display_Guessing_Used_Letter_Not_Contained(){
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
}
