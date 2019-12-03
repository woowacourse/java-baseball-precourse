import java.util.Scanner;

public class BaseballGame {
    public BaseballGame() {
    }

    public static void start(Scanner sc) {
        String answer = makeNumbers();
//        System.out.println("정답: " + answer);
        String input = inputNumbers(sc);
//        System.out.println("입력값: " + input);
        boolean success = checkSuccess(answer, input);
        while (!success) {
            int[] result = calHint(answer, input);
            printResult(result);
            input = inputNumbers(sc);
            success = checkSuccess(answer, input);
        }
        printResult(new int[]{3, 0});
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

    public static String inputNumbers(Scanner sc) {
        String inputNumbers = "";

        while (inputNumbers.equals("")) {
            inputNumbers = sc.nextLine();
            inputNumbers = validate(inputNumbers);
//            System.out.println("수정된 입력값: " + inputNumbers);
        }
        return inputNumbers;
    }

    public static String validate(String numbers) {

        /* 입력받은 값이 숫자인지 확인*/
        try{
            Integer.parseInt(numbers);
        }catch (Exception e) {
            System.out.println("입력 형식이 잘못되었습니다. 다시 입력해주세요.");
            System.out.println("(입력 형식) 3자리 숫자 / ex. 123");
            return "";
        }

        /* 입력받은 숫자의 자리수 확인*/
        if (numbers.length() != 3) {
            System.out.println("입력 형식이 잘못되었습니다. 다시 입력해주세요.");
            System.out.println("(입력 형식) 3자리 숫자 / ex. 123");
            return "";
        }else{
            return numbers;
        }
    }

    public static boolean checkSuccess(String ballNumbers, String inputNumbers) {
        if (ballNumbers.equals(inputNumbers)) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] calHint(String ballNumbers, String inputNumbers) {
        int[] result = {0, 0};      //strike, ball 순으로 힌트를 담은 배열

        for (int i = 0; i < 3; i++) {
            char temp = inputNumbers.charAt(i);

            /* strike  개수 계산 */
            if (ballNumbers.charAt(i) == temp) {
                result[0]++;
                result[1]--;
            }

            /* ball 개수 계산*/
            if (ballNumbers.indexOf(temp) != -1) {
                result[1]++;
            }
        }
        return result;
    }

    public static void printResult(int[] result) {
        int strike = result[0];
        int ball = result[1];
        String msg = "";

        if ((strike == 3) && (ball == 0)) {         //3스트라이크, 0볼인 경우 정답
            msg = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
            msg += "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        } else if ((strike == 0) && (ball == 0)) {
            msg = "낫싱";
        } else {
            if (strike != 0) {
                msg += strike + "스트라이크 ";
            }
            if (ball != 0) {
                msg += ball + "볼";
            }
        }
        System.out.println(msg);
    }

    public static String askReplay(Scanner sc) {
        String re = sc.nextLine();

        while (!(re.equals("1") || re.equals("2"))) {
            System.out.println("입력 형식이 잘못되었습니다.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            re = sc.nextLine();
        }
        return re;
    }
}