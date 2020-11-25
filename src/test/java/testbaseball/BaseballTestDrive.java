
package testbaseball;

import java.util.Scanner;

public class BaseballTestDrive {

    public final static int NUMBER_SIZE = 3;

    private int[] chosenNumber = new int[NUMBER_SIZE];
    private int ballCount = 0;
    private int strikeCount = 0;

    public int getChosenNumber(int index) {
        return chosenNumber[index];
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setChosenNumber(int index, int val) {
        chosenNumber[index] = val;
    }

    public void addBallCount() {
        ballCount++;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public void clearCounts() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void clearChosenNumber() {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            setChosenNumber(i, 0);
        }
    }

    public void selectRandomNumber() {
        clearChosenNumber();
        boolean[] isUsed = new boolean[10];
        int currentIndex = 0;
        while (currentIndex < NUMBER_SIZE) {
            int randomNumber = (int)(Math.random() * 10);
            if (!isUsed[randomNumber]){
                setChosenNumber(currentIndex, randomNumber);
                isUsed[randomNumber] = true;
                currentIndex++;
            }
        }
    }

    public boolean playGame(Scanner scanner) throws IllegalArgumentException {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = scanner.nextLine();
            boolean isFinished = judgeGame(input);
            // indent 수정 필요함.
            if (isFinished) {
                System.out.println(NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int command = scanner.nextInt();
                if (command == 1) {
                    // 버퍼 비우는 것을 잊어서 한참 헤맸음
                    scanner.nextLine(); // buffer flush
                    return true;
                }
                return false;
            }
        }
    }

    public boolean judgeGame(String input) {
        // Convert string to each integers
        int[] inputNumber = new int[NUMBER_SIZE];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            inputNumber[i] = input.charAt(i) - '0';
        }

        clearCounts();

        // Count strike cases
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (getChosenNumber(i) == inputNumber[i]) {
                addStrikeCount();
            }
        }

        // Count ball cases
        /* 객체지향의 특성을 살려서 숫자의 개수도 상수화 해서 유지보수하기 쉽게 만들려고 했으나,
        * 2중 반복문과 조건문을 사용하게 되면 indent depth가 2보다 커지기 때문에 하나씩 조건을 비교했다.
        * */
        if (getChosenNumber(0) == inputNumber[1] || getChosenNumber(0) == inputNumber[2]) {
            addBallCount();
        }
        if (getChosenNumber(1) == inputNumber[0] || getChosenNumber(1) == inputNumber[2]) {
            addBallCount();
        }
        if (getChosenNumber(2) == inputNumber[0] || getChosenNumber(2) == inputNumber[1]) {
            addBallCount();
        }

        int currentBallCount = getBallCount();
        int currentStrikeCount = getStrikeCount();
        if (currentBallCount > 0) {
            System.out.print(currentBallCount + "볼 ");
        }
        if (currentStrikeCount > 0) {
            System.out.print(currentStrikeCount + "스트라이크");
        }
        if (currentBallCount == 0 && currentStrikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        if (currentStrikeCount == NUMBER_SIZE) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BaseballTestDrive btd = new BaseballTestDrive();

        while (true) {
            btd.selectRandomNumber();
            boolean keepGoing = btd.playGame(scanner);
            if (!keepGoing) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}
