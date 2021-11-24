package baseball.number;

public class NumberService {

    public static boolean isBaseballNumber(int[] num) {
        if(checkOverlappedNum(num)){
            return true;
        }
        return false;
    }

    private static boolean checkOverlappedNum(int[] num) {
        if(num[0] == num[1]
                || num[1] == num[2]
                || num[0] == num[2]) {
            return false;
        }
        return true;
    }

//    private static boolean isNotZero(int[] num) {
//        if(num[0] == 0
//                || num[1] == 0
//                || num[0] == 0) {
//            return false;
//        }
//        return checkOverlappedNum(num);
//    }

//    private static boolean checkLength(int[] num) {
//        if(num.length != 3){
//            return false;
//        }
//        return checkOverlappedNum(num);
//    }
}
