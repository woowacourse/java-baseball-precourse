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

    public static void main(String[] args) {
        int[] answer;
        int[] userInput;
        int strike;
        int ball;
        BaseballGame game = new BaseballGame();

        game.startGame();
        answer = game.createRandomAnswer();

        ball = 0;
        strike = 0;
        while(true){
            userInput = game.getUserInput();
            strike = game.checkStrike(answer, userInput);
            ball = game.checkBall(answer, userInput);

            if(strike == 3){
                break;
            }else if(strike > 0 || ball > 0){

            }else{

            }
        }

    }
}
