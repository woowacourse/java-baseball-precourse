package baseball.domain.player;

import baseball.finalstring.error.ErrorCode;
import baseball.domain.pitch.Pitch;
import baseball.domain.valid.Valid;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player implements Valid {
    private List<Integer> numberList;

    public String input() {
        numberList = new ArrayList<>();
        return fillList(playRead());
    }

    private String fillList(String s) {
        // 사용자로부터 입력받은 3자리수를 각 자리수 별로 리스트에 넣어준다.
        for(char c : s.toCharArray()) {
            numberList.add(c - '0');
        }
        return s;
    }

    private Set<Pitch> pitchSet;

    public void setPitchSet(Set<Pitch> pitchSet) {
        this.pitchSet = pitchSet;
    }
    public Set<Pitch> getPitchSet() {
        return pitchSet;
    }

    // 사용자로부터 숫자를 입력받는다.
    // 예외 처리 진행해야함.
    public String playRead() {
        // IO 처리 추가 후에 구현
        String input = Console.readLine();
        return filtrate(input);
    }

    public int endRead() {
        String input = Console.readLine();
        catchNotDigit(input);
        int i = Integer.parseInt(input);
        if(notOneOrTwo(i))
            throw new IllegalArgumentException(ErrorCode.NOT_ONE_OR_TWO.getContent());
        return i;
    }

    private void catchNotDigit(String input) {
        for(char c : input.toCharArray()) {
            distinguish(c);
        }
    }

    private boolean notOneOrTwo(int input) {
        if(input != 1 && input != 2)
            return true;
        return false;
    }
    public String filtrate(String input) {
        // 예외 (1) : 숫자가 아닌 입력값이 들어온 경우
        catchNotDigit(input);

        // 예외 (2) : 세자리의 수가 아닌 경우
        if(!inRange(input)) {
            throw new IllegalArgumentException(ErrorCode.NOT_IN_RANGE.getContent());
        }

        // 예외 (3) : 숫자 내 중복된 수가 존재하는 경우
        if(duplicate(input)) {
            throw new IllegalArgumentException(ErrorCode.IS_DUPLICATE.getContent());
        }

        // 예외 (4) : 숫자 내 0이 존재하는 경우
        if(hasZero(input)) {
            throw new IllegalArgumentException(ErrorCode.HAS_ZERO.getContent());
        }

        return input;
    }

    private void distinguish(char c) {
        if(!Character.isDigit(c))
            throw new IllegalArgumentException(ErrorCode.FOUND_NOT_DIGIT.getContent());
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
