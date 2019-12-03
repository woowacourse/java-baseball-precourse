import java.util.Scanner;

public class BaseballGame {
    private String ballNumbers;
    private String inputNumbers;
    private int[] hint;

    public BaseballGame() {
    }

    public void start(Scanner sc) {
        ballNumbers = makeNumbers();
//        System.out.println("정답: " + answer);
        inputNumbers = inputNumbers(sc);
//        System.out.println("입력값: " + input);
        while (!checkSuccess()) {
            hint = calHint();
            printResult(hint);
            inputNumbers = inputNumbers(sc);
        }
        printResult();
    }

    public String makeNumbers() {
        String numbers = "";
        int temp;

        while (numbers.length() < 3) {
            temp = (int) Math.floor(Math.random() * 10);
            if ((temp != 0) && !numbers.contains(String.valueOf(temp))) {
                numbers += temp;
            }
        }
        return numbers;
    }

    public String inputNumbers(Scanner sc) {
        String numbers = sc.nextLine();

        while (!validate(numbers)){
            numbers = sc.nextLine();
        }
        return numbers;
    }

    public boolean validate(String numbers) {

        /* 입력받은 값이 숫자인지 확인*/
        try{
            Integer.parseInt(numbers);
        }catch (Exception e) {
            System.out.println("입력 형식이 잘못되었습니다. 다시 입력해주세요.");
            System.out.println("(입력 형식) 3자리 숫자 / ex. 123");
            return false;
        }

        /* 입력받은 숫자의 자리수 확인*/
        if (numbers.length() != 3) {
            System.out.println("입력 형식이 잘못되었습니다. 다시 입력해주세요.");
            System.out.println("(입력 형식) 3자리 숫자 / ex. 123");
            return false;
        }else{
            return true;
        }
    }

    public boolean checkSuccess() {
        return ballNumbers.equals(inputNumbers);
    }

    public int[] calHint() {
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

    public void printResult() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printResult(int[] hint) {
        int strike = hint[0];
        int ball = hint[1];
        String msg = "";

        if ((strike == 0) && (ball == 0)) {
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

    public String askReplay(Scanner sc) {
        String replay = sc.nextLine();

        while (!(replay.equals("1") || replay.equals("2"))) {
            System.out.println("입력 형식이 잘못되었습니다.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replay = sc.nextLine();
        }
        return replay;
    }
}