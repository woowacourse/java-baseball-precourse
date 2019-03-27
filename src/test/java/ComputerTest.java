public class ComputerTest {
  public static void main(String[] args) {
    Computer counterpart = new Computer();
    int[] selectedNumber = counterpart.selectRandomNumber();

    ComputerTest.testNumberIsThreeDigitNumber(selectedNumber);
    ComputerTest.testAllDigitIsInRange(selectedNumber);
    ComputerTest.testHasRepeatedNumber(counterpart);
    ComputerTest.testAllDigitIsDifferent(counterpart, selectedNumber);
  }

  private static void testNumberIsThreeDigitNumber(int[] selectedNumber) {
    assert (selectedNumber.length == 3);
  }

  private static void testAllDigitIsInRange(int[] selectedNumber) {
    for (int i = 0; i < selectedNumber.length; i++) {
      assert (selectedNumber[i] > 0 && selectedNumber[i] <= 9);
    }
  }

  private static void testHasRepeatedNumber(Computer counterpart) {
    int [][] testCases = {
        {1, 1, 3}, {1, 1, 1}, {4, 5, 5}, {1, 2, 2}, {3, 3, 2}
    };
    for (int i = 0; i < testCases.length; i++) {
      assert(counterpart.hasRepeatedNumber(testCases[i]));
    }
  }

  private static void testAllDigitIsDifferent(Computer counterpart,
                                              int[] selectedNumber) {
    assert (!counterpart.hasRepeatedNumber(selectedNumber));
  }
}
