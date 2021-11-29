package baseball.player;

import baseball.error.ErrorCode;
import baseball.valid.Valid;
import camp.nextstep.edu.missionutils.Console;

public class Player implements Valid {

    // 사용자로부터 숫자를 입력받는다.
    // 예외 처리 진행해야함.
    public int read() {
        // IO 처리 추가 후에 구현
        String input = Console.readLine();
        return filtrate(input);
    }

    public int filtrate(String input) {
        // 예외 (1) : 숫자가 아닌 입력값이 들어온 경우
        for(char c : input.toCharArray()) {
            distinguish(c);
        }

        int i = Integer.parseInt(input);
        // 예외 (2) : 세자리의 수가 아닌 경우
        if(!inRange(i)) {
            throw new IllegalArgumentException(ErrorCode.NOT_IN_RANGE.getContent());
        }

        // 예외 (3) : 숫자 내 중복된 수가 존재하는 경우
        if(duplicate(i)) {
            throw new IllegalArgumentException(ErrorCode.IS_DUPLICATE.getContent());
        }

        // 예외 (4) : 숫자 내 0이 존재하는 경우
        if(hasZero(i)) {
            throw new IllegalArgumentException(ErrorCode.HAS_ZERO.getContent());
        }

        return i;
    }

    private void distinguish(char c) {
        if(!Character.isDigit(c))
            throw new IllegalArgumentException(ErrorCode.FOUND_NOT_DIGIT.getContent());
    }
}
