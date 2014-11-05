/* A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *       Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 */ 
public class Magpie
{
  /**
   * Get a default greeting  
   * @return a greeting
   */
  public String getGreeting()
  {
    return "Hello, let's talk.";
  }
  
  /**
   * Gives a response to a user statement
   * 
   * @param statement
   *            the user statement
   * @return a response based on the rules given
   */
  public String getResponse(String statement)
  {
    String response = "";
    if (statement.trim().length() <= 0)
    {
      response = "Cmon don't be scared, type something!";
    }
    
    else if (statement.indexOf("no") >= 0)
    {
      response = "Why so negative?";
    }
    else if (statement.indexOf("mother") >= 0
               || statement.indexOf("father") >= 0
               || statement.indexOf("sister") >= 0
               || statement.indexOf("brother") >= 0)
    {
      response = "Tell me more about your family.";
    }
    
     else if (statement.indexOf("superman") >= 0)
    {
      response = "Batman could kick his ass.";
    }
     
     else if (statement.indexOf("ebola") >= 0)
    {
      response = "Ebola scares me.";
    }
    
      else if (statement.indexOf("minecraft") >= 0)
    {
      response = "I love that game.";
    }
      
    else if (statement.indexOf("dog") >= 0
               || statement.indexOf("cat") >= 0
               || statement.indexOf("fish") >= 0
               || statement.indexOf("bird") >= 0)
    {
      response = "Tell me more about your pets.";
    }
    else if (statement.indexOf("landgraf") >= 0
               || statement.indexOf("kiang") >= 0)
    {
      response = "He sounds like an awesome dude.";
    }
             else
               {
               response = getRandomResponse();
             }
             return response;
             }
  private String getRandomResponse()
  {
    final int NUMBER_OF_RESPONSES = 6;
    double r = Math.random();
    int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
    String response = "";
    
    if (whichResponse == 0)
    {
      response = "Interesting, tell me more.";
    }
    else if (whichResponse == 1)
    {
      response = "Hmmm.";
    }
    else if (whichResponse == 2)
    {
      response = "Do you really think so?";
    }
    else if (whichResponse == 3)
    {
      response = "You don't say.";
    }
    else if (whichResponse == 4)
    {
      response = "That's super cool";
    }
    else if (whichResponse == 5)
    {
      response = "That's pretty awesome";
    }
    
    return response;
  }
  }

