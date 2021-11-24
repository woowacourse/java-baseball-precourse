package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        checkNumberException(number);
        return number;
    }

    public void checkNumberException(String number) {
        InputValidator inputValidator=new InputValidator();
        try {
            if(!inputValidator.isNumber(number) || !inputValidator.checkLength(number,3)
                || !inputValidator.checkNumberScope(number)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            System.exit(1);
        }
    }
}
