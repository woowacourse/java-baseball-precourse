import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    public void startGame() {

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
            System.out.println("낫싱");
            return;
        }

        System.out.println(strike + "스트라이크 " + ball + "볼");

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
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] answer;
        int[] userInput;
        boolean check;
        int strike;
        int ball;
        BaseballGame game = new BaseballGame();

        game.startGame();
        answer = game.createRandomAnswer();

        check = true;
        ball = 0;
        strike = 0;
        while(check){
            userInput = game.getUserInput();
            strike = game.checkStrike(answer, userInput);
            ball = game.checkBall(answer, userInput);

            if(strike == 3){
                game.printResult(strike, 0);
                check = game.restart();
            }else if(strike > 0 || ball > 0){
                game.printResult(strike, ball);
                check = true;
            }else{
                game.printResult(0, 0);
                check = true;
            }
        }
    }
}
