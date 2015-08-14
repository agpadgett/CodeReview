//import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class WordPuzzleApp {
  public static void main(String[] args){

  staticFileLocation("/public");
  String layout = "templates/layout.vtl"; /*locate layout file */

  get("/", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/form.vtl");
    return new ModelAndView(model, "templates/layout.vtl");
  }, new VelocityTemplateEngine());


  get ("/results", (request,response) -> {
    Map<String, Object> model = new HashMap<String,Object>();
    model.put("template", "templates/results.vtl");

    String userInput = request.queryParams("userinput"); /*grabs whatever you typed in as $userinput*/

    String output = wordPuzzle(userInput);

    model.put("result", output); /*sticks your calculated output where it says "$result" on the /results page*/
    return new ModelAndView(model,layout);
  }, new VelocityTemplateEngine());


  }


  public static String wordPuzzle(String startSentence){

  String [] startSentenceArray = startSentence.split("");
  Integer arrayLength = startSentenceArray.length;
  Integer arrayLengthMin1 = arrayLength - 1;

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
  vowels.put("y", "y");
  vowels.put("Y", "y");
  String resultSentence = "";

  for (int i=0; i<arrayLength; i++){
   String letter = startSentenceArray[i];
     if(vowels.get(letter) == "-"){
       letter = "-";
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
