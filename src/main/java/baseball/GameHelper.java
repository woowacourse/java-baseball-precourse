package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameHelper {

    public static List<Integer> generateNumbers(){
        List<Integer> numberList = new ArrayList<Integer>();
        while(true){
            numberList.add(Randoms.pickNumberInRange(1,9));
            if(numberList.size()==3){
                break;
            }
        }
        return numberList;
    };

    public static void play(List<Integer> generateNumbers){
        String inputString = getUserInput();
        return;
    };

    public static String getUserInput(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        inputCheck(inputString);
        return inputString;
    };

    private static void inputCheck(String inputString) {
        if(inputString.length()!=3){
            throw new IllegalArgumentException("길이가 3이어야합니다.");
        }
        IntStream
            .range(0,inputString.length())
            .forEach(index -> {
                if(!Character.isDigit(inputString.charAt(index))){
                    throw new IllegalArgumentException("숫자를 입력해주세요.");
                }
            });
    };

}
