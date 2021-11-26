package baseball.user;


import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Character.getNumericValue;
import static java.lang.Character.getType;

public class User {
    //유저가 입력한 숫자
    public int[] input = new int[3];

    //입력 받아 input에 저장
    public void getInput() {
        //입력
        String inputs = readLine();

        //3자리 이상을 입력받으면 오류반환
        if (inputs.length() != 3) {
            throw new IllegalArgumentException("3자리 수를 입력하세요");
        }

        //숫자 변환
        int Num = toInt(inputs);
        //숫자를 배열로 변환
        input = intToArray(Num);

        isSame(input);

    }

    //입력값 내에 중복값이 있으면 오류 발생
    private void isSame(int[] array) {
        Set<Integer> set = new HashSet<>();
        //타켓 넘버들을 set에 넣는다
        for (int number : array) {
            set.add(number);
        }
        if (set.size() != array.length) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다");
        }

    }

    // 문자열을 숫자로 바꾸는 함수
    private int toInt(String inputs) {
        int Num;

        try {
            //문자열을 숫자로 바꿔준다
            Num = Integer.parseInt(inputs);
            return Num;
        } catch (Exception e) {
            //숫자가 아닌 값이 들어있으면 오류 반환
            throw new IllegalArgumentException("숫자를 입력하세요");
        }

    }

    //3자리 수를 배열로 만드는 함수
    private int[] intToArray(int Num) {
        int[] intArray = new int[3];
        int n;
        //3자리 수를 10으로 나누면서 그 나머지를 배열의 뒤에서부터 할당
        for (int i = 2; i >= 0; i--) {
            n = Num % 10;
            //0이면 오류 반환
            if (n == 0) {
                throw new IllegalArgumentException("1~9사이의 숫자를 입력하시오");
            }
            intArray[i] = n;
            Num /= 10;
        }

        return intArray;
    }


}
