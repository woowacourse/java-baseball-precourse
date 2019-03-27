public class NumberBaseball {

  private int strikeCount = 0;
  private int ballCount = 0;

  public static void main(String[] args) {
    Computer counterpart = new Computer();
    int[] selectedNumber = counterpart.selectRandomNumber();

    Player user = new Player();
    int[] guessingNumber = user.enterGuessingNumber();

    NumberBaseball baseballGame = new NumberBaseball();
    baseballGame.judgePlayerGuess(selectedNumber, guessingNumber);
  }

  public Score judgePlayerGuess(int[] selectedNumber, int[] guessingNumber) {
    for (int digit = 0; digit < guessingNumber.length; digit++) {
      getScoreByEachDigit(selectedNumber, digit, guessingNumber[digit]);
    }
    Score gameScore = new Score(strikeCount, ballCount);
    return gameScore;
  }

  public void getScoreByEachDigit(int[] selectedNumber, int digit, int value) {
    for (int i = 0; i < selectedNumber.length; i++) {
      if ((value == selectedNumber[i]) && (digit == i)) {
        strikeCount += 1;
      }
      if ((value == selectedNumber[i]) && (digit != i)) {
        ballCount += 1;
      }
    }
  }

  public void initializeGameScore() {
    strikeCount = 0;
    ballCount = 0;
  }
}
