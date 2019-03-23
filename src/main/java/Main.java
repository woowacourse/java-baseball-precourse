import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int input;
        int restart = 0;
        boolean isEnd;
        do{
            isEnd = false;
            Computer computer = new Computer();
            computer.makeNum();

            while(isEnd == false){
                System.out.print("숫자를 입력해주세요 : ");
                input = scan.nextInt();
                isEnd = computer.checkNum(input);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = scan.nextInt();
        }while(restart == 1);

    }

}
class Computer{
    int firstNum,secondNum,thirdNum;


    public void makeNum(){
        do{
            firstNum = (int) (Math.random() * 8) + 1;
            secondNum = (int) (Math.random() * 8) + 1;
            thirdNum = (int) (Math.random() * 8) + 1;
        }while(firstNum == secondNum || thirdNum == secondNum || firstNum == thirdNum);

        System.out.println(firstNum);
        System.out.println(secondNum);
        System.out.println(thirdNum);
    }

    public boolean checkNum(int num){
        int strike = 0,ball = 0;
        int firstInputNum,secondInputNum,thirdInputNum;

        firstInputNum = num/100%10;
        secondInputNum = num/10%10;
        thirdInputNum = num%10;

        if(firstInputNum == firstNum) strike++;
        if(secondInputNum == secondNum) strike++;
        if(thirdInputNum == thirdNum) strike++;

        if(firstInputNum == secondNum || firstInputNum == thirdNum ) ball++;
        if(secondInputNum == firstNum || secondInputNum == thirdNum ) ball++;
        if(thirdInputNum == secondNum || thirdInputNum == firstNum ) ball++;

        if(strike == 3){
            System.out.println(strike + " 스트라이크");
            return true;
        }

        if(strike > 0 && ball >0){
            System.out.println(strike + " 스트라이크 "+ball+" 볼");
        }else if(strike >0 && ball == 0){
            System.out.println(strike + " 스트라이크");
        }else if(strike ==0 && ball > 0) {
            System.out.println(ball + " 볼");
        }else{
            System.out.println("낫싱");
        }
        return false;
    }


}