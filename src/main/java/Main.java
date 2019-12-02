public class Main {

    public static void main(String[] args) {
        String answer = makeNumbers();
//        System.out.println("정답: " + answer);
    }

    public static String makeNumbers() {
        String ballNumbers = "";
        int temp;

        while (ballNumbers.length() < 3) {
            temp = (int) Math.floor(Math.random() * 10);
            if ((temp != 0) && !ballNumbers.contains(String.valueOf(temp))) {
                ballNumbers += temp;
            }
        }
        return ballNumbers;
    }
}
