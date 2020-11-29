package baseball;

import java.util.Scanner;

public class Restart {

    private static final String RESTART = "1";
    private static final String TERMINATE = "2";

    /**
     * 메서드 restartOrTerminate()는 한 게임이 종료된 뒤, 게임을 재시작 할지 완전히 종료할 지를 판별
     * @return true 플레이어가 1을 입력할 경우
     * @return false 플레이어가 2를 입력할 경우
     * @exception 1 또는 2가 아니라면 IllegalArgumentException 발생
     */
    public static boolean restartOrTerminate(Scanner scanner) {
        String gamingStatus = restartUserInput(scanner);
        if (gamingStatus.equals(RESTART)) {
            return true;
        } else if (gamingStatus.equals(TERMINATE)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static String restartUserInput(Scanner scanner) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        /* gamingStatus 로 플레이어의 게임 재시작 여부를 판별한다 */
        String gamingStatus = scanner.nextLine();
        return gamingStatus;
    }

}
