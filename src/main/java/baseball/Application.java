package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현


    }

    // 입력받은 수를 String 에서 int array 로 저장
    public static int[] stringToInt(String inputNumber) {
        int[] userNumber = new int[3];

        for(int i=0; i<3; i++) {
            userNumber[i] = Character.getNumericValue(inputNumber.charAt(i));
        }

        return userNumber;
    }
}