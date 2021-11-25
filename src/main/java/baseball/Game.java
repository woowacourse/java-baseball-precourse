package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Game {

    private static final int NUMBER_LENGTH = 3;
    private static final String INPUT_CHECK_REGEX = "[1-9][1-9][1-9]";
    private String randomNumber;
    private String userNumber;

    public void init() {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();

        while (hashSet.size() < NUMBER_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            hashSet.add(pickedNumber);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : hashSet) {
            stringBuilder.append(number);
        }

        randomNumber = stringBuilder.toString();
    }

    public boolean play() {
        takeInput();
        Result result = compareNumber();
        result.createMessage();
        result.printMessage();

        return result.isFinish(NUMBER_LENGTH);
    }

    private void takeInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }

        userNumber = input;
    }

    private boolean isValid(String input) {
        if (!input.matches(INPUT_CHECK_REGEX)) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            hashSet.add(input.charAt(i) - '0');
        }

        if (hashSet.size() != NUMBER_LENGTH) {
            return false;
        }

        return true;
    }

    private Result compareNumber() {
        Result result = new Result();

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int currentUserNumber = userNumber.charAt(i) - '0';
            int currentRandomNumber = randomNumber.charAt(i) - '0';

            if (currentUserNumber == currentRandomNumber) {
                result.addStrikeCount();
                continue;
            }

            hashSet.add(currentUserNumber);
        }

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int currentRandomNumber = randomNumber.charAt(i) - '0';
            if (hashSet.contains(currentRandomNumber)) {
                result.addBallCount();
            }
        }

        return result;
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
