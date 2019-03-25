import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 숫자야구게임을 진행하는 클래스
 */
public class BaseballGame {
    /**
     * @param strike 스트라이크 수
     * @param ball   볼 수
     * @param answer 정답을 저장하기 위한 리스트
     * @param input  입력받은 숫자를 저장하기 위한 리스트
     */
    private int strike;
    private int ball;

    private List<Integer> answer;
    private List<Integer> input;

    private Random random;
    private Scanner scanner;

    public BaseballGame() {
    }

    /**
     * 필드를 초기화하기 위한 메소드
     */
    public void init() {
        answer = new ArrayList<>(3);
        input = new ArrayList<>(3);
        random = new Random();
        scanner = new Scanner(System.in);
        strike = 0;
        ball = 0;
    }

    /**
     * 입력을 받으며 게임을 진행시키는 메소드
     */
    public void start() {
        String inputStr;
        boolean isCorrect = false;                      /* 정답을 맞추면 True, 맞추기 전까지는 False로 While문에 사용 */

        setAnswer();                                    /* 난수 생성 */

        while (!isCorrect) {
            strike = 0;
            ball = 0;
            input.clear();

            System.out.print("숫자를 입력해주세요 : ");
            inputStr = scanner.next();
            scanner.nextLine();
            if (!checkInput(inputStr))                  /* 입력 받은 값에 대한 범위와 포맷에 대한 처리 */
                continue;
            if (!addInputToArray(inputStr))             /* 리스트에 입력 받은 값 추가 */
                continue;

            checkCount();                               /* 스트라이크와 볼 판정 */

            if (strike == 3)                            /* 3스트라이크 일 경우 종료 */
                isCorrect = true;
        }
    }

    /**
     * 게임이 종료되고 다시 시작 여부를 물어보는 메소드
     *
     * @return 다시 시작 하려면 True, 종료를 원하거나 잘못된 값을 입력했을 경우 False를 반환
     */
    public boolean reset() {
        String inputStr;

        answer.clear();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        inputStr = scanner.next();
        scanner.nextLine();
        if (inputStr.equals("1")) {
            System.out.println("다시 시작합니다.");
            return true;
        } else if (inputStr.equals("2")) {
            System.out.println("종료합니다.");
            return false;
        } else {
            System.out.println("잘못된 입력입니다. 종료합니다.");
            return false;
        }
    }

    /**
     * 게임이 완전히 종료된 후 리소스를 닫는 메소드
     */
    public void close() {
        scanner.close();
    }

    /**
     * 컴퓨터의 정답인 3자리 난수를 생성하는 메소드
     */
    private void setAnswer() {
        do {
            int i = random.nextInt(9) + 1;
            if (!answer.contains(i))                    /* 이미 선택된 숫자가 아닐 경우 추가 */
                answer.add(i);
        } while (answer.size() < 3);                    /* 리스트의 크기가 3일 때까지 반복 */
    }

    /**
     * 입력받은 문자열이 세자리의 숫자인지 판별하는 메소드
     *
     * @param inputStr 조건에 맞는 숫자인지 판별할 문자열
     * @return 세자리의 숫자일 경우 True, 세자리가 아닌 숫자이거나 문자가 포함된 경우 False를 반환
     */
    private boolean checkInput(String inputStr) {
        try {
            int i = Integer.parseInt(inputStr);
            if (i < 100 || i >= 1000) {
                System.out.println("잘못된 범위입니다. 다시 입력해주세요.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return false;
        }
    }

    /**
     * 입력받은 문자열에서 중복과 0을 포함하는지 체크하고, 없으면 Input 리스트에 저장하는 메소드
     *
     * @param inputStr 입력받은 숫자를 가진 문자열
     * @return 0이 포함되거나 중복된 숫자가 있으면 False, 그렇지 않으면 True를 반환
     */
    private boolean addInputToArray(String inputStr) {
        int j;

        for (int i = 0; i < 3; i++) {
            j = Integer.parseInt(inputStr.substring(i, i + 1));
            if (j == 0) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                return false;
            }
            if (!input.contains(j))
                input.add(j);
            else {
                System.out.println("중복된 숫자가 존재합니다. 다시 입력해주세요.");
                return false;
            }
        }

        return true;
    }

    /**
     * 스트라이크와 볼, 낫싱을 판정하는 메소드
     */
    private void checkCount() {
        for (int i : input)                                                     /* 입력받은 값을 하나씩 정답 리스트에 존재하는지 검색하고 존재하면 볼을 증가 */
            if (answer.contains(i))
                ball++;

        for (int i = 0; i < answer.size(); i++)                                 /* 자리마다 입력값과 정답을 비교하며 같은 값이면 볼을 감소시키고 스트라이크를 증가 */
            if (answer.get(i) == input.get(i)) {
                ball--;
                strike++;
            }

        if ((strike == 0) && (ball == 0))
            System.out.println("낫싱");
        else if (strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다!! 게임 종료");
        else
            System.out.println(strike + " 스트라이크, " + ball + " 볼");
    }
}
