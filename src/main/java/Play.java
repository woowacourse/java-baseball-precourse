import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Play {
    List<Integer> answer;
    private int tryTimes;

    // 클래스 생성 시 랜덤으로 3자리 수를 만든다.
    public Play() {
        this.answer = ThreadLocalRandom
                .current()
                .ints(1, 10)
                .distinct()
                .limit(3)
                .boxed().collect(Collectors.toList());
        this.tryTimes = 0;
    }

    // 플레이어로부터 숫자를 입력 받고 입력 받은 숫자를 배열로 처리하는 메서드
    public int[] guessNum() {
        int getNum;
        int guessedNum[] = new int[3];
        int check = -1;

        while (check != 0) {
            System.out.print("숫자를 입력해주세요 : ");
            getNum = new Scanner(System.in).nextInt();

            guessedNum[0] = getNum / 100;
            guessedNum[1] = getNum / 10 % 10;
            guessedNum[2] = getNum % 10;

            check = numCheck(getNum, guessedNum);
        }
        tryTimes++;

        return guessedNum;
    }

    // 플레이어가 입력한 숫자가 문제없이 입력이 되었는지 확인하는 메서드
    public int numCheck(int num, int[] guessedNum) {
        if (num < 100 || num > 999) {
            System.out.println("숫자의 길이가 3이 아닙니다.");
            return 1;
        }

        if (guessedNum[0] == guessedNum[1] || guessedNum[1] == guessedNum[2] || guessedNum[2] == guessedNum[0]) {
            System.out.println("중복된 숫자를 입력할 수 없습니다.");
            return 2;
        }

        return 0;
    }

    // 추측 숫자 배열을 입력받아서 정답과 비교한 후 Strike, Ball의 수를 배열로 반환해주는 메서드
    public int[] compare(int[] guessedNum) {
        int[] result = new int[]{0, 0};

        if (guessedNum[0] == answer.get(0)) {
            result[0]++;
        }
        if (guessedNum[1] == answer.get(1)) {
            result[0]++;
        }
        if (guessedNum[2] == answer.get(2)) {
            result[0]++;
        }
        result[1] = (int) Arrays.stream(guessedNum).filter(answer::contains).distinct().count();
        result[1] -= result[0];

        return result;
    }

    // 스트라이크, 볼의 정보가 담긴 배열을 받아서 문자열로 출력해주는 메서드
    public String info(int[] result) {
        if (result[0] == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! (" + tryTimes + "번 만에 정답) 게임 종료";
        }

        if (result[0] == 0 && result[1] == 0) {
            return "낫싱";
        }
        return result[0] + "스트라이크 " + result[1] + "볼";
    }

    // compare 메서드를 테스트하기 위해서 임시로 Setter 메서드 구현
    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
