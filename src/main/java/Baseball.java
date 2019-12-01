/*
 * @(#)Main.java        2019-12-01
 *
 * [저작권 및 라이센스 관련 정보를 여기에 작성한다.]
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @version         1.01 2019-12-01
 * @author          최근휘
 */
public class Baseball {

    /** 플레이어의 임의의 3개의 수 */
    private String playersNums;
    /** 컴퓨터의 임의의 3개의 수 */
    private String computersNums;

    /**
     * 생성자 Baseball()
     */
    public Baseball() {
        /* Empty */
    }

    public String getPlayersNums() {
        return playersNums;
    }

    public String getComputersNums() {
        return computersNums;
    }

    /**
     * @param threeNumString 1~9까지의 수 3개로 이루어져 있는 문자열
     */
    public void setPlayersNum(String threeNumString) {
        playersNums = threeNumString;
    }

    /**
     * 컴퓨터의 3개의 숫자를 임의로 설정
     */
    public void setComputersNum() {
        computersNums = makeThreeNum();
    }

    /**
     * @return 1~9까지의 수 3개로 이루어져 있는 문자열을 임의로 생성하여 반환
     */
    private String makeThreeNum() {
        StringBuilder orderedNums = createOrderedNums();
        StringBuilder shuffledNums = shuffle(orderedNums);

        return shuffledNums.substring(0, 3);
    }

    /**
     * @return 123 ... 789의 문자열
     */
    private StringBuilder createOrderedNums() {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            answer.append(Integer.toString(i + 1));
        }

        return answer;
    }

    /**
     * @param orderedNums 123 ... 789의 문자열
     * @return orderedNums의 순서를 뒤섞은 문자열
     */
    private StringBuilder shuffle(StringBuilder orderedNums) {
        StringBuilder answer = new StringBuilder();
        long seed = System.nanoTime();
        List<Character> list = stringBuilderToList(orderedNums.toString());

        Collections.shuffle(list, new Random(seed));
        for (Character element: list) {
            answer.append(element);
        }

        return answer;
    }

    /**
     * @param string 리스트로 변환할 문자열
     * @return 변환된 리스트
     */
    private List<Character> stringBuilderToList(String string) {
        List<Character> list = new ArrayList<Character>();
        for (Character element: string.toCharArray()) {
            list.add(element);
        }

        return list;
    }
}







































