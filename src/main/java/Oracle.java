public class Oracle {

    static boolean checkStrike(String createdNumber, String inputNumber, int seat) {
        char c;
        char i;

        c = createdNumber.charAt(seat);
        i = inputNumber.charAt(seat);

        if (c == i)
            return true;
        else
            return false;
    }

    static boolean checkBall(String createdNumber, String inputNumber, int seat) {
        char number = inputNumber.charAt(seat);
        boolean flag = false;

        for(int i = 0; i < createdNumber.length(); i++) {
            if (createdNumber.charAt(i) == number && i != seat) {
                flag = true;
            }
        }

        return flag;
    }

    static int examines(String createdNumber, String inputNumber, int seat) {
        if (checkStrike(createdNumber, inputNumber, seat))
            return 1;
        else if (checkBall(createdNumber, inputNumber, seat))
            return 2;
        else
            return 0;
    }

    static Result tells(String createdNumber, String inputNumber) {
        Result result = new Result();
        int temp;

        for(int i = 0; i < 3; i ++) {
            temp = examines(createdNumber, inputNumber, i);
            if (temp == 1)
                result.strike++;
            else if(temp == 2)
                result.ball++;
        }

        return result;
    }

}
