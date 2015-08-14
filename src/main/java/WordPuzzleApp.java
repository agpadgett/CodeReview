//import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class WordPuzzleApp {
  public static void main(String[] args){
    //
    // /* Basic Spark Stuff */
    //
    // staticFileLocation("/public");
    // String layout = "templates/layout.vtl"; /*locate layout file */
    //
    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/form.vtl");
    //   return new ModelAndView(model, "templates/layout.vtl");
    // }, new VelocityTemplateEngine()); /* Makes homepage "http://localhost:4567/",
    // will search for file in public/templates/form.vtl*/
    //
    // get ("/results", (request,response) -> { /*make a results page */
    //   Map<String, Object> model = new HashMap<String,Object>();
    //   model.put("template", "templates/results.vtl");
    //   String stringOfUserInput = request.queryParams("userinput"); /*grabs whatever you typed in as $userinput*/
    //   Integer userInput = Integer.parseInt(stringOfUserInput); /*turns it into an Integer*/
    //   String output = yourMethod(userInput);
    //   model.put("result", output); /*sticks your calculated output where it says "$result" on the /results page*/
    //   return new ModelAndView(model,layout);
    //   }, new VelocityTemplateEngine());


  }


  public static String wordPuzzle(String startSentence){

  String [] startSentenceArray = startSentence.split("");
  Integer startStentenceLength = startSentence.length();

  HashMap<String, String>  vowels = new HashMap<String, String>();
  vowels.put("a", "-");
  vowels.put("e", "-");
  vowels.put("i", "-");
  vowels.put("o", "-");
  vowels.put("u", "-");
  vowels.put("A", "-");
  vowels.put("E", "-");
  vowels.put("I", "-");
  vowels.put("O", "-");
  vowels.put("U", "-");
  String resultSentence = "";

  for (int i=0; i<startStentenceLength; i++){
    String letter = startSentenceArray[i];
      if(vowels.get(letter) == "-"){
        letter = "-";
      }
       resultSentence = resultSentence + letter;
   }

  return resultSentence;
}


}
