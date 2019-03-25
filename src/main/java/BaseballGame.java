import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    private int strike;
    private int ball;

    private List<Integer> answer;
    private List<Integer> input;

    private Random random;
    private Scanner scanner;


    public BaseballGame() {
    }

    public void init() {
        answer = new ArrayList<>(3);
        input = new ArrayList<>(3);
        random = new Random();
        scanner = new Scanner(System.in);
        strike = 0;
        ball = 0;
    }

    public void start() {
        String inputStr;
        boolean isCorrect = false;

        setAnswer();

        while (!isCorrect) {
            strike = 0;
            ball = 0;
            input.clear();

            System.out.print("숫자를 입력해주세요 : ");
            inputStr = scanner.nextLine();
            for (int i = 0; i < 3; i++)
                input.add(Integer.parseInt(inputStr.substring(i, i + 1)));
            checkCount();

            if (strike == 3)
                isCorrect = true;
        }

    }

    public void reset() {

    }

    public void close() {

    }

    private void setAnswer() {
        do {
            int i = random.nextInt(9) + 1;
            if (!answer.contains(i))
                answer.add(i);
        } while (answer.size() < 3);
    }

    private void checkCount() {
        for (int i : input)
            if (answer.contains(i))
                ball++;

        for (int i = 0; i < answer.size(); i++)
            if (answer.get(i) == input.get(i)) {
                ball--;
                strike++;
            }

        if ((strike == 0) && (ball == 0))
            System.out.println("낫싱");
        else if (strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다!! 게임 종료");
        else
            System.out.println(strike + " 스트라이크, " + ball + " 볼");
    }

}
