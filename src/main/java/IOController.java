import java.util.Scanner;

public class IOController {

  private int reInputNumber() {
    System.out.println("1 ~ 9까지의 중복되지 않는 숫자 세 자리를 입력 해주세요.");
    return getNumberOfUser();
  }


  public int getNumberOfUser() {
    Scanner sc = new Scanner(System.in);
    System.out.print("숫자를 입력해주세요.");

    try {
      int inputNumber = sc.nextInt();

      if (!validInput(inputNumber)) {
        return reInputNumber();
      }

      return inputNumber;

    } catch (Exception e) {

      return reInputNumber();
    }

  }

  public void printResult(int[] score) {
    String[] SBO = {"스트라이크", "볼", "낫싱"};

    for (int i = 0; i < score.length - 1; i++) {
      if (score[i] == 0) {
        continue;
      }

      System.out.print(score[i] + SBO[i] + " ");
    }

    if (score[2] >= 3) {
      System.out.print(SBO[2]);
    }

    System.out.print("\n");
  }

  public boolean selectNextAction() {
    Scanner sc = new Scanner(System.in);

    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    try {
      int input = sc.nextInt();

      if (input == 1) {
        return true;
      }

      if (input == 2) {
        return false;
      }

      return selectNextAction();

    } catch (Exception e) {
      return selectNextAction();
    }

  }

}
