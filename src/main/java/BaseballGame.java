import java.util.Random;

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

    public static void main(String[] args) {
        int[] answer;
        BaseballGame game = new BaseballGame();

        game.startGame();
        answer = game.createRandomAnswer();
        
    }
}
