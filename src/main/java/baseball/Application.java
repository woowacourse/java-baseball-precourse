package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        boolean replayFlag = true;
        while (replayFlag) {
            // 난수 생성
            ThreeDigits threeDigitObject = new ThreeDigits();
            threeDigitObject.genThreeRandomDigits();
            //System.out.println(threeDigitObject.getThreeDigits());

            replayFlag = execute(threeDigitObject);
        }
    }

    public static boolean execute(ThreeDigits threeDigitObject) {
        int strikeNum;
        int ballNum;
        boolean replayFlag;

        while (true) {
            boolean isStriked = false;
            boolean isBalled = false;

            System.out.printf("%s ", "숫자를 입력해주세요 :");
            Scanner scanner = new Scanner(System.in);

            String numberInputStr = scanner.nextLine();
            Validator validator = new Validator();
            validator.validateNumberInput(numberInputStr);
            int inputNumber = Integer.parseInt(numberInputStr);

            // strike?
            strikeNum = threeDigitObject.checkStrike(inputNumber);
            if (strikeNum > 0) {
                isStriked = true;
            }

            // ball?
            ballNum = threeDigitObject.checkBall(inputNumber);
            if (ballNum > 0) {
                isBalled = true;
            }

            printResult(isStriked, isBalled, strikeNum, ballNum);
            if (strikeNum == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                replayFlag = wannaReplay();
                break;
            }
        }
        return replayFlag;
    }

    public static void printResult(boolean isStriked, boolean isBalled, int strikeNum, int ballNum) {
        if (isBalled && isStriked) {
            System.out.printf("%d볼 %d스트라이크\n", ballNum, strikeNum);
        } else if (isStriked) {
            System.out.printf("%d스트라이크\n", strikeNum);
        } else if (isBalled) {
            System.out.printf("%d볼\n", ballNum);
        } else { // ('볼'도 아니고, '스트라이크'도 아닌 경우)
            System.out.println("낫싱");
        }
    }

    public static boolean wannaReplay () {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        String replayDecisionInputStr = scanner.nextLine();
        Validator validator = new Validator();
        validator.validateReplayInput(replayDecisionInputStr);

        int replayInputDecision = Integer.parseInt(replayDecisionInputStr);

        return replayInputDecision == 1;
    }
}