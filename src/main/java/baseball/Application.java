/*
 * Application.java    2020/11/26
 *
 * Version 1.0
 *
 * Final commit on 2020/11/26
 *
 * woowacourse/java-baseball-precourse
 * Applicant Jo Yeong Sang (PapimonLikelion)
 * All rights reserved.
 */

package baseball;

import utils.RandomUtils;

import java.util.Random;
import java.util.Scanner;


public class Application {
    public static final String RESTART = "1";
    public static final String TERMINATE = "2";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean gaming = true;

        while(gaming) {
            SingleGame.play(scanner);
            gaming = restartOrTerminate(scanner);
        }

        scanner.close();
    }


    /**
     * 메서드 restartOrTerminate()는 한 게임이 종료된 뒤, 게임을 재시작 할지 완전히 종료할 지를 판별합ㄴ다
     * @param gamingStatus 한 게임이 종료한 뒤, 플레이어가 게임 재시작 여부를 입력합니다.
     * @return gamingStatus가 1이면 true, 2이면 false를 반환합니다.
     * @exception gamingStatus가 1 또는 2가 아니라면 IllegalArgumentException 발생시킵니다.
     */
    public static boolean restartOrTerminate(Scanner scanner) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        /* gamingStatus로 플레이어의 게임 재시작 여부를 판별한다 */
        String gamingStatus = scanner.nextLine();
        if (gamingStatus.equals(RESTART)) {
            return true;
        } else if (gamingStatus.equals(TERMINATE)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
