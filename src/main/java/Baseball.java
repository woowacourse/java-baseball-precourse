import java.util.Random;
import java.util.Scanner;

class Game {
    private String[] answer = new String[3];

    public Game() {
        answer = generateAnswer();
    }

    private String[] generateAnswer() {
        String[] str = new String[3];
        Random random = new Random();

        for (int i = 0; i < str.length; i++) {
            int num = random.nextInt(9) + 1;
            str[i] = String.valueOf(num);
        }

        return str;
    }
}

public class Baseball {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        boolean flag = false; // 정답인지 확인을 하기 위해
        String[] numArr = new String[3];

        while(!flag){
            numArr = input.next().split("");

        }
    }
}
