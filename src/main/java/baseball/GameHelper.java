package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
        compare(inputString, generateNumbers);
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

    public static void compare(String inputString, List<Integer> generateNumber){
        List<Integer> parsedInputList = parseStringToList(inputString);
        int[] inputArray = getArray(parsedInputList);
        int[] generateArray = getArray(generateNumber);

        int strikes =0;
        int balls =0;
        for(int i=0; i<10; i++){
            if(inputArray[i]!=-1 && generateArray[i]!=-1){
                if(inputArray[i]==generateArray[i]){
                    strikes++;
                    continue;
                }
                balls++;
            }
        }
        return;
    };

    public static List<Integer> parseStringToList(String inputString){
        String[] parsedArray = inputString.split("");
        List<String> parsedList = new ArrayList<String>(Arrays.asList(parsedArray));
        IntStream parsedStream  = parsedList.stream().mapToInt(num->Integer.parseInt(num));
        List<Integer> parsedIntList = parsedStream.boxed().collect(Collectors.toList());
        return parsedIntList;
    };

    private static int[] getArray(List<Integer> inputList) {
        int resultArray[]=new int[10];
        Arrays.fill(resultArray, -1);
        IntStream.range(0,3).forEach(idx->resultArray[inputList.get(idx)] = idx);
        return resultArray;
    };
}
