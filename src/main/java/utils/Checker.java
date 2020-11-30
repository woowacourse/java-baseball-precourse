package utils;

import java.util.Scanner;

public class Checker {
    private static boolean[] chk = new boolean[9];

    private Checker() {
    }

    public static boolean checkDuplicateNumber(int num){
        if(chk[num-1]){
            return true;
        }
        else{
            chk[num-1]=true;
            return false;
        }
    }

    public static boolean checkInput(char oneOfNumber){
        return 49 <= oneOfNumber && oneOfNumber <= 57;
    }

    public static boolean checkBall(int guess, int[] target, int index){
        for(int i=0; i < 3; i ++){
            if(i != index && guess == target[i]){
                return true;
            }
        }
        return false;
    }

    public static int checkReplay(Scanner scanner){
        int replayNum=0;
        while(true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            replayNum = scanner.nextInt();
            if(replayNum != 1 && replayNum != 2){
                System.out.println("잘못된 입력입니다");
                continue;
            }
            else{
                break;
            }
        }
        return replayNum;
    }
}
