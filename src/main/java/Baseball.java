import java.util.Random;
import java.util.Scanner;


public class Baseball {

    public static int[] randomNumber(int[] computer) {
        // 컴퓨터 숫자를 랜덤으로 부여
        Random rand = new Random();
        boolean[] sure = new boolean[10];
        int count = 0;
        int trial;

        sure[0] = true; // 0제외

        while (count < computer.length) {
            trial = rand.nextInt(10);
            if (!sure[trial]) {
                computer[count] = trial;
                sure[trial] = true; // 숫자 중복 방지
                count++;
            }
        }
        return computer;
    }

    public static boolean checkUser(char[] wrong) {

        if(wrong.length != 3) {
            return false;
        } else if(wrong[0] == wrong[1] || wrong[0] == wrong[2] || wrong[1] == wrong[2]){
            return false;
        } else if(!Character.isDigit(wrong[0]) && !Character.isDigit(wrong[1]) && !Character.isDigit(wrong[2])){
            return false;
        } else if(wrong[0] == '0' || wrong[1] == '0' || wrong[2] == '0'){
            return false;
        }
        return true;
    }

    public static int[] getUser(int[] user) {
        // 사용자 입력숫자 받기
        Scanner scan = new Scanner(System.in);
        boolean right;
        System.out.print("숫자를 입력해주세요 : ");
        String input = scan.nextLine();// 사용자 입력
        char[] charArray = input.toCharArray(); // 문자열을 char배열로 전환

        right = checkUser(charArray);// 입력값이 제대로 됐는지 체크
        if(!right){
            charArray[0] = '0';
        }
        for (int i = 0; i < charArray.length; i++) {
            user[i] = Character.getNumericValue(charArray[i]);
        }
        return user;
    }

    public static int[] getScore(int[] user, int[] computer) {
        int getStrike = 0;
        int getBall = 0;
        int[] score = new int[2];

        for (int i = 0; i < 3; i++) {
            int j = i;
            if (computer[i] == user[i]) {
                getStrike++;
            } else if (computer[++j % 3] == user[i]) {
                getBall++;
            } else if (computer[++j % 3] == user[i]) {
                getBall++;
            }
        }
        score[0] = getStrike;
        score[1] = getBall;
        return score;
    }

    public static int printResult(int strike, int ball){
        Scanner scan = new Scanner(System.in);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            String input = "continue?";
            while (!(input.equals("1") || input.equals("2"))){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = scan.nextLine(); // 게임할지 말지 1 혹은 2 입력
            }
            return Integer.parseInt(input);
        } else {
            String result1 = (strike > 0) ? String.format("%d %s", strike, "스트라이크 ") : "";
            String result2 = (ball > 0) ? String.format("%d %s", ball, "볼 ") : "";
            String result3 = ((result1 + result2).length() > 0) ? result1 + result2 : "낫씽";
            System.out.println(result3);
            return 0;
        }
    }
}

