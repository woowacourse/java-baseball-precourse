import java.util.*;

class Divider {
    static ArrayList<Integer> divide(int number) { // 정수값을 각 자릿값으로 나누어 ArrayList형태로 변환해주는 함수.
        ArrayList<Integer> ret = new ArrayList<Integer>();

        ret.add(number/100);
        number -= (number/100) * 100;
        ret.add(number/10);
        number -= (number/10) * 10;
        ret.add(number);

        return ret;
    }
}