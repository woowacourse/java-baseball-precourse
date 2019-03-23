public class Oracle {

    boolean checkStrike(String createdNumber, String inputNumber, int seat) {
        char c;
        char i;

        c = createdNumber.charAt(seat);
        i = inputNumber.charAt(seat);

        if (c == i)
            return true;
        else
            return false;
    }

    boolean checkBall(String createdNumber, String inputNumber, int seat) {
        char number = inputNumber.charAt(seat);
        boolean flag = false;

        for(int i = 0; i < createdNumber.length(); i++) {
            if (createdNumber.charAt(i) == number && i != seat) {
                flag = true;
            }
        }

        return flag;
    }

}
