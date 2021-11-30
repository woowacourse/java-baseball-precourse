package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.SystemMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static List<Integer> parseStringToList(String inputString){
        String[] parsedArray = inputString.split("");
        List<String> parsedList = new ArrayList<String>(Arrays.asList(parsedArray));
        IntStream parsedStream  = parsedList.stream().mapToInt(num->Integer.parseInt(num));
        List<Integer> parsedIntList = parsedStream.boxed().collect(Collectors.toList());
        return parsedIntList;
    };

    public static int[] getArray(List<Integer> inputList) {
        int resultArray[]=new int[10];
        Arrays.fill(resultArray, -1);
        IntStream.range(0,3).forEach(idx->resultArray[inputList.get(idx)] = idx);
        return resultArray;
    };

    public static int[] compareTwoArray(int[] inputArray, int[] generateArray){
        int strikes =0;
        int balls =0;
        for(int i=0; i<10; i++){
            if(inputArray[i]==-1 || generateArray[i]==-1){
                continue;
            }
            if(inputArray[i]==generateArray[i]){
                strikes++;
                continue;
            }
            balls++;
        }
        int[] compareResult = {strikes, balls};
        return compareResult;
    }
}
