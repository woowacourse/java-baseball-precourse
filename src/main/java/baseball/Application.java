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
        Application app = new Application();
        int targetNumber = app.makeTargetNumber();
        System.out.println(targetNumber);
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

}
