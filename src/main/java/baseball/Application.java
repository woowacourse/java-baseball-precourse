package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static final int gameSet = 2;

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        RandomNumGenerator randomNumber = new RandomNumGenerator();
        int[] computerNumber = randomNumber.getNumber();

        boolean gameOver = false;
        int playBall = 1;

        while(playBall != gameSet) {
            while (!gameOver) {

                UserNumberGetter userNumbergetter = new UserNumberGetter();
                int[] userNumber = userNumbergetter.getNumber();

                Judge Judge = new Judge();
                gameOver = Judge.Judgement(computerNumber, userNumber);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userGameInput = Console.readLine();

            if(userGameInput.length() != 1){
                throw new IllegalArgumentException();
            }

            playBall = userGameInput.charAt(1);

            if(playBall != 1 && playBall != 2){
                throw new IllegalArgumentException();
            }


        }


    }
}
