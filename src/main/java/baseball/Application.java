package baseball;

import java.util.Scanner;
import utils.RandomUtils;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean gameCoin = true;
        while(gameCoin){
            String computerChoice = chooseComputerChoice();
            System.out.println(computerChoice);
            gameCoin = checkGameCoin();
        }
    }

    static boolean checkGameCoin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int gameCoin = sc.nextInt();
        return gameCoin == 1;
    }

    static String chooseComputerChoice(){
        int[] answer = new int[3];
        String computerChoice;
        answer[0] = RandomUtils.nextInt(1,9);
        do{
            answer[1] = RandomUtils.nextInt(1,9);
        }while(answer[0]==answer[1]);
        do{
            answer[2] = RandomUtils.nextInt(1,9);
        }while(answer[0]==answer[2] || answer[1]==answer[2]);
        
        computerChoice = Arrays.toString(answer).replaceAll("[^0-9]","");
        return computerChoice;
    }
}
