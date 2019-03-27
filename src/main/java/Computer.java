import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Computer {
  public int[] selectRandomNumber() {
    int[] selectedNumber = new int[3];
    do {
      for (int i = 0; i < selectedNumber.length; i++) {
        Random random = new Random();
        int randomNumber = random.nextInt(9) + 1;
        selectedNumber[i] = randomNumber;
      }
    } while (hasRepeatedNumber(selectedNumber));
    return selectedNumber;
  }

  public boolean hasRepeatedNumber(int[] selectedNumber) {
    Set<Integer> existingNumbers = new HashSet<Integer>();
    for (int digit : selectedNumber) {
      if (!existingNumbers.add(digit)) {
        return true;
      }
    }
    return false;
  }
}
