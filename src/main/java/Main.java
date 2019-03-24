import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정답 생성
        StringBuilder ans = makeAnswer();
        System.out.println(ans.toString());

        /*boolean isContinued = true;
        do {
            int result = playGame(sc);

            // 정답일 때
            if (result == 0) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                isContinued = (sc.nextInt() == 1);
            }

        } while(isContinued);*/

    }

    // 정답 생성 함수
    public static StringBuilder makeAnswer() {
        // 이미 사용된 숫자인지 확인
        boolean number[] = new boolean[10];

        StringBuilder answer = new StringBuilder();

        int count = 0;
        while (count < 3) {
            int num = (int) (Math.random() * 10);
            if (num == 0 || number[num-1]) continue;
            else {
                answer.append(num);
                number[num-1] = true;
                count++;
            }
        }

        return answer;
    }

    // 게임 실행
    public static int playGame(Scanner sc) {

        System.out.print("숫자를 입력해주세요 : ");
        String input = sc.nextLine();
        System.out.println();

        return 0;
    }

}

