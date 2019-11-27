import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private final int USER_NUMBER_SIZE = 3;
    private final int DIVIDE_BAT_VALUE = 10;

    public int[] getUserBat() {
        displayGetUserBat();
        int[] userBaseballBat;

        while(true) {
            try {
                userBaseballBat = userBatArray(checkUserBat());
                break;
            } catch (Exception e) {
                System.out.println("서로 다른 1 ~ 9 까지의 숫자를 입력해주세요");
            }
        }

        return userBaseballBat;
    }

    private void displayGetUserBat() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private int[] userBatArray(List<Integer> userBats) {
        int[] userBatArray = new int[USER_NUMBER_SIZE];

        for(int i=0; i<userBats.size(); i++) {
            userBatArray[i] = userBats.get(i);
        }

        return userBatArray;
    }

    private List<Integer> checkUserBat() throws NumberFormatException {
        Scanner scanUserBat = new Scanner(System.in);
        String userBatValue = scanUserBat.next();
        int userBat = Integer.parseInt(userBatValue);

        if(userBatValue.length() != 3) { throw new NumberFormatException(); }

        return checkSameBat(userBat);
    }

    private List<Integer> checkSameBat(int userBat) {
        int refactorBat = userBat;
        List<Integer> userBats = new ArrayList<>();

        for(int i=2; i>=0; i--) {
            int temp = refactorBat/(int) (Math.pow(DIVIDE_BAT_VALUE,i));
            checkUnsatisfactBat(userBats, temp);
            userBats.add(temp);
            refactorBat = refactorBat % (int) (Math.pow(DIVIDE_BAT_VALUE,i));
        }

        return userBats;
    }

    private void checkUnsatisfactBat(List<Integer> userBats, int temp) {
        if(temp < 1 || temp > 9) { throw new NumberFormatException(); }
        if (userBats.contains(temp)) { throw new NumberFormatException(); }
    }
}
