import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    public static void main(String[] args) {
        int[] answer;
        int[] userInput;
        boolean finishGame;
        int strike = 0;
        int ball = 0;
        BaseballGame game = new BaseballGame();

        answer = game.createRandomAnswer();


    }

    public void startGame() {
        int [] userInput;
        int [] answer;
        boolean finishGame;
        int strike = 0;
        int ball = 0;

        answer = createRandomAnswer();
        System.out.print("숫자를 입력해주세요: ");
        userInput = getUserInput();

        finishGame = false;
        while (!finishGame) {
            game.startGame();
            userInput = game.getUserInput();
            strike = game.checkStrike(answer, userInput);
            ball = game.checkBall(answer, userInput);

            if (strike == 3) {
                game.printResult(strike, 0);
                finishGame = game.restart();
                answer = game.createRandomAnswer();
            } else if (strike > 0 || ball > 0) {
                game.printResult(strike, ball);
                finishGame = false;
            } else {
                game.printResult(0, 0);
                finishGame = false;
            }
        }
    }

    public int[] createRandomAnswer() {
        boolean visited[] = new boolean[10];
        int answer[] = new int[3];
        int randomIndex;

        visited[0] = true;
        for(int i = 1; i < 10; i++){
            visited[i] = false;
        }

        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            randomIndex = random.nextInt(8) + 1;
            if(!visited[randomIndex]){
                visited[randomIndex] = true;
                answer[i] = randomIndex;
            }else{
                i--;
            }
        }

        return answer;
    }

    public int[] getUserInput() {
        int input;
        int[] userAnswer = new int[3];
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        while(!errorCheckRange(input)){
            input = sc.nextInt();
        }

        while(!errorCheckDuplicate(input)){
            input = sc.nextInt();
        }

        for (int i = 2; i >= 0; i--) {
            userAnswer[i] = input % 10;
            input /= 10;
        }

        return userAnswer;
    }

    public boolean errorCheckRange(int input) {
        if(input < 100 || input > 1000){
            System.out.println("3자리 숫자를 입력해 주세요!");
            return false;
        }else{
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
        if(a == b || a == c || b == c){
            return false;
        }else if(a == b && a == c){
            return false;
        }else{
            return true;
        }
    }

    public int checkStrike(int[] answer, int[] userInput) {
        int result;

        result = 0;
        for (int i = 0; i < 3; i++) {
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

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public boolean restart() {
        int option;
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();

        if (option == 1) {
            return false;
        } else {
            return true;
        }
    }
}
