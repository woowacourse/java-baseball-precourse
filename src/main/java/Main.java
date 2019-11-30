/**
 * Main.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        baseball.init();
        while (askRetry()) {
            baseball.init();
        }
    }

    private static boolean askRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        int decision = sc.nextInt();
        if (decision == 1) {
            return true;
        }
        return false;
    }
}
