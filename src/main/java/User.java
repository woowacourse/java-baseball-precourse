import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private final int DIVIDE_BAT_VALUE = 10;
    private final int FIRST_BALL = 2;
    private final int LAST_BALL = 0;
    private final int MIN_BASEBALL_NUMBER = 1;
    private final int MAX_BASEBALL_NUMBER = 9;
    private final int USER_BAT_SIZE = 3;

    public List<Integer> getUserBat() {
        List<Integer> userBaseballBat;
        displayGetUserBat();

        while(true) {
            try {
                userBaseballBat = getUserBats();
                break;
            } catch (Exception e) {
                System.out.println("서로 다른 1 ~ 9 까지의 숫자 3개를 입력해주세요");
            }
        }

        return userBaseballBat;
    }

    private void displayGetUserBat() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private List<Integer> getUserBats() throws NumberFormatException {
        Scanner scanUserBat = new Scanner(System.in);
        String userBatValue = scanUserBat.next();
        int userBat = Integer.parseInt(userBatValue);

        if(userBatValue.length() != USER_BAT_SIZE) {
            throw new NumberFormatException();
        }

        return checkUserBats(userBat);
    }

    private List<Integer> checkUserBats(int userBat) {
        int batValue = userBat;
        List<Integer> userBats = new ArrayList<>();

        for(int i = FIRST_BALL; i >= LAST_BALL; i--) {
            int bat = batValue/(int) (Math.pow(DIVIDE_BAT_VALUE,i));
            checkIncorrectUserBat(userBats, bat);
            batValue = batValue % (int) (Math.pow(DIVIDE_BAT_VALUE,i));
        }

        return userBats;
    }

    private void checkIncorrectUserBat(List<Integer> userBats, int bat) {
        if(bat < MIN_BASEBALL_NUMBER || bat > MAX_BASEBALL_NUMBER) {
            throw new NumberFormatException();
        }

        if (userBats.contains(bat)) {
            throw new NumberFormatException();
        }

        userBats.add(bat);
    }
}
