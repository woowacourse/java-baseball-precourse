package Baseball;

import java.util.Scanner;

public class PlayBaseball {
    private static Scanner sc;
    private static RandomNumber random;
    private static InputNumber input;
    private static int randomNumber;
    private static int inputNumber;
    private static int correct;
    private static boolean[] usedNumber;
    private final static int end_Game = 2;
    private final static int do_Game = 1;

    public PlayBaseball(){}

    private void setRandomNumber(){
        random = new RandomNumber();
        random.createRandomNumber();
        this.randomNumber = random.getRandomNumber();
        this.usedNumber = random.getUsedNumber();
    }

    private void setInputNumber(){
        input = new InputNumber();
        input.input();
        inputNumber = input.getInputNumber();
    }

    public void startGame(){
        correct = 0;

        setRandomNumber();
        while(correct != 3){
            setInputNumber();
            ScoreCheck score = new ScoreCheck(randomNumber,inputNumber,usedNumber);
            correct = score.scoreResult();
        }

        int ask = askEnd();

        if(ask == end_Game) {
            System.out.println("시스템 종료");
            System.exit(0);
        }else{
            startGame();
        }

    }

    private int askEnd(){
        sc = new Scanner(System.in);

        System.out.println("3개의 숫자를 맞히셨습니다! 게임 종료"+ "\n"
                            +"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int answer = sc.nextInt();
        if((answer != 1) && (answer != 2)){
            askEnd();
        }else{
            return answer;
        }
        return 0;
    }

}
