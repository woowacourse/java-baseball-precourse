/*
 * @(#)Main.java        2019-12-01
 *
 * [저작권 및 라이센스 관련 정보를 여기에 작성한다.]
 */

import java.util.Scanner;

/**
 * @version         1.01 2019-12-01
 * @author          최근휘
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Baseball baseball = new Baseball();
        String input;

        System.out.println("숫자를 입력해주세요: ");
        input = scanner.next();
        baseball.setPlayersNum(input);
        System.out.println("입력한 숫자: " + baseball.getPlayersNums());
        for (int i = 0; i < 10; i++) {
            baseball.setComputersNum();
            System.out.println("컴퓨터의 숫자: " + baseball.getComputersNums());
        }
    }
}
