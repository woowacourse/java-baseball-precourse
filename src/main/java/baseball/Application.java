package baseball;

import  camp.nextstep.edu.missionutils.Randoms;
//Randome으로 pickNumberInRange() 활용하여 랜덤ㄱ밧 얻기
import camp.nextstep.edu.missionutils.Console;
//입력은 Colsole.readLine() 으로 받을 것 !
public class Application {
    //실행 메인
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        //무조건 첫 판은 시도 -> 사용자 입력값에 따라 반복 여부 결정해야하 ㅁ
        //do -while 문
        String repeatOption = "";
        ComputerGame game;

        do {
            game = new ComputerGame();
            game.startGame();//게임 시작

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");

            repeatOption = Console.readLine();
        } while (repeatOption.equals("1"));//사용자가 1 누르는 동안 반복할 거임
    }
}


class ComputerAnswer {
    //컴퓨터용 정답
    //난수 생성
    private String answers = new String();//객체 단위

    //생성자 - 기본
    ComputerAnswer() {
        while (answers.length() < 3) {
            //1~9 사이 값을 서로 다르 수 3가지를 이어붙여 만들어야 함
            String tmp = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!answers.contains(tmp)) {
                answers += tmp;
            }
        }
        System.out.println(answers);//컴퓨터의 랜덤값을 출력시켜두기
    }

    //함수 : 사용자 입력값에 대한 처리
    public boolean getHint(String userAnswers) {
        int strike = countStrike(userAnswers);
        int ball = countBall(userAnswers);
        ball -= strike; //같은 숫자 개수 중. 스트라이크(자리까지 같은) 애는 제외시켜주고
        String output = "";

        if (ball > 0) { //볼 먼저 처리
            output += Integer.toString(ball) + "볼 ";
        }
        if (strike > 0) { //스트라이크 처리
            output += Integer.toString(strike) + "스트라이크 ";
        }

        System.out.println(output);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true; //정답 맞춤
        }
        return false;
    }

    //1) 볼 카운팅 = 같은 숫자가 다른 자리에 존재할 때
    private int countBall(String userAnswers) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            //userAnswers 내부에 각각의 컴터 인덱스의 숫자값이 존재할 경우 -1 아니고 인덱스 반환되면
            if (userAnswers.indexOf(answers.charAt(i)) > -1) {
                cnt++;
            }
        }
        return cnt;
    }

    //2) 스트라이크 카운팅 - 같은 숫자가 같은 자리에 존재할 때
    private int countStrike(String userAnswers) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (userAnswers.charAt(i) == answers.charAt(i)) {
                //동일한 위치에 값이 동일할 때.
                cnt++;
            }
        }
        return cnt;
    }

}
//사용자 입력값 다루는 객체
class UserInput {
    //사용자 인풋 담기
    String userAnswers;

    UserInput() {
        String tmp = Console.readLine();//사용자 입력받기
        //에러 체크
        checkException(tmp);
        userAnswers = tmp;//담기
    }

    //사용자 입력값 오류 던지기
    public void checkException(String userAnswers) throws IllegalArgumentException {

        //1) 길이 3 이 아닐 경우
        if (userAnswers.length() != 3) {
            throw new IllegalArgumentException();
        }
        //2) 1~9 사이 값이 아닐 경우
        for (int i = 0; i < 3; i++) {
            int tmp = (int) userAnswers.charAt(i);//각각의 값 떼와서
            if (tmp < (int) '1' || tmp > (int) '9') {
                throw new IllegalArgumentException();
            }
        }
    }
}
class ComputerGame {
    //컴퓨터 Answer
    private ComputerAnswer computerAnswer;
    //사용자 Input
    private UserInput userInput;

    //게임 시작 함수
    public void startGame() {
        computerAnswer = new ComputerAnswer();//난수 생성하기
        boolean correct = true;
        do {
            String userAnswers = "";
            System.out.print("숫자를 입력해주세요 : ");
            userInput = new UserInput();
            correct = computerAnswer.getHint(userInput.userAnswers);
        } while (!correct);
    }
}

