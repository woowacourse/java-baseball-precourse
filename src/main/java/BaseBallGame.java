package main.java;

import java.util.Scanner;
import java.util.Random;

public class BaseBallGame {
    static int[] start_number = new int[3]; // 게임 시작시 상대방의 수를 저장할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean game_state = true;  
        int user_num;               // 유저가 입력할 수
        int game_check = 0;         // 0 : 게임중, 1 : 새로 시작, 2 : 종료
        String sentence;            // 유저의 입력에 따라 출력해줄 문자열 변수

        makeNum();
        
        /* Game Body */
        while (game_state) {
            sentence = "";
            System.out.print("숫자를 입력해주세요 : ");
            user_num = sc.nextInt();

            int[] user_input = intToIntArray(user_num);
            int[] counter = countStrikeBall(user_input);

            if (counter[0] == 0 & counter[1] == 0) {sentence += "낫싱";}
            // strike도 ball도 없는 경우 출력할 문자
            if (counter[0] > 0) {sentence += counter[0] + " 스트라이크 ";}
            // strike가 0이 아닌 경우 출력할 문자
            if (counter[1] > 0) {sentence += counter[1] + " 볼";}
            // ball이 0이 아닌 경우 출력할 문자

            // 게임종료 분기점
            if(counter[0] == 3) {
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                game_check = sc.nextInt();
            }

            // New Game OR EXIT
            if(game_check == 1) {
                // New Game
                makeNum();
                game_check = 0;
            } else if(game_check == 2) {
                // EXIT
                game_state = false;
            }
        }
    }

    /* 3개의 중복되지 않은 숫자를 int형 배열에 저장하는 함수(상대방의 수 셋팅) */
    static void makeNum() {
        Random random = new Random();
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;

		do {
			num1 = random.nextInt(9) + 1;
			num2 = random.nextInt(9) + 1;
			num3 = random.nextInt(9) + 1;
		} while (num1 == num2 && num2 == num3 && num1 == num3);

		start_number[0] = num1;
		start_number[1] = num2;
		start_number[2] = num3;
    }

    /* 유저로부터 받은 int형 숫자를 int형 배열 숫자로 바꿔주는 함수 */
    static int[] intToIntArray(int input) {
        int[] output = new int[3];
        output[0] = input/100;
        output[1] = input/10%10;
        output[2] = input%10;
        return(output);
    }

    /* strike수와 ball수를 int형 배열로 반환 */
    static int[] countStrikeBall(int[] input) {
        int[] output = {0,0};       // {strike 수, ball 수}
        Boolean ball_check = false; // ball인 경우 true

        for (int i = 0; i < 3; i++) {
            ball_check = isBall(input[i], i);

            if (input[i] == start_number[i]) {
                // strike인 경우 결과값에 strike숫자를 1 증가 시킴
                output[0] ++;
            }
            if (ball_check) {
                // ball인 경우 결과값에 ball숫자를 1 증가 시킴
                output[1] ++;
            }
        }

        return(output);
    }

    /* 해당 숫자가 ball이 맞는지 확인하는 함수 */
    static Boolean isBall(int cont, int index) {
        Boolean result = false;
        for (int i = 0; i < 3; i++) {
            if (cont == start_number[i] & i != index) {
                // ball로 판단되는 경우
                result = true;
                break;
            }
        }
        return(result);
    }
}