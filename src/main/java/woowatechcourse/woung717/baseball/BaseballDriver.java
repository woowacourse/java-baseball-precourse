/*
 * BaseballDriver class
 *
 * v0.1
 *
 * 2019.03.25
 *
 * Copyrights
 */

package woowatechcourse.woung717.baseball;

import java.util.Scanner;

public class BaseballDriver {
    private static boolean isValid(String s) {
        StringBuilder newString = new StringBuilder();

        s.chars().distinct().forEach(c -> newString.append((char) c));

        return s.length() == newString.toString().length() && s.matches("^[1-9]{3}$");
    }

    private static void gameStart() {
        final int STRIKE_SCORE = 3;
        Baseball game = new Baseball(new BaseballAnswer());
        Scanner scan = new Scanner(System.in);

        while (true) {
            // System.out.print(game.answer);
            System.out.println("> 숫자를 입력해 주세요: ");
            String query = scan.nextLine();

            if (!isValid(query)) {
                System.out.println("서로 다른 1~9로 구성된 3자리 숫자를 입력해주세요. ");
                continue;
            }

            Baseball.Result turnResult = game.getResponse(query);

            System.out.println(turnResult.getMessage());

            if (turnResult.getnStrikes() == STRIKE_SCORE) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static void main(String[] args) {
        final int EXIT = 2;
        Scanner scan = new Scanner(System.in);

        do {
            gameStart();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (Integer.parseInt(scan.nextLine()) != EXIT);
    }
}
