import java.util.Scanner;

// 먼저 기능만 같도록 스파게티 코드로 작성
public class Main {
    private static int[] com = new int[3];
    public static void main(String[] args) {
        // 최초로 컴퓨터가 중복되지 않는 임의의 수 3개 생성
        for (int i = 0; i < com.length; i++) {
            com[i] = (int) (Math.random() * 9 + 1);

            for (int j = 0; j < i; j++)
                if (com[j] == com[i]) {
                    i--;
                    break;
                }
        }

        boolean go = true;
        while (go) {
            int[] user = new int[3];
            Scanner sc = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요: ");
            String[] input = sc.next().split("");
            for (int i = 0; i < user.length; i++) {
                user[i] = Integer.parseInt(input[i]);
            }

            // user 확인용
            System.out.print("USER 배열 : ");
            for (int i : user)
                System.out.print(i + " ");
            System.out.println();

            // user 확인용
            System.out.print("COM 배열 : ");
            for (int i : com)
                System.out.print(i + " ");
            System.out.println();


            // 스트라이크는 위치랑 숫자가 동일한 것
            // 볼은 위치는 다르고 숫자가 둘다 포함
            int strike = 0;
            int ball = 0;

            // 스트라이크 체크
            for (int i = 0; i < user.length; i++) {
                if (com[i] == user[i])
                    strike++;
            }

            // 볼 체크
            for (int i = 0; i < com.length; i++) {
                for (int j = 0; j < user.length; j++) {
                    if (i != j && com[i] == user[j])
                        ball++;
                }
            }

            if (strike == 0 && ball == 0)
                System.out.println("포볼");
            else if (strike == 0)
                System.out.printf("%d 볼\n", ball);
            else if (ball == 0)
                System.out.printf("%d 스트라이크\n", strike);
            else
                System.out.printf("%d 스트라이크 %d 볼\n", strike, ball);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다!게임 종료");
                go = false;
            }
        }
    }
}
