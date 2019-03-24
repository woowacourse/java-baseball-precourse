import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isContinued;
        do {
            isContinued = false;

            // 정답 생성
            String ans = makeAnswer();
            System.out.println(ans);

            // 게임 시작
            boolean result = playGame(sc, ans);

            // 정답일 때
            if (result) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                isContinued = (sc.nextInt() == 1);
                sc.nextLine();
            }

        } while(isContinued);

    }

    // 정답 생성 함수
    private static String makeAnswer() {
        // 이미 사용된 숫자인지 확인
        boolean[] number = new boolean[10];

        StringBuilder answer = new StringBuilder();

        int count = 0;
        while (count < 3) {
            int num = (int) (Math.random() * 10);
            if (num != 0 && !number[num-1]) {
                answer.append(num);
                number[num-1] = true;
                count++;
            }
        }

        return answer.toString();
    }

    // 게임 실행
    private static boolean playGame(Scanner sc, String ans) {

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = sc.nextLine();
            if (input.length() != 3) {
                System.out.println("입력 오류!");
                return false;
            }

            String result = checkAnswer(ans, input);
            System.out.println(result);

            if (result.equals("3 스트라이크 ")) return true;
        }

    }

    // 대답 검증
    private static String checkAnswer(String ans, String input) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            if (!ans.contains(input.charAt(i) + "")) continue;

            if (ans.charAt(i) == input.charAt(i)) strike++;
            else ball++;
        }

        StringBuilder result = new StringBuilder();
        result.append((strike > 0) ? strike + " 스트라이크 " : "");
        result.append((ball > 0) ? ball + "볼" : "");
        result.append((result.length() == 0) ? "낫싱" : "");

        return result.toString();
    }

}

