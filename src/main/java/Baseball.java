import java.util.Random;
import java.util.Scanner;

class Game {
    private char[] answer = new char[3];

    public Game() {
        answer = generateAnswer();
    }

    private char[] generateAnswer() {
        Random random = new Random();
        char[] str = new char[3];
        int[] randomCheck = new int[9];

        int i=0;
        while(i < str.length){
            int num = random.nextInt(9) + 1;

            if(randomCheck[num - 1] != 1){
                str[i] = (char) (num + '0');
                randomCheck[num-1]++;
                i++;
            }
        }

        return str;
    }

    public int[] CheckAnswer(String[] question){
        int[] bs = {0, 0}; // {ball, strike}

        for(int i=0; i < answer.length; i++){
            if (!String.valueOf(answer).contains(question[i])) {
                continue;
            }

            if(answer[i] == question[i].charAt(0)){
                bs[1]++; // strike 증가
            }else{
                bs[0]++; // ball 증가
            }
        }

        return bs;
    }

    public void print(int[] checkNum){
        String response = "";

        if(checkNum[1] != 0){
            response += checkNum[1] + " 스트라이크 ";
        }
        if(checkNum[0] != 0){
            response += checkNum[0] + " 볼";
        }

        if(response.equals("")){
            response += "낫싱";
        }

        System.out.println(response);
    }
}

public class Baseball {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        String[] numArr = new String[3];
        int[] checkNum = new int[2];
        boolean flag = false; // 정답인지 확인을 하기 위해

        while(!flag){
            numArr = input.next().split("");
            checkNum = game.CheckAnswer(numArr);
            game.print(checkNum);
        }
    }
}
