package baseball;

import utils.RandomUtils;

import java.util.Scanner;

public class Application {
    private static int[] answer = new int[3];

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        makeAnswer(answer);
    }

    private static void makeAnswer(int[] answer){
        for(int i=0;i<3;i++){
            answer[i]=RandomUtils.nextInt(1, 9);
        }
    }
}
