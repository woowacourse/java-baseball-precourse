public class NumberBaseball {

  private int strikeCount = 0;
  private int ballCount = 0;

  public static void main(String[] args) {
    Computer counterpart = new Computer();
    Player user = new Player();
    NumberBaseball baseballGame = new NumberBaseball();

    baseballGame.playGame(counterpart, user);
  }

  private void playGame(Computer counterpart, Player user) {
    int[] selectedNumber = counterpart.selectRandomNumber();
    while (true) {
      int[] guessingNumber = user.enterGuessingNumber();
      if (isSame(selectedNumber, guessingNumber)) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        break;
      }
      Score gameScore = this.judgePlayerGuess(selectedNumber, guessingNumber);
      this.displayGameResult(gameScore);
      this.initializeGameScore();
    }
  }

  private boolean isSame(int[] selectedNumber, int[] guessingNumber) {
    for (int i = 0; i < selectedNumber.length; i++) {
      if (selectedNumber[i] != guessingNumber[i]) {
        return false;
      }
    }
    return true;
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

  private void displayGameResult(Score gamescore) {
    int strike = gamescore.getStrike();
    int ball = gamescore.getBall();
    if (strike == 0 && ball == 0) {
      System.out.println("낫싱");
      return;
    }
    if (strike > 0) {
      System.out.print(strike + " 스트라이크 ");
    }
    if (ball > 0) {
      System.out.print(ball + " 볼");
    }
    System.out.println();
  }
}
