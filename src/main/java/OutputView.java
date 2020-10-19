import java.util.Scanner;

public class OutputView {
  private static Scanner scanner = new Scanner(System.in);

  public static int getInput() {
    System.out.println("숫자를 입력해주세요");
    return Integer.parseInt(scanner.nextLine());
  }
}
