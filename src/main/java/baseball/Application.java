/*
 * Application.java    2020/11/26
 *
 * Version 1.0
 *
 * Final commit on 2020/11/26
 *
 * woowacourse/java-baseball-precourse
 * Applicant Jo Yeong Sang (PapimonLikelion)
 * All rights reserved.
 */

package baseball;

import utils.RandomUtils;

import java.util.Random;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application();
        boolean gaming = true;

        while(gaming) {
            /* gaming 변수가 false가 될 때 까지 실행한다 */
            int targetNumber = application.makeTargetNumber();
            String strikeAndBallResult = "";

            while (!strikeAndBallResult.equals("3스트라이크")) {
                /* strikeAndBallResult가 3스트라이크가 될 때 까지 실행한다 */
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = scanner.nextLine();
                /* userInput이 유효한 인풋인지 확인한 후, 유효하다면 userInputNumber에 3자리 정수를 반환한다 */
                int userInputNumber = application.checkUserInput(userInput);
                /* targetNumber, userInputNumber를 비교하여 스트라이크/볼 결과를 도출한다 */
                strikeAndBallResult = application.checkStrikeAndBall(targetNumber, userInputNumber);
                System.out.println(strikeAndBallResult);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            /* gamingStatus로 플레이어의 게임 재시작 여부를 판별한다 */
            int gamingStatus = scanner.nextInt();
            gaming = application.restartOrTerminate(gamingStatus);
        }

        scanner.close();
    }

    /**
     * 메서드 makeTargetNumber()는 플레이어가 맞춰야할 중복되지 않는 임의의 수 3개를 정하는 역할을 합니다.
     * @return 1에서 9까지 서로 다른 임의의 수 3개를 리턴합니다.
     */
    public int makeTargetNumber() {
        int firstTargetNumber = RandomUtils.nextInt(1, 9);

        int secondTargetNumber = RandomUtils.nextInt(1, 9);
        while(firstTargetNumber == secondTargetNumber) {
            secondTargetNumber = RandomUtils.nextInt(1, 9);
        }

        int thirdTargetNumber = RandomUtils.nextInt(1, 9);
        while((firstTargetNumber == thirdTargetNumber) || (secondTargetNumber == thirdTargetNumber)) {
            thirdTargetNumber = RandomUtils.nextInt(1, 9);
        }

        return (firstTargetNumber*100) + (secondTargetNumber*10) + (thirdTargetNumber);
    }

    /**
     * 메서드 checkUserInput()는 플레이어가 입력한 인풋이 1에서 9까지 중복되지 않는 3자리 수인지 검증합니다.
     * @param userInput 플레이어가 콘솔에 입력한 인풋입니다.
     * @return userInput이 유효한 3자리 숫자라고 판단해 이를 정수로 변환해 반환한다.
     * @exception userInput 길이가 3이 아니거나, 정수로 변환 될 수 없는 경우, 3자리 수가 아닌 경우,
     * 3자리수 중에 중복된 숫자가 있거나 0이 포함되어 있는 경우 IllegalArgumentException 발생시킵니다.
     */
    public int checkUserInput(String userInput) {
        /* 세자리수인지 확인한다 */
        if (userInput.length() != 3 ) {
            throw new IllegalArgumentException();
        }

        int userInputNumber = 0;

        /* 정수로 변환 될 수 있는지 확인한다 */
        try {
            userInputNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        /* 3자리 수인지 확인한다 */
        if(userInputNumber > 999 || userInputNumber < 100) {
            throw new IllegalArgumentException();
        }

        /* 중복되는 숫자가 있는지, 중간에 0이 섞여 있는지 확인한다 */
        int firstUserInputNumber = userInputNumber/100;
        int secondUserInputNumber = (userInputNumber/10)%10;
        int thirdUserInputNumber = userInputNumber%10;
        if((firstUserInputNumber == secondUserInputNumber) || (firstUserInputNumber == thirdUserInputNumber)
                || (secondUserInputNumber == thirdUserInputNumber)) {
            throw new IllegalArgumentException();
        }
        if(secondUserInputNumber == 0 || thirdUserInputNumber == 0) {
            /* firstUserInputNumber가 0인 경우는 위에서 감지되어 확인할 필요 없다 */
            throw new IllegalArgumentException();
        }

        return userInputNumber;
    }

    /**
     * 메서드 checkStrikeAndBall()은 타깃넘버와 플레이어가 입력한 숫자를 비교하여 결과를 볼, 스트라이크 갯수로 표시합니다.
     * @param targetNumber 플레이어가 맞춰야 할 타깃넘버입니다.
     * @param userInputNumber 플레이어가 콘솔에 입력한 숫자입니다.
     * @return 결과에 따라 볼, 스트라이크 갯수나 낫싱을 리턴합니다.
     */
    public String checkStrikeAndBall(int targetNumber, int userInputNumber) {
        int [] targetArray;
        targetArray = makeArray(targetNumber);
        int [] userArray;
        userArray = makeArray(userInputNumber);

        int strike = 0;
        int ball = 0;

        /* targetArray[0] 이랑 겹치는것을 판별한다 */
        for(int i=0; i<3; i++) {
            if((targetArray[0] == userArray[i]) && (i == 0)) {
                strike++;
            } else if ((targetArray[0] == userArray[i]) && (i != 0)) {
                ball++;
            }
        }
        //targetArray[1] 이랑 겹치는것?
        for(int i=0; i<3; i++) {
            if((targetArray[1] == userArray[i]) && (i == 1)) {
                strike++;
            } else if ((targetArray[1] == userArray[i]) && (i != 1)) {
                ball++;
            }
        }
        //targetArray[2] 이랑 겹치는것?
        for(int i=0; i<3; i++) {
            if((targetArray[2] == userArray[i]) && (i == 2)) {
                strike++;
            } else if ((targetArray[2] == userArray[i]) && (i != 2)) {
                ball++;
            }
        }

        String result = resultStrikeAndBall(strike, ball);
        return result;
    }

    /**
     * 메서드 resultStrikeAndBall()은 checkStrikeAndBall()에서 strike, ball 갯수를 넘겨받아 결과를 String 형식으로 반환합니다.
     * @param strike checkStrikeAndBall() 에서 넘겨받은 strike 갯수
     * @param ball checkStrikeAndBall() 에서 넘겨받은 ball 갯수
     * @return 볼, 스트라이크 갯수나 낫싱을 리턴합니다.
     */
    public String resultStrikeAndBall(int strike, int ball) {
        String result = "";
        if ((ball == 0) && (strike == 0)) {
            result += "낫싱";
        } else if ((ball != 0) && (strike == 0)) {
            result += Integer.toString(ball);
            result += "볼";
        } else if ((ball == 0) && (strike != 0)) {
            result += Integer.toString(strike);
            result += "스트라이크";
        } else {
            result += Integer.toString(ball);
            result += "볼 ";
            result += Integer.toString(strike);
            result += "스트라이크";
        }
        return result;
    }

    /**
     * 메서드 makeArray()는 3자리수 숫자를 첫째자리, 둘째자리, 셋째자리 순서로 integer 배열에 저장해 이를 리턴해줍니다.
     * @param number 3자리수 (타깃넘버나 유저인풋넘버) 입니다.
     * @return 받은 3자리수를 첫째자리, 둘째자리, 셋째짜리로 나누어 integer 배열로 저장해 리턴합니다.
     */
    public int[] makeArray(int number) {
        int [] temp = new int[3];
        temp[0] = number/100;               /* 첫째자리 */
        temp[1] = (number/10)%10;           /* 둘째자리 */
        temp[2] = number%10;                /* 셋째자리 */
        return temp;
    }

    /**
     * 메서드 restartOrTerminate()는 한 게임이 종료된 뒤, 게임을 재시작 할지 완전히 종료할 지를 판별합ㄴ다
     * @param gamingStatus 한 게임이 종료한 뒤, 플레이어가 게임 재시작 여부를 입력합니다.
     * @return gamingStatus가 1이면 true, 2이면 false를 반환합니다.
     * @exception gamingStatus가 1 또는 2가 아니라면 IllegalArgumentException 발생시킵니다.
     */
    public boolean restartOrTerminate(int gamingStatus) {
        if (gamingStatus == 1) {
            return true;
        } else if (gamingStatus == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
