import java.util.*;

public class Baseball {
  private static boolean toContinue() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    boolean cont = true;
    if (num != 1) {
      cont = false;
    }
    return cont;
  }

  public static void main(String args[]) {
    boolean cont = true;
    while (cont) {
      BaseBallGame game = new BaseBallGame();
      game.play();
      cont = toContinue();
    }
  }
}
