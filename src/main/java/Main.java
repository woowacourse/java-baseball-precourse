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

        Scanner sc = new Scanner(System.in);
        
        /*컴퓨터가 랜덤 숫자를 만든다.*/ 
        com.makeRandomNum();
        
        /*테스트용으로, 컴퓨터가 만든 숫자를 보여준다. */
        //com.showNum();

        /*
         * 사용자가 3 스트라이크 이후 게임을 계속하는지 여부를 확인하여
         * 아니라면 이 루프를 탈출한다.
         */
        while(continueFlag){
        
            System.out.print("숫자를 입력해주세요: ");
            /*사용자에게 숫자를 입력받는다. */
            humanNum = sc.nextInt();
            human.setInputNum(humanNum);
            if(human.isValid() != true){
                System.out.println("서로 다른 숫자를 입력해주세요");
                continue;
            }

            finishedFlag = game.judgingScore(human.getHumanNumArray(),com.getComNumArray());
            
            /*추측이 끝나고 스트라이크와 볼을 보여준다. */
            game.showScore();
            
            /*추측이 끝나고 다시 게임을 초기화한다. */
            game.initializeAgain();

            /*3 스트라이크라면 */
            if(finishedFlag == 1){
                /*게임을 리셋 */
                com.reset();
                //com.showNum();
                
                /*사용자에게 게임을 계속하는지 물어본다. */
                continueFlag = game.continueGame();
                continue;
            }
        }
    }
}
