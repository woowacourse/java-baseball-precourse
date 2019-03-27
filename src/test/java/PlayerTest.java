public class PlayerTest {
  public static void main(String[] args) {
    Player user = new Player();
    int[] guessingNumber = user.enterGuessingNumber();

    PlayerTest.testNumberIsThreeDigitNumber(guessingNumber);
    PlayerTest.testAllDigitIsInRange(guessingNumber);
  }

  private static void testNumberIsThreeDigitNumber(int[] guessingNumber) {
    assert (guessingNumber.length == 3);
  }

  private static void testAllDigitIsInRange(int[] guessingNumber) {
    for (int i = 0; i < guessingNumber.length; i++) {
      assert (guessingNumber[i] > 0 && guessingNumber[i] <= 9);
    }
  }
}
