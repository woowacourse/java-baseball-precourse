import java.util.Scanner;

public class BaseballGame {
    public Scanner sc;
    private String ballNumbers;
    private String inputNumbers;
    private int[] hint;

    public BaseballGame() {
        sc = new Scanner(System.in);
        System.out.println("1부터 9까지 서로 다른 수로 이루어진 3자리 숫자를 맞춰주세요.\n");
        String msg = "<게임규칙>\n";
        msg += "3자리 수를 정확히 맞추면 성공!\n";
        msg += "실패 시, 같은 수가 같은 자리에 있으면 스트라이크\n";
        msg += "같은 수가 다른 자리에 있으면 볼\n";
        msg += "같은 수가 전혀 없으면 낫싱이라는 힌트가 제공됩니다.\n";
        System.out.println(msg);
    }

    public void start() {
        ballNumbers = makeNumbers();
        inputNumbers = inputNumbers();
        while (!checkSuccess()) {
            hint = calHint();
            printResult(hint);
            inputNumbers = inputNumbers();
        }
        printResult();
    }

    public String makeNumbers() {
        String numbers = "";

        while (numbers.length() < 3) {
            int temp = (int) Math.floor(Math.random() * 10);
            if ((temp != 0) && !numbers.contains(String.valueOf(temp))) {
                numbers += temp;
            }
        }
        return numbers;
    }

    public String inputNumbers() {
        System.out.println("3자리 숫자를 입력해주세요. ex) 123    ");
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
        }catch (NumberFormatException e) {
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
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printResult(int[] hint) {
        int strike = hint[0];
        int ball = hint[1];
        String msg = "힌트: ";

        if ((strike == 0) && (ball == 0)) {
            msg += "낫싱";
        } else {
            if (strike != 0) {
                msg += strike + "스트라이크 ";
            }
            if (ball != 0) {
                msg += ball + "볼";
            }
        }
        System.out.println(msg + "\n");
    }

    public boolean askReplay() {
        String replay = sc.nextLine();

        while (!(replay.equals("1") || replay.equals("2"))) {
            System.out.println("입력 형식이 잘못되었습니다.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replay = sc.nextLine();
        }
        return replay.equals("1");
    }

    public void closeScanner() {
        if (sc != null) {
            sc.close();
        }
    }
}