package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    final static int LENGTH = 3;
    final static int TESTNUM = 10;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        ArrayList<Integer> temp = new ArrayList<>();
        //임의의 숫자 생성 test.
        for(int i = 0; i<TESTNUM; i++) {
            MakeNumber m = new MakeNumber();
            temp = m.GetTarget();
            for (Integer a : temp) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
