package baseball;

public class Application {
   //  private static int SIZE = 3;
   //  private static int MIN = 1;
   //  private static int MAX = 9;
   //
   //  // 게임 종료 혹은 재시작 입력받는 메서드
   //  public static boolean willExit() {
   //
   //  }
   //
   // // 결과를 출력하는 메서드
   //  public static void printResult(int[] result) {
   //
   //  }
   //
   //  // 볼, 스트라이크, 낫싱의 개수 카운트하는 메서드
   //  public static int[] countResult(int[] computer, int[] user) {
   //
   //  }
   //
   //  // 사용자에게서 입력받고 예외처리하는 메서드
   //  public static int[] setUserInput() {
   //      System.out.println("숫자를 입력해주세요 : ");
   //      char input[] = camp.nextstep.edu.missionutils.Console.readLine().toCharArray();
   //
   //      // 숫자 개수가 맞지 않는 경우 exception 발생
   //      if (input.length != SIZE) {
   //          throw new IllegalArgumentException("IllegalArgumentException");
   //      }
   //      // 숫자가 아닌 값을 입력한 경우 exception 발생
   //      for(int i = 0; i < SIZE; i++) {
   //          if (!Character.isDigit(input[i])) {
   //              throw new IllegalArgumentException("IllegalArgumentException");
   //          }
   //      }
   //
   //      int[] user = new int[SIZE];
   //      for (int i = 0; i < SIZE; i++) {
   //          user[i] = Character.getNumericValue(input[i]);
   //      }
   //
   //      return user;
   //  }
   //
   //  // 중복되지 않는 랜덤 숫자 3개 설정하는 메서드
   //  public static int[] setRandomNumber() {
   //      int current = 3;
   //      int[] computer = new int[SIZE];
   //      while (current > 0) {
   //          int selected = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
   //          // 중복된 값이 없다면
   //          if (!Arrays.asList(computer).contains(selected)) {
   //              computer[3 - current] = selected;
   //              current--;
   //          }
   //      }
   //      return computer;
   //  }

    public static void main(String[] args) {
        Game game = new Game();

        while (true) {
            game.setComputerNumber();
            int result = game.startGame();

            if (result == 2) {
                break;
            }
        }

    }
}
