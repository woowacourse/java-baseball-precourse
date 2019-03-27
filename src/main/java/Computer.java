import java.util.Random;

public class Computer {
    private int[] number;
    private  boolean[] check_number;

    int[] get_number(){
        return number;
    }

    boolean[] get_check_number(){
        return check_number;
    }

    /**
     * f, s, t 각각의 숫자 중에 같은것이 있으면 true, 아니면 false 리턴한다.
     */
    boolean check_same(int f, int s, int t){
        return !((f !=  s) && (f != t) && (s != t));
    }

    /**
     * 컴퓨터가 만든 각 자리의 숫자들이 어떤 수 인지 체크한다.
     */
    void make_check_number(){
        check_number = new boolean[10];
        for(int i=0; i<3; i++){
            check_number[number[i]] = true;
        }
    }

    /**
     * 각 자리가 1~9이면서 같지 않은 3자리 숫자를 배열에 저장한다.
     */
    void make_number() {
        Random generator = new Random();
        int first, second, third;

        while (true){
            first = generator.nextInt(9) + 1;
            second = generator.nextInt(9) + 1;
            third = generator.nextInt(9) + 1;

            if (!check_same(first, second, third)) {
                break;
            }
        }

        number = new int[]{first, second, third};
    }
}
