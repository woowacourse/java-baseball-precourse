import java.util.Random;
import java.util.Scanner;

/**
 * @author SMJin
 * baseballGame Class
 * */
public class baseballGame {

    public static void main(String[] args) {

        int answerNumA = 0;
        int answerNumB = 0;
        int answerNumC = 0;

        int[] answerNum = {0, 0, 0};
        while (isOverlap(answerNum)) {
            answerNum = initBaseballNumber(answerNumA, answerNumB, answerNumC);
        }
        
        int num[] = new int[3];
        boolean finish = false;

        Scanner scanner = new Scanner(System.in);

        while (!finish) {
            System.out.print("숫자를 입력해주세요 : ");
            int UserNumber = scanner.nextInt();
            num[0] = UserNumber/100;
            num[1] = (UserNumber%100)/10;
            num[2] = UserNumber%10;

            finish = printResult(isStrike(answerNum, num), isBall(answerNum, num));

            if(finish) {
                if (scanner.nextInt() == 1)
                    finish = false;
            }

        }

    }

    /*
    정답 숫자들을 랜덤으로 생성하여 int형 배열로 반환하여 주는 메소드이다.
     */
    static private int[] initBaseballNumber(int answerNumA, int answerNumB, int answerNumC) {
        Random random = new Random();
        answerNumA = random.nextInt(9)+1;
        answerNumB = random.nextInt(9)+1;
        answerNumC = random.nextInt(9)+1;

        int[] answerNum = {answerNumA, answerNumB, answerNumC};

        return answerNum;
    }

    static private boolean isOverlap(int[] answerNum) {
        for(int i=0; i<3; i++) {
            if ((answerNum[i] == answerNum[(i+1)%3]) || (answerNum[i] == answerNum[(i+2)%3])) {
                return true;
            }
        }
        return false;
    }

   /*
    int형 정답 배열과 int형 사용자가 입력한 배열을 인자로 넣으면, Strike 횟수를 반환해주는 메소드이다.
     */
    static private int isStrike(int answerNum[], int num[]) {
        int strikeNumber = 0;

        for (int i=0; i<3; i++) {
            if (isSame(answerNum[i], num[i])) {
                strikeNumber++;
            }
        }

        return strikeNumber;
    }

    /*
    int형 정답 배열과 int형 사용자가 입력한 배열을 인자로 넣으면, Ball 횟수를 반환해주는 메소드이다.
     */
    static private int isBall(int answerNum[], int num[]) {
        int ballNumber = 0;

        for (int i=0; i<3; i++) {
            if (isSame(answerNum[i], num[(i+1)%3])) {
                ballNumber++;
            }
            if (isSame(answerNum[i], num[(i+2)%3])) {
                ballNumber++;
            }
        }

        return ballNumber;
    }

    /*
    인자로 들어온 두 int 형 숫자가 같으면 TRUE 를 반환하는 메소드이다.
     */
    static private boolean isSame(int answerNum, int num) {
        return (answerNum == num);
    }

    static private boolean printResult(int strikeNumber, int ballNumber) {
        boolean finish = false;
        if (strikeNumber == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                    "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            finish = true;
        } else if ((strikeNumber == 0) && (ballNumber == 0)) {
            System.out.println("낫싱");
        } else if ((strikeNumber == 0) && (ballNumber != 0)) {
            System.out.println(ballNumber + "볼");
        } else if ((strikeNumber != 0) && (ballNumber == 0)) {
            System.out.println(strikeNumber + " 스트라이크");
        } else {
            System.out.println(strikeNumber + " 스트라이크 " + ballNumber + "볼");
        }

        return finish;
    }

}
