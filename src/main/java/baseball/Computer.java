package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import jdk.jfr.internal.tool.Main;

// 범위 입력해야된다
import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    private static final int numberLength = 3;
    private static List<Integer> computerRandomNumbers= new ArrayList<>();

    public Computer(){
        computerRandomNumbers = setComputerRandomNumber();
    }

    // 컴퓨터가 서로 다른 랜덤한 숫자 생성- set 사용
    public List<Integer> setComputerRandomNumber(){
        Set<Integer> randomNumber = new HashSet<>();
        while(randomNumber.size() <3){
            int number = pickNumberInRange(1, 9);
            randomNumber.add(number);
        }
        return new ArrayList<>(randomNumber);
    }
    public List<Integer> computerRandom(){
        return computerRandomNumbers;
    }
    // 입력을 검사하는 기능
//    public int[] takeUserInput(String userInput){
//         int[] split = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();
//
//        return split;
//    }

    // 볼, 스트라이크, 낫싱 게산후 결과 반환




}
