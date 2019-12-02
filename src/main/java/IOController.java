import java.util.Scanner;

public class IOController {

  private Scanner sc = new Scanner(System.in);

  public boolean selectNextAction() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    int input = sc.nextInt();

    if (input == 1) {
      return true;
    }

    if (input == 2) {
      return false;
    }

    return selectNextAction();
  }

}
