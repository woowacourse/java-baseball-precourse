package baseball;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        RandomNumber randomNumber = new RandomNumber();
        List<Integer> randNum = randomNumber.randNumList();
        //랜덤출력 확인
        //System.out.println(randNum.get(0) +" "+randNum.get(1) +" "+randNum.get(2));
        Game game = new Game();
        MyNumber myNumber = new MyNumber();
        int ball = 0;
        int strike = 0;
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                int inputNum = scanner.nextInt();
                List<Integer> inputNumArr = myNumber.inputList(inputNum);
                //내입력 리스트 확인
                //System.out.println(inputNumArr.get(0) +" "+inputNumArr.get(1) +" "+inputNumArr.get(2));
                ball = game.ball(inputNumArr, randNum);
                strike = game.strike(inputNumArr, randNum);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
                continue;
            }
            boolean result = game.result(strike, ball);
            int re = 0;
            if (result) {
                re = scanner.nextInt();
            }
            if(re == 1) {
                main(args);
            } else if(re == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}
