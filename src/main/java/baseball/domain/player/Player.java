package baseball.domain.player;

import baseball.domain.pitch.Pitch;
import baseball.domain.valid.Valid;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static baseball.finalstring.error.ErrorCode.*;

public class Player implements Valid {
    private List<Integer> numberList;

    public String input() {
        numberList = new ArrayList<>();
        return fillList(playRead());
    }

    private String fillList(String input) {
        // 사용자로부터 입력받은 3자리수를 각 자리수 별로 리스트에 넣어준다.
        for(char c : input.toCharArray()) {
            numberList.add(c - '0');
        }
        return input;
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
        return filtrate(Console.readLine());
    }

    // 게임 실행이 완료되고 재 실행 여부를 물어보는 질문에 대한 I/O 처리이다.
    public int endRead() {
        String input = Console.readLine();
        catchNotDigit(input);
        int restart = Integer.parseInt(input);
        if(notOneOrTwo(restart))
            throw new IllegalArgumentException(NOT_ONE_OR_TWO.getContent());
        return restart;
    }

    // 사용자의 입력에 대해 예외상황을 필터링 하기 위한 처리이다.
    public String filtrate(String input) {
        // 예외 (1) : 숫자가 아닌 입력값이 들어온 경우
        catchNotDigit(input);

        // 예외 (2) : 세자리의 수가 아닌 경우
        if(!inRange(input)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getContent());
        }

        // 예외 (3) : 숫자 내 중복된 수가 존재하는 경우
        if(duplicate(input)) {
            throw new IllegalArgumentException(IS_DUPLICATE.getContent());
        }

        // 예외 (4) : 숫자 내 0이 존재하는 경우
        if(hasZero(input)) {
            throw new IllegalArgumentException(HAS_ZERO.getContent());
        }

        return input;
    }

    // 숫자가 아닌 문자가 있는 경우
    private void catchNotDigit(String input) {
        for(char c : input.toCharArray()) {
            distinguish(c);
        }
    }

    // 게임 재 실행 여부를 확인할 때 1 혹은 2 값을 검증한다.
    private boolean notOneOrTwo(int input) {
        return input != 1 && input != 2;
    }

    // 각 문자가 숫자가 아닌 다른 문자인지 확인하고, 아니면 예외를 발생한다.
    private void distinguish(char c) {
        if(!Character.isDigit(c))
            throw new IllegalArgumentException(FOUND_NOT_DIGIT.getContent());
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
