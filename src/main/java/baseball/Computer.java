package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import jdk.jfr.internal.tool.Main;

// 범위 입력해야된다
import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    private static final int numberLength = 3;
    private final String strike = "스트라이크";
    private final String ball = "볼";
    private List<Integer> computerRandomNumbers;

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

    public void customComputerRandomNumber(int[] input){
        computerRandomNumbers.clear();
        for(int i : input){
            computerRandomNumbers.add(i);
        }
    }



    // 입력을 검사하는 기능
    public List<Integer> takeUserInput(String userInput){
        List<Integer> splitUserInput = new ArrayList<>();
        try{
            // 숫자인가?
            // 파싱을 하면서 원소가 0이면 버리게 한다 -> filter
            splitUserInput = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).filter(value ->value!=0).boxed().distinct().collect(Collectors.toList());

            // 길이가 3인가?
            if(splitUserInput.size() !=3){
                throw new IllegalArgumentException(splitUserInput+" 길이가 3이 아닙니다");
            }

        }catch (NumberFormatException e) { // 커스텀
            throw new IllegalArgumentException("숫자가 아닌 것이 있습니다.");
        }
//        catch (IllegalArgumentException e){
//            e.printStackTrace(); // 이거 하면 안된다, 결과가 나온 이후에 종료된다
//        }

        return splitUserInput;
    }



    // 볼, 스트라이크, 낫싱 게산후 결과 반환
    public Map<String, Integer> userInputResult(List<Integer> stringMapToInteger){
        Map<String, Integer> result = new HashMap<>();

        for(int i = 0; i<numberLength; i++){
            if(stringMapToInteger.get(i).equals(computerRandomNumbers.get(i))){
                result.put(strike, result.getOrDefault(strike,0)+1);
            }else if(computerRandomNumbers.contains(stringMapToInteger.get(i))){
                result.put(ball, result.getOrDefault(ball,0)+1);
            }
        }

        return result;
    }

    public void exitOrRestart(){
        //

    }


    public String calculate(String userInput){
        // 여기서 에러 뱉으면 게임 종료해야된다
        // 종료하고 다시 시작도 만들어야된다
        List<Integer> stringMapToInteger = takeUserInput(userInput);

        Map<String, Integer> strikeBallResult = userInputResult(stringMapToInteger);

        if(strikeBallResult.isEmpty()){
            return "낫싱";
        }

        Set<String> resultKeys = strikeBallResult.keySet();
        List<String> keys = new ArrayList<>(resultKeys);
        keys.sort((a,b) -> a.length() - b.length()); // 볼 , 스트라이크 순으로 정렬

        ArrayList<String> arrange = new ArrayList<>();
        for(String key : keys){
            Integer value = strikeBallResult.get(key);
            String resultEle = value+key;
            arrange.add(resultEle);
        }

        String result = String.join(" ", arrange);
        StringBuilder sb = new StringBuilder(result);

        if(result.equals("3스트라이크")){
            sb.append("\n"+"3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        // 게임 종료시 처리 로직 필요
        return sb.toString();
    }


    // input 처리
//    public String run(){
//
//        return "";
//    }







}
