import java.util.Scanner;

public class IOController {

  private Scanner sc = new Scanner(System.in);

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
