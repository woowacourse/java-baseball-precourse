package baseball;

import utils.Judge;


public class Game {

    // TODO: 변수 선언 위치 여기가 제일 효율적인지 따져보기 특히 answer,input
    private Computer computer;
    private Player player;
    private Judge judge;
    int[] answer;
    int[] input;

    public Game(){
        this.computer = new Computer();
        this.player = new Player();
        this.judge = new Judge();
    }

    // TODO: set과 start를 분리하는게 정말 좋은가? 생각 좀 해보기
    public void set(){
        answer = computer.generateAnswer();
    }

    public void input(){
        input = player.getInput();
//        input =new int[] {1,2,3};
    }

    public void start(){
        input();
        judge.judge(answer,input);
    }


    // TODO: Result Utils에 분리 및 구현
}

