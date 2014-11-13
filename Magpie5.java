//Connor Lee Computer Science
public class Magpie5
  
{
  /**
   * Get a default greeting  
   * @return a greeting
   */
  public String getGreeting()
  {
    return "Hello, let's talk.";
  }
  
  public String getResponse(String statement)
  {
    
    String response = "";
    if (statement.trim().length() <= 0)
    {
      response = "Cmon don't be scared, type something!";
    }
    
    else if (findKeyword (statement, "is", 0) >= 0) // Testing for "is" rule
    {
      int psn = findKeyword ( statement, "is", 0);//psn is "is"
      String restOfStatement = statement.substring(psn + 3).trim(); // String restOfStatement is everything after "is"
      String begginingOfStatement = statement.substring(0, psn);// String begginingOfStatement is everything before "is"
      response = "Why is " + begginingOfStatement + restOfStatement + "?";// asks "why is" "begginingOfStatement" "restOfStatement" 
      // if the user uses "is", he is describing a singular object. Therefore I make it ask "Why is (the single object) (the description)?
    }
    
    else if (findKeyword (statement, "am", 0) >= 0) // Testing for "am" rule
    {
      int psn = findKeyword ( statement, "am", 0);//psn is "am"
      String restOfStatement = statement.substring(psn + 3).trim();//String restOfStatement is everything after "am"
      response = "Why are you " + restOfStatement + "?";//Asks "why are you" because if the user uses "am", he is describing himself/herself
      // "Why are you (description of person's self)?"
    }
      
    else if (findKeyword (statement, "are", 0) >= 0) // Testing for "are" rule
    {
      int psn = findKeyword ( statement, "are", 0);//psn is "are"
      String restOfStatement = statement.substring(psn + 4).trim();//String restOfStatement is everything after "are"
      response = "Why are they " + restOfStatement + "?";//Asks "why are they" because if the user uses "are", he is talking about multiple people, or a group
      // "Why are they (description of group)?"
    }
    
        else if (findKeyword (statement, "will", 0) >= 0) // Testing for "will" rule
    {
      int psn = findKeyword ( statement, "will", 0);//psn is "will"
      String restOfStatement = statement.substring(psn + 5).trim(); // String restOfStatement is everything after "will"
      String begginingOfStatement = statement.substring(0, psn);// String begginingOfStatement is everything before "will" asks "why will" "begginingOfStatement" "restOfStatement" 
      if (begginingOfStatement.equals("I ")) 
      {
        begginingOfStatement = begginingOfStatement.replace("I ", "you ");// Did this to replace "I" with "you" in case the user says "I will" instead of a "group of people" will, in which the computer would usually expect to respond to
      }
      response = "Why will " + begginingOfStatement + restOfStatement + "?";
      // if the user uses "will", he could be talking about either himself or someone else, which is why I use the begginingOfStatement string.
      //Therefore I make it ask "Why will (person or people) (action)?
    }
       
        else if (findKeyword (statement, "I", 0) >= 0) // Testing for "I" rule
        {
          int psn = findKeyword (statement, "I", 0);//psn is "I"
          String restOfStatement = statement.substring(psn + 2).trim();
          String pastResponse = "Why did you ";//String restOfStatement is everything after "I"
          if (findKeyword (statement, "ed ", 0) >=0);//Looked for "ed " instead of "ed" because if it was just "ed", it would be inside of a word.
          //Did this to address if the user types in a past tense verb. (certain verbs)
          {
            response = pastResponse + restOfStatement + "?";
          }
          {
        response = "Why do you " + restOfStatement + "?";
      }//Asks "why do you" because if the user uses "I", he is talking about an action or description of himself/herself
      // "Why do you (action/description described by person)?"
    }
    
    else if (findKeyword(statement,"no") >= 0)
    {
      response = "Why so negative?";//If user says "no" to wanting to talk
    }
    else if (findKeyword(statement,"mother") >= 0//Addressing the response if the user types in "mother", "father", "sister", or "brother"
               || findKeyword(statement,"father") >= 0
               || findKeyword(statement,"sister") >= 0
               || findKeyword(statement,"brother") >= 0)
    {
      response = "Tell me more about your family.";
    }
    
    else if (findKeyword(statement,"superman") >= 0)//If the user mentions "superman"
    {
      response = "Batman could kick his ass.";
    }
    
    else if (findKeyword(statement,"ebola") >= 0)//If the user mentions "ebola"
    {
      response = "Ebola scares me.";
    }
    
    else if (findKeyword(statement,"minecraft") >= 0)//If the user mentions "minecraft"
    {
      response = "I love that game.";
    }
    
    else if (findKeyword(statement,"dog") >= 0 //Respose if the user mentions "dog", "cat", "fish", "bird"
               || findKeyword(statement,"cat") >= 0
               || findKeyword(statement,"fish") >= 0
               || findKeyword(statement,"bird") >= 0)
    {
      response = "Tell me more about your pets.";
    }
    
    else if (findKeyword(statement, "want", 0) >= 0)  
    {
      response = transformIWantStatement(statement);//For if the user types an "I want" statement
    }
    
    else if (findKeyword(statement, "You") >= 0 //For if the user types in an "I (description) you" statement
               && findKeyword(statement, "I") >=0)  
    {
      response = transformYouMeStatement(statement);
    }
    
    else if (statement.indexOf("landgraf") >= 0//For if the user mentions Mr. Kiang or Mr. Landgraf
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
    int psn = findKeyword (statement, "I want", 0);//if user says I want "object", it responds "would you be happy if you had (object)?"
    String restOfStatement = statement.substring(psn + 6).trim();
    return "Would you be happy if you had " + restOfStatement + "?";
  }
  
  
  //If the statement has "are" in it, and does not contan "you", move the are to the front and put why in front of it
  //if the statement has "is" in it, Move the is to the front and put why in front of it. 
  
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
    return "Why do you " + restOfStatement + " me?";//If user types something he/her thinks about the computer, the computer asks
    //"Why do you (description) "me?"
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
  
  
  
  private String getRandomResponse()
  {
    final int NUMBER_OF_RESPONSES = 6;//if the user types in something not specified with the above, the computer responds
    //with one of these 6 random responses
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

