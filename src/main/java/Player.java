import java.util.Scanner;

public class Player {
  public int[] enterGuessingNumber() {
    Scanner prompt = new Scanner(System.in);
    System.out.print("숫자를 입력해주세요 : ");
    int playerInput = prompt.nextInt();
    int[] guessingNumber = splitNumberIntoDigits(playerInput);
    return guessingNumber;
  }

  private int[] splitNumberIntoDigits(int guessingNumber) {
    int[] digits = new int[3];
    int i = 0;
    int divider = 100;
    while (guessingNumber > 0) {
      digits[i] = guessingNumber / divider;
      guessingNumber = guessingNumber % divider;
      divider /= 10;
      i++;
    }
    return digits;
  }
}
