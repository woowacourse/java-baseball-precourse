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

        strikeResult.appendNext(strikeAndBallResult);
        strikeAndBallResult.appendNext(ballResult);
        ballResult.appendNext(nothingResult);

        this.result = strikeResult;
    }

    public static GameManager getInstance() {
        if (GameManager.instance == null) {
            GameManager.instance = new GameManager();
        }

        return GameManager.instance;
    }

    public void run() {
        initNumbers();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String line = Console.readLine();
            ArrayList<Integer> numbersArray = parseToIntegerArray(line);
            Score score = getScore(numbersArray);

        }
    }

    private void initNumbers() {
        this.numbers.clear();

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            this.numbers.put(number, i);
        }
    }

    private int askPlayerToContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String line = Console.readLine();
        return Integer.parseInt(line);
    }

    private ArrayList<Integer> parseToIntegerArray(String line) {
        ArrayList<Integer> ret = new ArrayList<>();

        for (char c : line.toCharArray()) {
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
}
