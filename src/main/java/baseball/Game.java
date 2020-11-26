package baseball;

import utils.RandomUtils;

import java.util.Scanner;

public class Game {
    public void start(Scanner scanner) {
        Integer number;


        System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            Validate myValidate = new Validate();
            if (myValidate.validate(number)) {
                System.out.println("입력숫자: " + number);
            }
            System.out.println("패키지 연결");
            RandomUtils myUtils = new RandomUtils();
            System.out.println(myUtils.nextInt(0, 9));

        }
        else if (!scanner.hasNextInt()){
            scanner.next();
        }
    }
}
