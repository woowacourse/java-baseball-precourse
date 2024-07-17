package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import jdk.jfr.internal.tool.Main;

// 범위 입력해야된다
import java.util.*;
import java.util.stream.Collectors;

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
    public List<Integer> takeUserInput(String userInput){
        List<Integer> splitUserInput = new ArrayList<>();
        try{
            // 숫자인가?
            // 파싱을 하면서 원소가 0이면 버리게 한다 -> filter
            splitUserInput = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).filter(value ->value!=0).boxed().collect(Collectors.toList());

            // 길이가 3인가?
            if(splitUserInput.size() !=3){
                throw new IllegalArgumentException("길이가 3이 아닙니다");
            }

        }catch (NumberFormatException e) { // 커스텀
            throw new IllegalArgumentException("숫자가 아닌 것이 있습니다.");
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        return splitUserInput;
    }

    // 볼, 스트라이크, 낫싱 게산후 결과 반환






}
