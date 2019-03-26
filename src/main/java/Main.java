
import java.util.ArrayList;
import java.util.Scanner;

// 19-03-26 리팩토링
public class Main {
    /**
     * 게임을 시작하기 위해 1부터 9까지의 중복되지 않는 임의의 숫자 세개를 반환하는 메서드
     * @return result 1부터 9까지의 중복되지 않는 임의의 숫자 세개 담은 배열
     */
    private static int[] gameInit() {
        ArrayList<Integer> tmpResult = new ArrayList<>();
        while (tmpResult.size() < 3) {
            int tmp = (int) (Math.random() * 9 + 1);
            if (!tmpResult.contains(tmp))
                tmpResult.add(tmp);
        }

        int[] result = new int[3];
        for (int i = 0; i < tmpResult.size(); i++) {
            result[i] = tmpResult.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // 최초로 컴퓨터가 중복되지 않는 임의의 수 3개 생성
        int[] com = gameInit();

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
