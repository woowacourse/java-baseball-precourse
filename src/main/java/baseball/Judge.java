package baseball;

public class Judge {
    private static char[] defendNumber;

    private Judge(){}
    public static Judge passNumberToJudge(String number) {
        defendNumber = number.toCharArray();
        System.out.println("passToJudge");
        for (char c : defendNumber) {
            System.out.print(c);
        }
        System.out.println();
        return new Judge();
    }

}
