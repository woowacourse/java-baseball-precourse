package baseball;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Application {
    public static void game(int answer) {
        //create random number
//        Randnum rd = new Randnum();
//        int answer = rd.createRandnum();
//        System.out.printf("answer=");
//        System.out.println(answer);
        int strike=0;
        int ball=0;
        int userAnswer=0;
        Scanner sc = new Scanner(System.in);
        Hints hint = new Hints();

        while(strike!=3) {
            //userinput: 3 number
            System.out.printf("input num: ");
            userAnswer = sc.nextInt();
            if (userAnswer>999 || userAnswer<111 || userAnswer%10==0 || userAnswer%100/10==0) throw new IllegalArgumentException();
            System.out.println("");

            strike = hint.Strike(answer, userAnswer);
            ball = hint.ball(strike, answer, userAnswer);
            if (strike != 0) System.out.printf("%ds ", strike);
            if (ball != 0) System.out.printf("%db", ball);
            if (ball + strike == 0) System.out.println("n");
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        //TODO: build baseball game

        int answer = parseInt(args[0]);
        if (answer>999 || answer<111) throw new IllegalArgumentException();
        game(answer);

        Scanner sc = new Scanner(System.in);
        System.out.println("new start:1 , end game:2");
        if(sc.nextInt()==1) game(answer);
        else System.out.println("end");
    }
}
