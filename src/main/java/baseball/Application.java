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
        /** targetNumber는 플레이어가 맞춰야할 임의의 수 3개 입니다 */
        int targetNumber = application.makeTargetNumber();
        System.out.print("Target Number : ");
        System.out.println(targetNumber);
        String strikeAndBallResult = "";
        while (!strikeAndBallResult.equals("3스트라이크")) {
            /* 결과가 3스트라이크 나올 때 까지 실행된다 */
            System.out.print("숫자를 입력해주세요 : ");
            /** userInputNumber는 플레이어가 입력한 숫자입니다 */
            int userInputNumber = scanner.nextInt();
            System.out.println(userInputNumber);
            application.checkUserInputNumber(userInputNumber);
            strikeAndBallResult = application.checkStrikeAndBall(targetNumber, userInputNumber);
            System.out.println(strikeAndBallResult);
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
     * 메서드 checkUserInputNumber()는 플레이어가 입력한 3자리수가 유효한지 검증 합니다.
     * @param userInputNumber 플레이어가 콘솔에 입력한 숫자입니다.
     * @exception 3자리 숫자가 아니거나, 3자리수 중에 중복되는 숫자가 있는 경우 IllegalArgumentException을 발생시킵니다.
     */
    public void checkUserInputNumber(int userInputNumber){
        //세자리수인지 확인하기
        if(userInputNumber > 999 || userInputNumber < 100) {
            throw new IllegalArgumentException();
        }

        //중복되는 숫자가 있는지 확인하기
        int firstUserInputNumber = userInputNumber/100;
        int secondUserInputNumber = (userInputNumber/10)%10;
        int thirdUserInputNumber = userInputNumber%10;
        if((firstUserInputNumber == secondUserInputNumber) || (firstUserInputNumber == thirdUserInputNumber)
                || (secondUserInputNumber == thirdUserInputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 메서드 checkStrikeAndBall()은 타깃넘버와 플레이어가 입력한 숫자를 비교하여 결과를 볼, 스트라이크 갯수로 표시합니다.
     * @param targetNumber 플레이어가 맞춰야 할 타깃넘버입니다. / userInputNumber 플레이어가 콘솔에 입력한 숫자입니다.
     * @return 결과에 따라 볼, 스트라이크 갯수나 낫싱을 리턴합니다.
     */
    public String checkStrikeAndBall(int targetNumber, int userInputNumber) {
        int [] targetArray;
        targetArray = makeArray(targetNumber);
        int [] userArray;
        userArray = makeArray(userInputNumber);

        int strike = 0;
        int ball = 0;
        //targetArray[0] 이랑 겹치는것?
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
        
        String result = "";
        if((ball == 0) && (strike == 0)) {
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
        temp[0] = number/100;
        temp[1] = (number/10)%10;
        temp[2] = number%10;
        return temp;
    }
}
