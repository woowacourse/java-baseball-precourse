import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    private int[] userInput;
    private int[] answer;
    private int numOfDigit;

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.setGame(3);

        while (true) {
            game.createRandomAnswer();
            do {
                game.startGame();
            } while (game.checkAnswer());

            if (!game.restart()) {
                break;
            }
        }
    }

    public void setGame(int n) {
        userInput = new int[n];
        answer = new int[n];
        numOfDigit = n;
    }

    public void startGame() {

        System.out.print("숫자를 입력해주세요: ");
        this.userInput = getUserInput();

    }

    public void createRandomAnswer() {
        boolean visited[] = new boolean[10];
        int randomIndex;

        visited[0] = true;
        for (int i = 1; i < 10; i++) {
            visited[i] = false;
        }

        Random random = new Random();

        initializeAnswer();

        for (int i = 0; i < this.numOfDigit; i++) {
            randomIndex = random.nextInt(8) + 1;
            if (!visited[randomIndex]) {
                visited[randomIndex] = true;
                this.answer[i] = randomIndex;
            } else {
                i--;
            }
        }
    }

    public void initializeAnswer() {
        for (int i = 0; i < this.numOfDigit; i++) {
            this.answer[i] = 0;
        }
    }

    public int[] getUserInput() {
        int input;
        int[] userAnswer = new int[this.numOfDigit];
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        while (!errorCheckRange(input)) {
            input = sc.nextInt();
        }

        while (!errorCheckDuplicate(input)) {
            input = sc.nextInt();
        }

        while (!errorCheckZero(input)) {
            input = sc.nextInt();
        }

        for (int i = this.numOfDigit - 1; i >= 0; i--) {
            userAnswer[i] = input % 10;
            input /= 10;
        }

        return userAnswer;
    }

    public boolean errorCheckRange(int input) {
        if (input < 100 || input > 1000) {
            System.out.print("입력 에러: 3자리 숫자를 입력해 주세요!");
            return false;
        } else {
            return true;
        }
    }

    public boolean errorCheckDuplicate(int input) {
        int a, b, c;
        a = input % 10;
        input /= 10;
        b = input % 10;
        input /= 10;
        c = input % 10;
        if (a != b && a != c && b != c) {
            return true;
        } else {
            System.out.print("입력 에러: 서로 다른 숫자를 입력해 주세요!");
            return false;
        }
    }

    public boolean errorCheckZero(int input) {
        int a, b, c;
        a = input % 10;
        input /= 10;
        b = input % 10;
        input /= 10;
        c = input % 10;
        if (a == 0 || b == 0 || c == 0) {
            System.out.print("입력 에러: 1~9의 숫자를 입력해주세요!");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkAnswer() {
        int strike = 0;
        int ball = 0;
        boolean result;

        strike = checkStrike(answer, userInput);
        ball = checkBall(answer, userInput);

        if (strike == this.numOfDigit) {
            result = false;
        } else {
            result = true;
        }
        printResult(strike, ball);
        return result;
    }

    public int checkStrike(int[] answer, int[] userInput) {
        int result;

        result = 0;
        for (int i = 0; i < this.numOfDigit; i++) {
            if (answer[i] == userInput[i]) {
                result++;
            }
        }

        return result;
    }

    public int checkBall(int[] answer, int[] userInput) {
        int result;

        result = 0;
        if (userInput[0] == answer[1] || userInput[0] == answer[2]) {
            result++;
        }
        if (userInput[1] == answer[0] || userInput[1] == answer[2]) {
            result++;
        }
        if (userInput[2] == answer[0] || userInput[2] == answer[1]) {
            result++;
        }

        return result;
    }

    public void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱 ");
            return;
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        System.out.println();

        if (strike == this.numOfDigit) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public boolean restart() {
        int flagRestart;
        Scanner sc = new Scanner(System.in);
        flagRestart = sc.nextInt();

        if (flagRestart == 1) {
            return true;
        } else {
            return false;
        }
    }
}
