/**
 * java-baseball-precourse
 * PlayerPerson.java
 * Purpose: 사람 Player의 동작을 구현함.
 *
 * @version 1.0.0
 * @author MinKyu, Song.
 */

import java.util.ArrayList;

import utils.ConvertUtils;
import utils.InputUtils;
import utils.RuleUtils;

public class PlayerPerson extends Player {
    static final String INPUTPROMPT = "숫자를 입력해주세요 : ";

    /**
     * 수 입력을 받아서 규칙을 따르는지 확인하고 이를 십진 자릿수별로 끊어 저장, 조합을 만들어 저장한다.
     */
    public void makeNumbers() {
        ArrayList<Integer> inputNumbers;
        while (true) {
            Integer input = InputUtils.inputInteger(INPUTPROMPT);
            inputNumbers = ConvertUtils.toDigitArrayList(input);
            if (RuleUtils.isValidDigit(inputNumbers)             // 사용자 입력이 따라야할 규칙
                    && RuleUtils.isValidRange(inputNumbers)
                    && RuleUtils.isUnique(inputNumbers)) {
                break;
            } else {
                System.out.println(InputUtils.INVALID);
            }
        }
        super.numbers = inputNumbers;
        makeNumbersCounts();
    }
}