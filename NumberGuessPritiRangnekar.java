//Priti Rangnekar, APCS
import java.util.Scanner;
import java.lang.Math;

public class NumberGuessPritiRangnekar{
  public static void main(String[] args){
     System.out.println("NUMBER GUESSING GAME. This game will have 2 rounds: 1. You guess the computer's number. 2. The computer guesses your number.");
     comphold();
     userhold();
  }
  
  public static void comphold(){ //computer generates random number for user to guess
    System.out.println("Guess my number.");
    Scanner sc = new Scanner(System.in);
    //computer generates random number as the number it "thought" of
    int ans = (int)(100*Math.random() + 2);
    int guess = sc.nextInt();
    int countusertries = 1; //start with count=1 because the user entered in first guess above
    while (guess!=ans && countusertries<=4){ //user has not guessed correctly
      if (guess > ans){ //if user guesses too high
        System.out.println("Too high! Guess again! You have " + (5-countusertries) + " tries left.");
      }
      else{ //if user guesses too low
        System.out.println("Too low! Guess again! You have " + (5-countusertries) + " tries left.");
      }
      guess = sc.nextInt();
      //increase the count of guesses each time
      countusertries++;
    }
    if (guess == ans){
      System.out.println("You got it right in " + countusertries + " guesses.");
    }
    else {
      System.out.println("You ran out of guesses. My number was: " + ans);
    }
  }
  
   public static void userhold(){ //user thinks of number for computer to guess
    //Scanner, instructions
    Scanner sc = new Scanner(System.in);
    System.out.println("Think of a number between 1 (inclusive) and 100 (exclusive). Type TL if my guess is too low, and TH if my guess is too high. Type Correct when I guess correctly! My first guess is: ");
    //initialization of guess, upperbound, and lowerbound
    int guess = 0;
    int upperbound = 100; //initial high point
    int lowerbound = 0; //initial low point
    //sets up first guess in all cases: 50
    guess = (upperbound-lowerbound)/2;
    System.out.print(guess);
    //while loop for next guesses that lowers interval, and finds average of the current upperbound and currentlowerbound, which are set based on user feedback
    String userinput = "";
    while (!(userinput.equals("Correct"))){ //continue while the guess isn't correct, according to user feedback
     
      userinput = sc.nextLine();
      if (userinput.equals("TL")){
        lowerbound = guess; //since the user's number can't be lower than or equal to this guess, this guess becomes the lowerbound
        guess = (upperbound+lowerbound)/2; //take average of two bounds to split interval in half
        System.out.println(guess); 
      }  
      else if (userinput.equals("TH")){
        upperbound = guess; //since the user's number can't be higher than or equal to this guess, this guess becomes the upperbound
        guess = (upperbound+lowerbound)/2; //take average of two bounds to split interval in half
        System.out.println(guess); 
      }
    }
   
  
  
  
  
   }
  
}