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
            inputStr = scanner.next();
            scanner.nextLine();
            if (!checkInput(inputStr))
                continue;
            if (!addInputToArray(inputStr))
                continue;

            checkCount();

            if (strike == 3)
                isCorrect = true;
        }
    }

    public boolean reset() {
        String inputStr;

        answer.clear();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        inputStr = scanner.next();
        scanner.nextLine();
        if (inputStr.equals("1")) {
            System.out.println("다시 시작합니다.");
            return true;
        } else if (inputStr.equals("2")) {
            System.out.println("종료합니다.");
            return false;
        } else {
            System.out.println("잘못된 입력입니다. 종료합니다.");
            return false;
        }
    }

    public void close() {
        answer.clear();
        input.clear();
        scanner.close();
    }

    private void setAnswer() {
        do {
            int i = random.nextInt(9) + 1;
            if (!answer.contains(i))
                answer.add(i);
        } while (answer.size() < 3);
    }

    private boolean checkInput(String inputStr) {
        try {
            int i = Integer.parseInt(inputStr);
            if (i < 100 || i >= 1000) {
                System.out.println("잘못된 범위입니다. 다시 입력해주세요.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return false;
        }
    }

    private boolean addInputToArray(String inputStr) {
        int j;

        for (int i = 0; i < 3; i++) {
            j = Integer.parseInt(inputStr.substring(i, i + 1));
            if (j == 0) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                return false;
            }
            if (!input.contains(j))
                input.add(j);
            else {
                System.out.println("중복된 숫자가 존재합니다. 다시 입력해주세요.");
                return false;
            }
        }

        return true;
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
