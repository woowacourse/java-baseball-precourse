import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static ArrayList<Integer> targetList;
    public static ArrayList<Integer> userList;
    public static int ballNumber;
    public static int strikeNumber;
    public static int play;
    public static void main(String[] args) {
        while(play!=2) {
            baseballGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            play = sc.nextInt();
        }
        System.out.println("시스템 종료");
    }


    /*  baseballGame : 게임과정 */
    public static void baseballGame(){
        generateTarget();
        while(strikeNumber!=3) {
            generateUser();
            checkResult();
            printResult();
            finishGame();
        }
        strikeNumber = 0;  // 게임 종료 후 스트라이크 변수 리셋
    }


    /*  generateTarget : 맞춰야 하는 숫자 생성 */
    public static void generateTarget() {
        Random random = new Random();
        targetList = new ArrayList<Integer>(3);  // 야구게임 시작 문제숫자를 추가할 리스트 선언
        while(targetList.size()!=3){
            int newNumber = random.nextInt(9) + 1;  // 난수 생성
            if (targetList.contains(newNumber)) {
                continue;  // 생성된 난수가 이미 리스트에 존재할 경우 다시 난수 생성
            }
            targetList.add(newNumber);  // 생성된 난수가 리스트에 존재하지 않으면 리스트에 추가
        }
    }
    /* generateUser : 사용자 숫자를 입력받아 리스트를 생성 */
    public static void generateUser() {
        Scanner sc = new Scanner(System.in);
        int userNumber = sc.nextInt();  // 사용자의 입력을 받는 부분
        userList = new ArrayList<Integer>(3);  // 사용자의 숫자를 리스트 형태로 바꾸는 부분
        userList.add(0, userNumber / 100);  // 첫번째 숫자 추가
        userList.add(1, userNumber % 100 / 10);  // 두번째 숫자 추가
        userList.add(2, userNumber % 100 % 10);  // 세번째 숫자 추가

    }

    /* checkResult : 볼, 스트라이크 수 계산 */
    public static void checkResult() {
        ballNumber = 0;  // 볼 변수 리셋
        for (int user : userList) {
            if (targetList.contains(user)) {
                ballNumber++;  // 사용자리스트의 값이 타겟리스트에 존재하면 볼 변수 증가
            }
        }
        strikeNumber = 0;  // 스트라이크 변수 리셋
        for (int i = 0; i < 3; i++) {
            if (targetList.get(i) == userList.get(i)) {
                strikeNumber++;  // 사용자리스트와 타겟리스트의 같은 인덱스의 값을 비교하여 같으면 스트라이크 변수 증가
            }
        }
        ballNumber -= strikeNumber;  // 볼 변수에 스트라이크 변수가 포함되기 때문에 스트라이크 변수만큼 감소
    }
    /*  printResult : 볼 스트라이크 계산 결과 출력 */
    public static void printResult() {
        if (ballNumber == 0 && strikeNumber == 0) {
            System.out.println("낫싱");  // 둘 다 없을 때 출력
        } else if (ballNumber == 0) {
            System.out.println(strikeNumber + " 스트라이크 ");  // 스트라이크만 있을 때 출력
        } else if (strikeNumber == 0) {
            System.out.println(ballNumber + " 볼");  // 볼만 있을 때 출력
        } else {
            System.out.println(strikeNumber + " 스트라이크 " + ballNumber + " 볼");  // 둘 다 있을 때 출력
        }
    }
    /*  finishGame : 스트라이크 3개일 경우 게임종료 */
    public static void finishGame() {
        if (strikeNumber == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
    }


}

