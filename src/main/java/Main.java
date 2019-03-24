import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 정답 생성
        ArrayList<Integer> ans = makeAnswer();

        boolean isContinued = true;
        do {
            int result = playGame(sc);

            // 정답일 때
            if (result == 0) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                isContinued = (sc.nextInt() == 1);
            }

        } while(isContinued);

    }

}

