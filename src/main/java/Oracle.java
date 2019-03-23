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

}
