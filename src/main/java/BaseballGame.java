import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    public void startGame() {
        System.out.print("숫자를 입력해주세요:");
    }

    public int[] createRandomAnswer() {
        int arr[] = new int[3];
        Random random = new Random();

        for(int i = 0; i < 3; i++){
            arr[i] = random.nextInt(8) + 1;
            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    i--;
                }
            }
            //System.out.print(arr[i] + " ");
        }

        return arr;
    }

    public int[] getUserInput(){
        int input;
        int[] arr = new int[3];
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        for(int i = 2; i >= 0; i--){
            arr[i] = input % 10;
            input /= 10;
        }

        return arr;
    }

    public int checkStrike(int[] answer, int[] userInput){
        int result;

        result = 0;
        for(int i = 0; i < 3; i++){
            if(answer[i] == userInput[i]){
                result++;
            }
        }

        return result;
    }

    public int checkBall(int[] answer, int[] userInput){
        int result;

        result = 0;
        if(userInput[0] == answer[1] || userInput[0] == answer[2]){
            result++;
        }
        if(userInput[1] == answer[0] || userInput[1] == answer[2]){
            result++;
        }
        if(userInput[2] == answer[0] || userInput[2] == answer[1]){
            result++;
        }

        return result;
    }

    public void printResult(int strike, int ball){
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱 ");
            return;
        }

        if(strike > 0){
            System.out.print(strike + "스트라이크 ");
        }

        if(ball > 0){
            System.out.print(ball + "볼 ");
        }

        System.out.println();

        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public boolean restart(){
        int option;
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();

        if(option == 1){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        int[] answer;
        int[] userInput;
        boolean finishGame;
        int strike;
        int ball;
        BaseballGame game = new BaseballGame();

        answer = game.createRandomAnswer();

        finishGame = false;
        ball = 0;
        strike = 0;
        while(!finishGame){
            game.startGame();
            userInput = game.getUserInput();
            System.out.println();
            strike = game.checkStrike(answer, userInput);
            ball = game.checkBall(answer, userInput);

            if(strike == 3){
                game.printResult(strike, 0);
                finishGame = game.restart();
                answer = game.createRandomAnswer();
            }else if(strike > 0 || ball > 0){
                game.printResult(strike, ball);
                finishGame = false;
            }else {
                game.printResult(0, 0);
                finishGame = false;
            }
        }
    }
}
