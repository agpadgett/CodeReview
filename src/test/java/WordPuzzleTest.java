import org.junit.*;
//import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;
import spark.template.velocity.VelocityTemplateEngine;

public class WordPuzzleTest{
  public static void main(String[] args){}

  // @Test
  // public void wordPuzzleApp_outputIsString_returnString(){
  //   WordPuzzleApp testWordPuzzle = new WordPuzzleApp();
  //   String fakeResult = "Cookie";
  //   assertEquals(fakeResult, testWordPuzzle.wordPuzzle("Cookie"));
  // }

  @Test
  public void wordPuzzleApp_ifVowel_returnsdash(){
    WordPuzzleApp testWordPuzzle = new WordPuzzleApp();
    String fakeResult = "c--k--";
    assertEquals(fakeResult, testWordPuzzle.wordPuzzle("cookie"));
  }

  @Test
  public void wordPuzzleApp_ifCapital_returnsdahs(){
    WordPuzzleApp testWordPuzzle = new WordPuzzleApp();
    String fakeResult = "C--K--";
    assertEquals(fakeResult, testWordPuzzle.wordPuzzle("COOKIE"));
  }

}
