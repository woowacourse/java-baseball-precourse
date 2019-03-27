public class NumberBaseballTest {
  public static void main(String[] args) {
    NumberBaseball baseballGame = new NumberBaseball();
    NumberBaseballTest.testJudgePlayerGuess(baseballGame);
  }

  private static void testJudgePlayerGuess(NumberBaseball baseballGame) {
    int [][] selectedNumber = {
        {1, 2, 3}, {4, 7, 2}, {3, 4, 5}, {1, 2, 5}, {3, 4, 7}
    };
    int [][] guessingNumber = {
        {1, 2, 3}, {4, 2, 7}, {4, 6, 5}, {1, 2, 3}, {3, 7, 4}
    };
    int [][] label = {
        {3, 0}, {1, 2}, {1, 1}, {2, 0}, {1, 2}
    };

    for (int i = 0; i < selectedNumber.length; i++) {
      Score score = baseballGame.judgePlayerGuess(selectedNumber[i],
                                                  guessingNumber[i]);
      assert (score.getStrike() == label[i][0] && score.getBall() == label[i][1]);
      baseballGame.initializeGameScore();
    }
  }
}
