/*
 * Application.java    2020/11/26
 *
 * Version 1.0
 *
 * Final commit on 2020/11/30
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
        boolean gaming = true;
        while(gaming) {
            SingleGame.play(scanner);
            gaming = Restart.restartOrTerminate(scanner);
        }
        scanner.close();
    }
}
