package baseball.GameManager;

import baseball.Result.BallResult;
import baseball.Result.NothingResult;
import baseball.Result.ResultBase;
import baseball.Result.StrikeAndBallResult;
import baseball.Result.StrikeResult;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {
    private static GameManager instance = null;

    private ResultBase result;
    private HashMap<Integer, Integer> numbers = new HashMap<>();

    private GameManager() {
        ResultBase strikeResult = new StrikeResult();
        ResultBase strikeAndBallResult = new StrikeAndBallResult();
        ResultBase ballResult = new BallResult();
        ResultBase nothingResult = new NothingResult();

        strikeResult.appendNext(strikeAndBallResult)
                .appendNext(ballResult)
                .appendNext(nothingResult);

        this.result = strikeResult;
    }

    public static GameManager getInstance() {
        if (GameManager.instance == null) {
            GameManager.instance = new GameManager();
        }

        GameManager.instance.initNumbers();
        return GameManager.instance;
    }

    public void run() {
        try {
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String line = Console.readLine();
                ArrayList<Integer> numbersArray = parseToIntegerArray(line);
                Score score = getScore(numbersArray);
                printResult(score);
                checkResultStatus(score);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void initNumbers() {
        this.numbers.clear();

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            this.numbers.put(number, i);

            // debug
            System.out.print(number);
        }
        System.out.println();
    }

    private void askPlayerToContinue() throws IllegalArgumentException {
        String line = Console.readLine();
        int input = Integer.parseInt(line);
        switch (input) {
            case 1:
                this.initNumbers();
                break;
            case 2:
                System.exit(0);
            default:
                throw new IllegalArgumentException(String.format("Invalid input %s. Input must be either 1 or 2", input));
        }
    }

    private ArrayList<Integer> parseToIntegerArray(String line) throws IllegalArgumentException {
        ArrayList<Integer> ret = new ArrayList<>();

        for (char c : line.toCharArray()) {
            int num = c - '0';
            if (num < 0 || num > 9) {
                throw new IllegalArgumentException(String.format("Invalid Input [%d]. Input must be in range [0,9]", num));
            }
            ret.add(c - '0');
        }

        return ret;
    }

    private Score getScore(ArrayList<Integer> numbersArray) {
        int strike = 0;
        int ball = 0;

        for (int number : numbersArray) {
            if (!numbers.containsKey(number)) {
                continue;
            }

            if (numbersArray.indexOf(number) == numbers.get(number)) {
                strike++;
                continue;
            }

            ball++;
        }

        return new Score(strike, ball);
    }

    private void printResult(Score score) {
        String message = this.result.getMessage(score.getStrike(), score.getBall());
        System.out.println(message);
    }

    private void checkResultStatus(Score score) throws IllegalArgumentException {
        try {
            if (score.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                askPlayerToContinue();
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
