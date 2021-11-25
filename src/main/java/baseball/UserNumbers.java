package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserNumbers {
    public static ArrayList<Integer> UserNumbers() {
        ArrayList<Integer> userNumbers = new ArrayList<Integer>();
        String tmpUserNumbers = Console.readLine();

        // String 쪼개서 ArrayList에 넣기
        List<String> userNumbersString = Arrays.asList(tmpUserNumbers.split(""));

        //String -> int 변환
        for (int i = 0; i < userNumbersString.size(); i++){
            userNumbers.add(Integer.parseInt(userNumbersString.get(i)));
        }

        // int test
        for (int i = 0; i < userNumbers.size(); i++)
            System.out.println((userNumbers.get(i).getClass().getName()));

        return userNumbers;
    }
}
