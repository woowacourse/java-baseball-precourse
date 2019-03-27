import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Number {
    // 클래스 안에 클래스 holder를 두는 Singleton
    private Number() { hashMap = new HashMap<>(); }
    private static class NumberHolder { public static final Number INSTANCE = new Number();}
    public static Number getInstance() { return NumberHolder.INSTANCE; }

    private HashMap<Integer, Integer> hashMap;

    //컴퓨터 3자리 난수 생성 함수
    public HashMap comNum() {

        if (!hashMap.isEmpty()) hashMap.clear();

        for (int i = 0; i < 3; i++) {
            int num = (int) (Math.random() * 9) + 1;
            if (isOverLap(hashMap, num)) {
                i -= 1;
                continue;
            }
            hashMap.put(i, num);
        }
        return hashMap;
    }

    //컴퓨터 3자리난수 중복처리 함수
    private boolean isOverLap(HashMap hashMap, int num) {
        for (Object data : hashMap.values()) {
            if ((int) data == num) return true;
        }
        return false;
    }

    //playerNum 입력 함수
    public String[] playerNum(BufferedReader br) throws IOException {

        System.out.print("숫자를 입력해 주세요 : ");
        String[] num = br.readLine().split("");
        return Number.getInstance().ExceptionPlayerNum(num);

    }

    // playerNum이 Exception 생길때 예외처리 함수
    private String[] ExceptionPlayerNum(String[] num) {

        if (num.length != 3) {
            System.out.println(ErrorMessage.LENGTH_ERROR.getErrorMessage());
            num[0] = "0";
            return num;
        }

        // 1~9까지의 숫자가 안올경우 예외처리
        for (String data : num) {
            char charData = data.charAt(data.length() - 1);
            if (charData <= 48 || charData >= 58) {
                System.out.println(ErrorMessage.NUMBER_FORMAT_ERROR.getErrorMessage());
                num[0] = "0";
                return num;
            }
        }

        // 중복일경우 예외처리
        if (num[0].equals(num[1]) || num[1].equals(num[2]) || num[0].equals(num[2])) {
            System.out.println(ErrorMessage.OVERLAP_ERROR.getErrorMessage());
            num[0] = "0";
            return num;
        }

        return num;
    }

}
