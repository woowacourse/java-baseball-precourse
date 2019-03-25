/*
 *  @(#)Game.java       1.00    2019/03/25
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package baseball;


/**
 * Game Class는 게임을 위한 클래스이다.
 * 인스턴스 변수인 user와 computer가 있다.
 * 사용자가 수를 맞출때까지 입력받고 결과를 출력하는 메서드가 있다.
 * 즉, 한 이닝을 반복적으로 실행한다. 맞추면 정답이라고 알려주고 정지한다.
 * 위의 메소드를 반복적으로 실행하는 메서드가 있고, 이 메서드는 입력에 따라 새로운 게임을 할 것인지 아닌지 판단한다.
 *
 * @version        1.00     2019년   3월  25일
 * @author         사명기
 */
public class Game {

    /** 인스턴스 변수인 user은 사용자이다. */
    private Player user;

    /** 인스턴스 변수인 computer은 컴퓨터다. */
    private Player computer;

    /**
     * Game 클래스의 생성자이다.
     * 내부에서는 user와 computer의 객체를 생성한다.
     */
    public Game(){
        this.user=new User();
        this.computer=new Computer();
    }

    /**
     * 숫자를 입력받기 전에 출력하는 메서드.
     */
    public void printGetNumber(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    /**
     * 한 이닝의 결과를 반환하는 메서드.
     * Inning 객체를 생성해서, 스트라이크와 볼 갯수를 count한다.
     * @return Inning 객체를 반환한다. Inning 객체에는 스트라이크, 볼 갯수가 저장되어있다.
     */
    public Inning getInningResult(){
        Inning inning=new Inning(0,0);
        for(int i=0; i<3; i++){
            if(this.user.getNumbers()[i] == this.computer.getNumbers()[i]){
                inning.strike++;                                                // 해당 자리수에 유저와 컴퓨터의 수가 같으면
            }
            else if((this.user.getNumbers()[i] == this.computer.getNumbers()[(i+1)%3])
                    || (this.user.getNumbers()[i] == this.computer.getNumbers()[(i+2)%3])){
                inning.ball++;           // 위치가 다르지만 같은 수가 있다면
            }
        }
        return inning;
    }

    /**
     * 한 이닝의 결과를 받아서 출력하는 메서드.
     * @param inning  getInningResult의 결과로 받은 파라미터.
     */
    public void printInningResult(Inning inning){
        System.out.println(inning.getResultToString());         // 이닝의 결과를 출력하는 메서드.
    }

    /**
     * User가 정답을 맞추면 진행 여부를 출력하는 메서드
     */
    public void printIsContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /**
     * 정답을 입력할 경우 출력하는 메서드.
     */
    public void printIsRightAnswer(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    /**
     * 프로그램이 종료될 때 출력하는 메서드
     */
    public void printIsOvered(){
        System.out.println("게임이 종료되었습니다.");
    }

    /**
     * 이닝을 진행하는 메서드
     * 정답을 맞출 때까지 계속 수를 입력받는다.
     */
    public void runInning() {
        while (true) {
            this.printGetNumber();                          // 숫자 입력하라는 문구 출력
            this.user.makeNewNumber();                      // 세 자리수 입력받음

            Inning inning = this.getInningResult();         // 이닝의 결과 객체를 생성.
            printInningResult(inning);                      // 결과를 출력

            if(inning.strike==3){
                this.printIsRightAnswer();
                break;                  // 3스트라이크면 종료
            }
        }
    }

    /**
     * 게임 전체를 실행하기 위한 메서드
     */
    public void run() {
        while (true){
            this.computer.makeNewNumber();      // 컴퓨터의 랜덤 세자리수 만듬
            System.out.println(this.computer.toString());
            this.runInning();                   // 사용자가 답을 입력하는것을 반복하는 running 메서드 실행(답을 맞추면 종료되는 메서드)
            this.printIsContinue();             // 새로운 게임을 진행할지 물어보는 출력

            if(!this.user.isContinue()){
                break;                          // 사용자가 종료(2) 입력 시
            }
        }
        this.printIsOvered();                   // 프로그램이 종료될 때 출력
    }

}

