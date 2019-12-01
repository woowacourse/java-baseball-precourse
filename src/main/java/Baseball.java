import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 * Baseball
 *
 * ver 0.8 - 임의의 수 기능 수정(정렬되지 않도록)
 *
 * 2019.12.02
 */
public class Baseball {
    // Scanner는 한 class에 하나만 있는게 좋다고 해서 class 변수로 추출
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Baseball game = new Baseball();
        game.startGame();
    }

    // 1 ~ 9까지 서로 다른 임의의 수 3자리를 생성 (for-each로 했더니 정렬되어 방식 변경함)
    private String makeAnswer() {
        String answer = "";
        Random rd = new Random();
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 1; i < 10; i++) {
            hs.add(i);
        }
        while (hs.size() > 6) {
            int tmp = rd.nextInt(8) + 1;
            if(hs.remove(tmp)) {
                answer += tmp;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private String inputNumbers() {
        String numbers = "";
        boolean re = false;
        do {
            re = false;
            // 이 부분에서 print로 하면 인텔리j + gradle인 환경에서 출력이 먼저 나오지 않고 do-while 탈출 후 출력이 됨. 해당 부분 왜인지 나중에 확인해보자.
            System.out.println("1 ~ 9까지 서로 다른 수로 이뤄진 3자리 수로 입력해주세요 : ");
            numbers = sc.nextLine();
            if (numbers.length() != 3
                    || numbers.charAt(0) == numbers.charAt(1)
                    || numbers.charAt(0) == numbers.charAt(2)
                    || numbers.charAt(1) == numbers.charAt(2)) {
                re = true;
            }
        } while (re);
        return numbers;
    }

    private boolean checkedNumbers(String numbers, String answer) {
        if (numbers.equals(answer)) {
            System.out.println("3 스트라이크");
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return false;
        }
        int[] score = new int[2];
        for(int i = 0; i < 3; i++) {
            if(numbers.charAt(i) == answer.charAt(0)
                    || numbers.charAt(i) == answer.charAt(1)
                    || numbers.charAt(i) == answer.charAt(2)) {
                score[1] += 1;
            }
            if(numbers.charAt(i) == answer.charAt(i)) {
                score[1] -= 1;
                score[0] += 1;
            }
        }
        if(score[0] == 0 && score[1] == 0) {
            System.out.println("낫싱");
        } else if(score[0] == 0 && score[1] > 0) {
            System.out.println(score[1] + "볼");
        } else if(score[0] > 0 && score[1] == 0) {
            System.out.println(score[0] + " 스트라이크");
        } else {
            System.out.println(score[0] + " 스트라이크 " + score[1] + "볼");
        }
        return true;
    }

    private boolean restart() {
        String num = "";
        //Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        do {
            num = sc.nextLine();
        } while (!num.equals("1") && !num.equals("2"));
        return num.equals("1");
    }

    public void startGame() {
        String answer = "";
        String numbers = "";
        // 게임진행
        do {
            answer = makeAnswer();
            // 3 스트라이크가 나올 때까지 반복
            do {
                numbers = inputNumbers();
            } while (checkedNumbers(numbers, answer));
        } while (restart());
    }
}

