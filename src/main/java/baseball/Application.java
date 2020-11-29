package baseball;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        /*
        RandomNumber 객체를 생성하여 randNum에 무작위 세 숫자를 넣는다
         */
        RandomNumber randomNumber = new RandomNumber();
        List<Integer> randNum = randomNumber.randNumList();

        //랜덤출력 확인(출력이 이상없게 되는지 확인용)
        //System.out.println(randNum.get(0) + " " + randNum.get(1) + " " + randNum.get(2));

        //Game, MyNumber 객체 생성
        Game game = new Game();
        MyNumber myNumber = new MyNumber();
        try {
            //3스트라이크가 되면 숫자를 입력하고 결과를 출력하는 반복문을 빠져나온다
            int strike = 0;
            while (!game.threeStrike(strike)) {
                System.out.print("숫자를 입력해주세요 : ");
                int input = scanner.nextInt();
                List<Integer> inputNum = myNumber.myNumList(input);
                //내입력 리스트 확인(출력이 이상없는지 확인용)
                //System.out.println(inputNum.get(0) + " " + inputNum.get(1) + " " + inputNum.get(2));

                //스트라이크, 볼에 내 숫자 리스트, 랜덤 숫자 리스트를 비교하여 값을 넣는다
                int ball = game.ball(inputNum, randNum);
                strike = game.strike(inputNum, randNum);

                //스트라이크, 볼 결과를 출력한다
                game.result(strike, ball);
            }

            //게임을 다시 시작하는지를 입력받는다
            int reGame = scanner.nextInt();

            //1을 입력하면 메인 함수로 돌아가고, 2를 입력하면 게임을 종료하고, 기타 다른 것을 입력하면 IllegalArgumentException을 발생
            if (reGame == 1) {
                main(args);
            } else if (reGame == 2) {
                System.out.println("게임을 종료합니다.");
            } else {
                throw new IllegalArgumentException();
            }

        //잘못 입력한 경우 "잘못 입력하셨습니다."라는 메시지를 띄운 후 프로그램이 종료된다.
        } catch (IllegalArgumentException e) {
            System.out.println("잘못 입력하셨습니다.");
        }
    }
}
