import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class WordPuzzleApp {
  public static void main(String[] args){

  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/form.vtl");
    return new ModelAndView(model, "templates/layout.vtl");
  }, new VelocityTemplateEngine());


  get ("/results", (request,response) -> {
    Map<String, Object> model = new HashMap<String,Object>();
    model.put("template", "templates/results.vtl");

    String userInput = request.queryParams("userinput");
    String output = wordPuzzle(userInput);

    model.put("result", output);
    return new ModelAndView(model,layout);
  }, new VelocityTemplateEngine());


  }


  public static String wordPuzzle(String startSentence){

  String [] wordArray = startSentence.split("");
  Integer arrayLength = wordArray.length;
  Integer arrayLengthMin1 = arrayLength - 1;

  HashMap<String, String>  vowels = new HashMap<String, String>();
  vowels.put("a", "vowel");
  vowels.put("e", "vowel");
  vowels.put("i", "vowel");
  vowels.put("o", "vowel");
  vowels.put("u", "vowel");
  vowels.put("A", "vowel");
  vowels.put("E", "vowel");
  vowels.put("I", "vowel");
  vowels.put("O", "vowel");
  vowels.put("U", "vowel");
  vowels.put("y", "y");
  vowels.put("Y", "y");
  vowels.put(" ", "end");
  vowels.put("!", "end");
  vowels.put(".", "end");
  vowels.put("?", "end");
  vowels.put(":", "end");
  vowels.put(";", "end");
  vowels.put("/", "end");
  vowels.put("'", "end");
  String resultSentence = "";

  for (int i=0; i<arrayLength; i++){
    String letter = wordArray[i];

      if(vowels.get(letter) == "vowel"){
        letter = "-";
      } else if( i < arrayLengthMin1){
        if(vowels.get(letter) == "y" && vowels.get(wordArray[i+1]) =="end"){
          letter = "-";
        }
      }

      if (i == arrayLengthMin1){
        if (vowels.get(letter) == "y"){
          letter = "-";
        }
      }
    resultSentence = resultSentence + letter;
   }

  return resultSentence;



 }


}
