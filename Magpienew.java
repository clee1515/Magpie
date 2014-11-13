 /* A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *       Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 */ 
public class Magpienew
  
{
  /**
   * Get a default greeting  
   * @return a greeting
   */
  public String getGreeting()
  {
    return "Hello, let's talk.";
  }
     private String transformIWantStatement(String statement)
  {
    //  Remove the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
                                            .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
                                        .length() - 1);
    }
    int psn = findKeyword (statement, "I want", 0);
    String restOfStatement = statement.substring(psn + 6).trim();
    return "Would you be happy if you had " + restOfStatement + "?";
  }
  
  //If the statement has "are" in it, and does not contan "you", move the are to the front and put why in front of it
     //if the statement has "is" in it, Move the is to the front and put why in front of it. 
  /**
   * Take a statement with "you <something> me" and transform it into 
   * "What makes you think that I <something> you?"
   * @param statement the user statement, assumed to contain "you" followed by "me"
   * @return the transformed statement
   */
  private String transformYouMeStatement(String statement)
  {
    //  Remove the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
                                            .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
                                        .length() - 1);
    }
    
    int psnOfYou = findKeyword (statement, "I", 0);
    int psnOfMe = findKeyword (statement, "you", psnOfYou + 1);
    
    String restOfStatement = statement.substring(psnOfYou + 1, psnOfMe).trim();
    return "Why do you " + restOfStatement + " me?";
  }
  
  private int findKeyword(String statement, String goal,
                          int startPos)
  {
    String phrase = statement.trim();
    // The only change to incorporate the startPos is in
    // the line below
    int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
    
    // Refinement--make sure the goal isn't part of a
    // word
    while (psn >= 0)
    {
      // Find the string of length 1 before and after
      // the word
      String before = " ", after = " ";
      if (psn > 0)
      {
        before = phrase.substring(psn - 1, psn)
          .toLowerCase();
      }
      if (psn + goal.length() < phrase.length())
      {
        after = phrase.substring(
                                 psn + goal.length(),
                                 psn + goal.length() + 1)
          .toLowerCase();
      }
      
      // If before and after aren't letters, we've
      // found the word
      if (((before.compareTo("a") < 0) || (before
                                             .compareTo("z") > 0)) // before is not a
            // letter
            && ((after.compareTo("a") < 0) || (after
                                                 .compareTo("z") > 0)))
      {
        return psn;
      }
      
      // The last position didn't work, so let's find
      // the next, if there is one.
      psn = phrase.indexOf(goal.toLowerCase(),
                           psn + 1);
      
    }
    
    return -1;
  }
  
  /**
   * Search for one word in phrase. The search is not case
   * sensitive. This method will check that the given goal
   * is not a substring of a longer string (so, for
   * example, "I know" does not contain "no"). The search
   * begins at the beginning of the string.
   * 
   * @param statement
   *            the string to search
   * @param goal
   *            the string to search for
   * @return the index of the first occurrence of goal in
   *         statement or -1 if it's not found
   */
  private int findKeyword(String statement, String goal)
  {
    return findKeyword(statement, goal, 0);
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
    
    else if (findKeyword(statement,"no") >= 0)
    {
      response = "Why so negative?";
    }
    else if (findKeyword(statement,"mother") >= 0
               || findKeyword(statement,"father") >= 0
               || findKeyword(statement,"sister") >= 0
               || findKeyword(statement,"brother") >= 0)
    {
      response = "Tell me more about your family.";
    }
    
    else if (findKeyword(statement,"superman") >= 0)
    {
      response = "Batman could kick his ass.";
    }
    
    else if (findKeyword(statement,"ebola") >= 0)
    {
      response = "Ebola scares me.";
    }
    
    else if (findKeyword(statement,"minecraft") >= 0)
    {
      response = "I love that game.";
    }
    
    else if (findKeyword(statement,"dog") >= 0
               || findKeyword(statement,"cat") >= 0
               || findKeyword(statement,"fish") >= 0
               || findKeyword(statement,"bird") >= 0)
    {
      response = "Tell me more about your pets.";
    }
    
        else if (findKeyword(statement, "want", 0) >= 0)  
    {
      response = transformIWantStatement(statement);
    }
         
         else if (findKeyword(statement, "I", 0) >= 0)  
    {
      response = transformYouMeStatement(statement);
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

