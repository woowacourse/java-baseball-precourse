package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> userNumbers = makeList(input);
        System.out.println(input);
    }

    public static List<Integer> makeList(String input) {
        String[] arrayInput = input.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for (int i=0; i<input.length();i++) {
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }


}
