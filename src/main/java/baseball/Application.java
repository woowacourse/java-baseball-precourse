package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static final int startInclusive = 1;
    private static final int endInclusive = 10;

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        //게임 전체 진행
        while (true) {
            //랜덤한 수 생성
            int[] question = new int[3];
            question[0] = Randoms.pickNumberInRange(startInclusive, endInclusive);
            question[1] = Randoms.pickNumberInRange(startInclusive, endInclusive);
            question[2] = Randoms.pickNumberInRange(startInclusive, endInclusive);

            //답변 제시
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String answer = Console.readLine();

                //3자리가 아닌 수를 입력하면 예외 발생
                if (answer.length() !=3) {
                    throw new IllegalArgumentException("3자리 수를 입력해주세요.");
                }

                //답변에 0이 포함되면 예외 발생
                if (answer.contains("0")) {
                    throw new IllegalArgumentException("답변은 0을 포함할 수 없습니다.");
                }

                //문자열 answer을 숫자배열 answerArray로 변환
                String[] answerStrings = answer.split("");
                int[] answerArray = new int[answerStrings.length];
                for (int i = 0; i < answerStrings.length; i++) {
                    answerArray[i] = Integer.parseInt(answerStrings[i]);
                }

                int[] result = compareCorrectAnswer(question, answerArray);
                int strike = result[0];
                int ball = result[1];

                //일치 여부에 따른 결과 출력
                if (strike != 0 && ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else if (strike != 0 && ball != 0) {
                    System.out.print(ball + "볼 ");
                    System.out.println(strike + "스트라이크");
                } else if (strike == 0 && ball != 0) {
                    System.out.println(ball + "볼 ");
                } else if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            //게임 재실행 여부 판단
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int num = Integer.parseInt(Console.readLine());
            if (num == 1) {

            } else if (num == 2) {
                break;
            }
        }
    }

    //문제와 답변의 일치 여부 판단
    private static int[] compareCorrectAnswer(int[] question, int[] answerArray) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < question.length; i++) {
            int j = (i + 1) % answerArray.length;
            int k = (i + 2) % answerArray.length;

            if (question[i] == answerArray[i]) {
                strike++;
            } else if (question[i] == answerArray[j] || question[i] == answerArray[k]) {
                ball++;
            }
        }

        return new int[] {strike, ball};
    }
}
