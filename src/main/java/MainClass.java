import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    public void printMenu(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        try{
            int menuNum = sc.nextInt();
            switch (menuNum){
                case 1 :
                    runGame();
                    break;
                case 2 :
                    break;
                default:
                     System.out.println("잘못된 입력값 입니다. 다시 입력하세요.");
                     printMenu();
                     break;
            }
        }catch (InputMismatchException e) {
            System.out.println("잘못된 입력값 입니다. 다시 입력하세요.");
            printMenu();
        }
    }

    public void runGame(){
        RandomNumber rn = new RandomNumber();
        Baseball b = new Baseball();
        rn.setRandomNum();
        while(true){
            b.setInputNum();
            b.setCheckStrike(rn);
            b.setCheckBall(rn);
            if(b.printResult()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                printMenu();
                break;
            }
        }
    }
    public static void main(String[] args){
        MainClass mc = new MainClass();
        mc.runGame();
    }
}
