import java.util.Scanner;

/**
 * 메인 화면 구현 클래스
 * @version 2.0
 * @date 2019.03.23
 * @author 이상원
 */
public class Main {

    public static void main(String[] args){
        /*사용자로부터 받은 숫자를 저장하는 변수*/
        int humanNum;

        Human human = new Human();

        Computer com = new Computer();

        Game game = new Game();

        /*3 스트라이크 이후 게임을 지속하는지 확인하는 변수*/
        boolean continueFlag = true;

        /*3 스트라이크를 확인하는 변수*/
        int finishedFlag = 0;


        com.makeRandomNum();
        com.showNum();

        Scanner sc = new Scanner(System.in);

        while(continueFlag){
            System.out.print("숫자를 입력해주세요: ");

            humanNum = sc.nextInt();
            human.setInputNum(humanNum);
            if(human.isValid() != true){
                System.out.println("서로 다른 숫자를 입력해주세요");
                continue;
            }

            finishedFlag = game.judgingScore(human.getHumanNumArray(),com.getComNumArray());
            game.showScore();
            game.initializeAgain();

            if(finishedFlag == 1){
                com.reset();
                com.showNum();
                continueFlag = game.continueGame();
                continue;
            }
        }
    }
}
