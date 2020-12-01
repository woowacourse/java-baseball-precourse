package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 컴퓨터가 1에서 9까지의 서로 다른 임의의 수 3개를 정하는 클래스
 *
 * @version 1.0 2020-11-29
 *
 */
public class Computer {
    private String number = "";

    private static final int SIZE = 3;
    private static final int START = 1;
    private static final int END = 9;

    /**
     * List에 숫자를 넣고 List의 인덱스 값을 임의의 수로 생성해 list.remove()로 값을 반환하며 삭제
     * 중복 검사없이 3번만 실행하여 3자리 임의의 수를 생성하도록 했습니다.
     *
     * 이전 버전에서는 임의의 수를 직접 생성해서 중복검사를 따로 실행하여 3자리를 만들었지만
     * 운이 나쁘면 임의의 수를 여러번 만들어야 하는 단점이 있었습니다.
     */
    public Computer() {
        List<Integer> list = makeNumberList();

        for (int i = 0; i < SIZE; i++) {
            int randomNum = makeListNumber(list.size());
            addNumber(list.remove(randomNum));
        }
    }

    /**
     * 숫자 생성에 사용할 List 객체를 생성하고 반환하는 메서드
     * START 부터 END 값까지의 숫자를 List타입의 numberList 객체에 넣어주고 이를 반환
     *
     * @return START 부터 END 값까지의 숫자를 담은 numberList 를 반환
     */
    private List<Integer> makeNumberList() {
        List<Integer> numberList = new ArrayList<>();

        for (int i = START; i <= END; i++) {
            numberList.add(i);
        }

        return numberList;
    }

    /**
     * 0부터 숫자가 담긴 List의 길이까지 임의의 숫자 하나를 반환해주는 메서드
     * listSize-1 인 이유는 List의 인덱스 값의 끝을 범위로 설정하기 위함입니다.
     *
     * @param listSize 숫자가 담긴 List 객체의 Size
     * @return 숫자가 담긴 List 객체의 인덱스 값중 임의의 숫자 하나를 반환
     */
    private int makeListNumber(int listSize) {
        return RandomUtils.nextInt(0, listSize-1);
    }

    /**
     * 생성한 임의의 수 하나를 number 변수에 저장하는 메서드
     *
     * @param randomNumber 숫자가 담겨있던 list 안에 임의로 뽑아낸 숫자
     */
    private void addNumber(int randomNumber) {
        this.number += String.valueOf(randomNumber);
    }

    /**
     * number 변수를 가져오는 메서드
     *
     * @return number 변수를 반환
     */
    public String getNumber() {
        return this.number;
    }
}
