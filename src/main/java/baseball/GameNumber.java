package baseball;

import utils.RandomUtils;

public class GameNumber {
   private static final int NUMBER_OF_DIGIT=3;
   private static final int RANGE_MIN=1;
   private static final int RANGE_MAX=9;
   
   public static String generateGameNumber() {
      String gameNumber="";
      while(gameNumber.length()<NUMBER_OF_DIGIT) {
         int digit=RandomUtils.nextInt(RANGE_MIN, RANGE_MAX);
         if(!gameNumber.contains(Integer.toString(digit))) gameNumber+=digit;
      }
      return gameNumber;
   }
   
}