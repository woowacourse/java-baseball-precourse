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
            startGame(computerChoice);
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

    static void startGame(String computerChoice){
        int strike;
        String userChoice = chooseUserChoice();
        strike = umpirePitch(computerChoice, userChoice);
        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }else{
            startGame(computerChoice);
        }
    }

    static String chooseUserChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String userChoice = sc.nextLine();
        return userChoice;
    }

    static int umpirePitch(String computerChoice, String userChoice){
        int strike = 0;
        int ball = 0;
        
        for(int i=0; i< computerChoice.length(); i++){
            if(computerChoice.charAt(i)==userChoice.charAt(i)){
                strike+=1;
            }
        }

        for(int i=0; i<userChoice.length(); i++){
            if(calculateBall(computerChoice, userChoice.charAt(i))){
                ball+=1;
            }
        }
        ball -= strike;
        callUmpire(strike,ball);
        return strike;
    }

    static boolean calculateBall(String computerChoice, int pitch){
        boolean ball = false;
        for(int i=0; i<computerChoice.length(); i++){
            if(computerChoice.charAt(i)==pitch){
                ball = true;
            }
        }
        return ball;
    }
    
    static void callUmpire(int strike, int ball){
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }else if(strike == 0 && ball != 0){
            System.out.println(ball+"볼");
        }else if(strike !=0 && ball == 0){
            System.out.println(strike+"스트라이크");
        }else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

}
