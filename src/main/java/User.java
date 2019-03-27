public class User {
    private int[] number;

    int[] get_number(){
        return number;
    }

    /**
     * 사용자가 숫자를 입력하면 각 자리의 숫자를 배열에 저장한다.
     */
    void input_number(int num){
        number = new int[3];
        for(int i=2; i>=0; i--){
            number[i] = num % 10;
            num /= 10;
        }
    }
}
