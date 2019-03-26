
import java.util.ArrayList;
import java.util.Scanner;

// 19-03-26 2차 리팩토링
public class Main {
//    /**
//     * 게임을 시작하기 위해 1부터 9까지의 중복되지 않는 임의의 숫자 세개를 반환하는 메서드
//     * @return result 1부터 9까지의 중복되지 않는 임의의 숫자 세개 담은 배열
//     */
//    private static int[] gameInit() {
//        ArrayList<Integer> tmpResult = new ArrayList<>();
//        while (tmpResult.size() < 3) {
//            int tmp = (int) (Math.random() * 9 + 1);
//            // !!--indent depth 3 이상--!!
//            if (!tmpResult.contains(tmp)) {
//                tmpResult.add(tmp);
//            }
//        }
//
//        int[] result = new int[3];
//        for (int i = 0; i < tmpResult.size(); i++) {
//            result[i] = tmpResult.get(i);
//        }
//        return result;
//    }
//
//    /**
//     * 사용자의 숫자 3개 입력을 받는 메서드
//     * 문자열로 입력을 받아 int 로 형변환하는 과정을 거친다.
//     * @return result 사용자가 입력한 숫자 3개를 담고 있는 int 형 배열
//     */
//    private static int[] getUserInput() {
//        int[] result = new int[3];
//        Scanner sc = new Scanner(System.in);
//        System.out.print("숫자를 입력해주세요: ");
//        String[] userInput = sc.next().split("");
//        for (int i = 0; i < result.length; i++) {
//            result[i] = Integer.parseInt(userInput[i]);
//        }
//        return result;
//    }
//
//    /**
//     * 파라미터 배열 두개를 비교하여 위치와 숫자 모두 같은 스트라이크의 개수를
//     * 카운트하여 결과로 반환하는 메서드
//     * @param com computer 가 생성한 배열, 기준이 되는 배열
//     * @param user user 입력으로 생성된 배열
//     * @return 스트라이크의 개수
//     */
//    private static int countStrike(int[] com, int[] user) {
//        int result = 0;
//
//        // 스트라이크 체크
//        for (int i = 0; i < user.length; i++) {
//            // !!--indent depth 3 이상--!!
//            if (com[i] == user[i]) {
//                result++;
//            }
//        }
//
//        return result;
//    }
//
//    /**
//     * 파라미터 배열 두개를 비교하여 위치가 같지 않고 숫자만 같은 볼의 개수를
//     * 카운트하여 결과로 반환하는 메서드
//     * @param com computer 가 생성한 배열, 기준이 되는 배열
//     * @param user user 입력으로 생성된 배열
//     * @return 볼의 개수
//     */
//    private static int countBall(int[] com, int[] user) {
//        int result = 0;
//        // 볼 체크
//        for (int i = 0; i < com.length; i++) {
//            // !!--indent depth 3 이상--!!
//            for (int j = 0; j < user.length; j++) {
//                if (i != j && com[i] == user[j]) {
//                    result++;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    /**
//     * 매개변수로 전달 받은 strike 와 ball 로 결과를 콘솔에 출력하는 메서드
//     * @param strike count 된 strike 의 개수
//     * @param ball count 된 ball 의 개수
//     */
//    private static void printGameResult(int strike, int ball) {
//        if (strike == 0 && ball == 0) {
//            System.out.println("포볼");
//        }
//        else if (strike == 0) {
//            System.out.printf("%d 볼\n", ball);
//        }
//        else if (ball == 0) {
//            System.out.printf("%d 스트라이크\n", strike);
//        }
//        else {
//            System.out.printf("%d 스트라이크 %d 볼\n", strike, ball);
//        }
//    }
//
//    /**
//     * 스트라이크가 3으로 게임이 끝나는지 아닌지를 반환해주는 메서드
//     * @param strike 스트라이크 수
//     * @return 게임이 끝나면 true, 게임이 끝나지 않으면 false
//     */
//    private static boolean isGameEnd(int strike) {
//        if (strike == 3) {
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 게임의 본체 메서드, 이 메서드가 실행되면 게임이 1회 실행된다.
//     * @param com 컴퓨터가 생성한 임의의 중복되지 않는 3개의 숫자를 담는 배열
//     * @return 게임이 끝나면 true 를 반환
//     */
//    private static boolean gameStart(int[] com) {
//        boolean isAllStrike = false;
//        while (!isAllStrike) {
//            int[] user = getUserInput();
//
////            // user 확인용
////            System.out.print("USER 배열 : ");
////            for (int i : user)
////                System.out.print(i + " ");
////            System.out.println();
////
////            // user 확인용
////            System.out.print("COM 배열 : ");
////            for (int i : com)
////                System.out.print(i + " ");
////            System.out.println();
//            int strike = countStrike(com, user);
//            int ball = countBall(com, user);
//            printGameResult(strike, ball);
//            isAllStrike = isGameEnd(strike);
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay gamePlay = new GamePlay();

        boolean flag = true;
        while (true) {
            if (flag) {
                gamePlay.init();
                flag = false;
            }
            gamePlay.requestInputMessage();
            String[] userInput = sc.nextLine().split("");
            gamePlay.getUserInput(userInput);
            gamePlay.countResult();
            gamePlay.printGameResult();
            if (gamePlay.isGameEnd()) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int input = sc.nextInt();
                if (input == 2) {
                    break;
                } else {
                    flag = true;
                }
            } else {
                gamePlay.initGameResult();
            }
        }
    }
}
