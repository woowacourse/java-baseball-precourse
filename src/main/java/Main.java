import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int restart = 1;
        // restart=1 실행

        BaseBall baseBall = new BaseBall();
        baseBall.createNumber();

        while (restart == 1) {
            //스트라이크와 볼의 수를 초기화
            baseBall.init();

            //사용자의 숫자입력
            System.out.println("숫자를 입력하세요: ");
            String line = sc.nextLine();

            //입력값의 예외처리
            if (isException(line)) {
                continue;
            }

            int[] user = new int[3];

            for (int i = 0; i < user.length; i++) {
                user[i] = line.charAt(i) - '0';
            }

            //컴퓨터의 수와 사용자의 수를 비교
            baseBall.compareNumbers(user);
            System.out.println(baseBall);

            if (baseBall.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요");
                restart = Integer.parseInt(sc.nextLine());
                baseBall = new BaseBall();
                baseBall.createNumber();
            }
        }
    }

    /**
     * 사용자가 3자리의 숫자만을 입력했는지 확인하는 함수
     *
     * @param line 사용자가 입력한 값
     * @return 예외가 맞는지 아닌지 판단하는 boolean
     * 예외가 맞으면 true 아니면 false를 반환
     */
    public static boolean isException(String line) {
        try {
            int number = Integer.parseInt(line);//숫자가 아닌 문자를 입력했는지 확인
            if (line.length() != 3) {   //숫자를 3개입력했는지 확인
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("숫자 3자리를 다시 입력해주세요:");
            return true;
        }
        return false;
    }
}
