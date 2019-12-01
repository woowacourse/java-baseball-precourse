package Baseball;

import java.util.Scanner;

public class PlayBaseball {
    private Scanner sc;
    private RandomNumber random;
    private InputNumber input;
    private int randomNumber;
    private int inputNumber;
    private int correct;
    private boolean[] usedNumber;
    private final int end_Game = 2;
    private final int do_Game = 1;

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
        System.out.println("3개의 숫자를 맞히셨습니다! 게임 종료");
        int ask = askEnd();

        if(ask == end_Game) {
            System.exit(0);
        }else if(ask == do_Game){
            startGame();
        }

    }

    private int askEnd(){
        sc = new Scanner(System.in);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int answer = sc.nextInt();
        if((answer != 1) && (answer != 2)){
            askEnd();
        }else{
            return answer;
        }
        return 0;
    }

}
