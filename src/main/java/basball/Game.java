/*
 * Game
 *
 * version 1.0.0
 *
 * 2019-12-03
 *
 */

package basball;

import java.util.*;


/**
 * 숫자야구를 진행하는 Game 클래스
 * @author eaTnuG
 * @version 1.0.0
 * @since 2019-12-03
 */
public class Game {

    /** 유저의 (추측)입력 값이 지정된 길이 LENGTH와 다를 때 발생하는 에러 */
    private static class InputLengthException extends RuntimeException {};

    /** 유저의 입력이 숫자가 아닐 때 발생하는 에러 */
    private static class InputNaNException extends RuntimeException {};

    /** 컴퓨터가 뽑는 임의의 숫자배열인 target에 뽑힐 수 있는 0~9 까지의 정수들(자료형은 문자열)의 배열 */
    private static final String[] DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    /** 컴퓨터가 뽑는 임의의 숫자배열인 target의 길이. 현재는 3 */
    private static final int LENGTH = 3;
    private static final int ZERO = 0;

    /** 재시작 여부를 입력받을때, 재시작을 선택하는 사용자 입력. 1 */
    private static final String RESTART = "1";

    /** 사용자의 추측 결과를 나타내는 Hashmap 객체에서 strike 개수의 키 값 */
    private static final String STRIKE = "strike";

    /** 사용자의 추측 결과를 나타내는 Hashmap 객체에서 ball 개수의 값 */
    private static final String BALL = "ball";

    /** 사용자 입력을 받기위한 Scanner 객체 */
    private static Scanner SCANNER = new Scanner(System.in);

    /** 임의의 수를 선택하기 위한 Random 객체 */
    private static Random RANDOM = new Random();

    /** 현재 게임이 진행 중 인지 알려주는 플래그. 사용자가 추측에 성공하면 false가 된다. */
    private static Boolean playing = true;

    /** 컴퓨터가 뽑는 임의의 숫자배열(자료형은 문자열) */
    private static String target;

    /**
     * Game 클래스의 생성자.
     * init 메소드 실행
     */
    public Game() {
        init();
    }

    /**
     * 초기화하는 메소드
     * 정답이 될 임의의 문자열을 뽑고, playing 플래그를 true로 설정한다.
     */
    private void init() {
        target = createAnswerString();
        playing = true;
    }

    /**
     * 임의의 문자열을 생성하는 함수
     * 0~9 중 에서 하나를 뽑은 후 해당 값을 제외한 값들 중에서 다시 뽑는 방식으로 중복을 제거했다.
     * @return 임의의 중복되지 않는 세자릿수 숫자의 값을 갖는 문자열
     */
    private String createAnswerString() {
        String first = pickDigitExcept();
        String second = pickDigitExcept(first);
        String third = pickDigitExcept(first, second);
        return first + second + third;
    }

    /**
     * 0~9 중의 숫자들에서 특저한 값을 제외하고 나머지 숫자들 중에서 임의의 숫자를 반환하는 함수
     * @param except 제외할 값
     * @return 길이 1짜리 임의의 정수 값을 갖는 문자열
     */
    private String pickDigitExcept(String... except) {
        String[] pool = DIGITS;
        if (except != null) {
            pool = newDigitPoolExcept(except);
        }
        String pick = pool[RANDOM.nextInt(pool.length)];
        return pick;
    }

    /**
     * 0~9 중의 숫자들 중에서 특정한 값을 제외한 배열을 반환하는 함수
     * @param except 제외할 값
     * @return 0~9 중 특정한 값이 제외된 배열
     */
    private String[] newDigitPoolExcept (String[] except) {
        List<String> newPool = new ArrayList<>();
        for (String digit : DIGITS) {
            if (!Arrays.asList(except).contains(digit)) {
                newPool.add(digit);
            }
        }
        return newPool.toArray(new String[newPool.size()]);
    }

    /**
     * 턴을 진행하는 메소드.
     * 매 턴마다 다음 턴을 진행할지 여부를 확인하는 gameOn 메소드를 호출한다.
     */
    public void start() {
        while (gameOn()) {
            proceedTurn();
        }
    }

    /**
     * 다음 턴을 진행할지 여부를 확인하는 gameOn 메소드
     * playing 플래그를 확인하고 true라면 true를 리턴한다.
     * false라면 재시작 여부를 확인하는 restart 메소드를 호출한다.
     * @return 다음 턴을 진행 여부
     */
    private Boolean gameOn() {
        if (playing) {
            return true;
        }
        return restart();
    }

    /**
     * 재시작 여부를 확인하는 메소드.
     * @return 재시작 여부
     */
    private Boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String choice = SCANNER.nextLine();
        if (choice.equals(RESTART)) {
            init();
            return true;
        }
        return false;
    }

    /**
     * 턴을 진행하는 메소드
     * 사용자의 입력을 받고, 이를 평가하고, 출력한다.
     * 에러가 발생하면 이를 핸들링한다.
     */
    private void proceedTurn () {
        try {
            String guess = getUserGuess();
            HashMap<String, Integer> result = evaluateGuess(guess);
            printResult(result);
        } catch (RuntimeException e) {
            hanndleError(e);
        }
    }

    /**
     * 사용자 입력을 받고 이를 validate 한 후 반환하는 메소드
     * @return 사용자 입력
     * @throws RuntimeException
     */
    private String getUserGuess() throws RuntimeException {
        System.out.print("숫자를 입력해주세요: ");
        String input = SCANNER.nextLine();
        validateGuess(input);
        return input;
    }

    /**
     * 사용자 입력을 validate하고 만약 정해진 포맷을 벗어나면 에러를 발생시키는 함수
     * @param guess 사용자의 입력값
     */
    private void validateGuess(String guess) {
        if (notFit(guess)) throw new InputLengthException();
        else if (NaN(guess)) throw new InputNaNException();
    }

    /**
     * 입력값의 길이와 시스템에서 정해둔 길이를 비교하는 함수
     * @param string 사용자 입력 값
     * @return 일치 여부 부울 값
     */
    private Boolean notFit(String string) {
        if (string.length() != LENGTH) {
            return true;
        }
        return false;
    }

    /**
     * 입력값이 숫자인지 확인하는 함수
     * @param string 사용자 입력 값
     * @return 입력값이 숫자인지 여부 부울 값
     */
    private Boolean NaN(String string) {
        try {
            Integer.parseInt(string);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /**
     * 사용자 입력값을 평가하는 메소드
     * @param guess 사용자 입력값
     * @return 사용자 입력의 평가결과를 나타내는 Hashmap 객체. strike와 ball이라는 키를 갖는다.
     */
    private HashMap<String, Integer> evaluateGuess(String guess) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put(STRIKE, countStrike(guess));
        result.put(BALL, countBall(guess));
        return result;
    }

    /**
     * strike 수를 세는 메소드.
     * 사용자 입력과 목표값의 문자를 비교해 자리와 값이 같으면 strikeCount를 1 증가시킨다.
     * 만약 3스트라이크라면 값을 맞춘 것이므로 playing 플래그를 false로 바꾼다.
     * @param guess 사용자 입력값
     * @return strike 수
     */
    private int countStrike(String guess) {
        int strikeCount = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                strikeCount++;
            }
        }
        if (strikeCount == LENGTH) {
            playing = false;
        }
        return strikeCount;
    }

    /**
     * ball 수를 세는 메소드
     * 사용자 입력과 목표값의 문자를 비교해 자리는 다르고 해당 값이 포함되어있다면 ballCount를 1 증가시킨다.
     * @param guess 사용자 입력값
     * @return ball 수
     */
    private int countBall(String guess) {
        int ballCount = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (guess.charAt(i) != target.charAt(i) && target.contains(String.valueOf(guess.charAt(i)))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    /**
     * 사용자 추측을 평가한 값을 출력하는 함수.
     * @param result 평가 결과를 담고 있는 Hashmap 객체
     */
    private void printResult(HashMap<String, Integer> result) {
        int strikeCount = result.get(STRIKE);
        int ballCount = result.get(BALL);
        System.out.println(makeResultMessage(strikeCount, ballCount));
    }

    /**
     * 출력할 결과 메시지를 만드는 함수
     * 스트라이크, 볼 별로 결과 메시지를 만들고 이 둘을 더해서 반환하는 함수.
     * @param strikeCount 스트라이크 개수
     * @param ballCount 볼 개수
     * @return 결과 메시지
     */
    private String makeResultMessage(int strikeCount, int ballCount) {
        String strikeMessage = makeStrikeMessage(strikeCount);
        String ballMessage = makeBallMessage(ballCount);

        if (strikeCount == ZERO && ballCount == ZERO) {
            return " 낫싱 ";
        }
        return strikeMessage + ballMessage;
    }

    /**
     * 스트라이크 개수에 따른 결과 메시지를 만드는 함수
     * @param strikeCount 스트라이크 개수
     * @return 스트라이크 결과 메시지
     */
    private String makeStrikeMessage(int strikeCount){
        if (strikeCount != ZERO){
            return String.format(" %d 스트라이크", strikeCount);
        }
        return "";
    }

    /**
     * 볼 개수에 따른 결과 메시지를 만드는 함수
     * @param ballCount 볼 개수
     * @return 볼 결과 메시지
     */
    private String makeBallMessage(int ballCount){
        if (ballCount != ZERO){
            return String.format(" %d 볼", ballCount);
        }
        return "";
    }

    /**
     * 에러를 핸들링하는 메소드.
     * 각 에러별로 메시지를 출력한다.
     * @param e 에러객체
     */
    private void hanndleError(RuntimeException e) {
        if (e instanceof InputNaNException) {
            System.err.println("입력이 숫자가 아닙니다.");
        }
        else if (e instanceof InputLengthException) {
            System.err.println(String.format("입력의 길이가 %d이 아닙니다", LENGTH));
        }
        else {
            System.err.println("예상치 못한 오류입니다.");
        }

    }
}
