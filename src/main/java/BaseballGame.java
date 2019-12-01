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

    public static void main(String[] args) {
        int[] answer;
        int[] userInput;
        BaseballGame game = new BaseballGame();

        game.startGame();
        answer = game.createRandomAnswer();
        userInput = game.getUserInput();

    }
}
