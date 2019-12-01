/*
 * Main
 * 2019.11.30
 */

import com.woowahan.baseball.Baseball;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        String input;

        while (true) {
            baseball.Run();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = baseball.getLine();
            input = input.trim();

            if (input == "1") {
                continue;
            }
            if (input == "2"){
                break;
            }
        }
    }
}
