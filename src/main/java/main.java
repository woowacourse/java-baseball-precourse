import java.util.Scanner;

public class main {

    public static void main(String[] args){
        int humanNum;
        Human human = new Human();
        Computer com = new Computer();
        Game game = new Game();
        com.makeRandomNum();
        com.showNum();
        Scanner sc = new Scanner(System.in);
        boolean continueFlag = true;
        int finishedFlag = 0;
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
