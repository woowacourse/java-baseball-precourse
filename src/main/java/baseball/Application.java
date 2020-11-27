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
        System.out.print("숫자를 입력해주세요 : ");
        /** userInputNumber는 플레이어가 입력한 */
        int userInputNumber = scanner.nextInt();
        System.out.println(userInputNumber);
        application.checkUserInputNumber(userInputNumber);
    }

    /**
     * 메서드 makeTargetNumber()는 플레이어가 맞춰야할 임의의 수 3개를 정하는 역할을 합니다.
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
        //세자리수인지 확인
        if(userInputNumber > 999 || userInputNumber < 100) {
            throw new IllegalArgumentException();
        }

        //중복되는 숫자가 있는지 확인
        int firstUserInputNumber = userInputNumber/100;
        int secondUserInputNumber = (userInputNumber/10)%10;
        int thirdUserInputNumber = (userInputNumber)%10;
        if((firstUserInputNumber == secondUserInputNumber) || (firstUserInputNumber == thirdUserInputNumber)
                || (secondUserInputNumber == thirdUserInputNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
