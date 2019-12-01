package baseball.precourse;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

   static Scanner sc = new Scanner(System.in);
   static ArrayList<Integer> answer;
   static Random rand = new Random();
   static int strike = 0, ball = 0;
   static int[] userNum = new int[3];
   
   public static void main(String args[]) {
      startGame();
   }

   // 게임 실행 함수
   public static void startGame() {

      int input;
      randomNumber();
      do {
            System.out.print("숫자를 입력해주세요 : ");
            input = sc.nextInt();
            processInput(input);
      } while(true);
   }
   
   public static boolean isDone(int input) {
      if(input==2)
         return true;
      return false;
   }

   // 유저 입력 데이터 한 개씩 userNum에 적용
   public static void processInput(int number) {
      int count = 2;
      while (count > -1) {
         userNum[count--] = number % 10;
         number /= 10;
      }
      judge();
   }

   // 스트라이크, 볼 계산 함수
   public static void judge() {
      strike = ball = 0;
      for (int i = 0; i < 3; i++) {
         if (checkNumber(userNum[i])) {
            checkResult(i);
         }
      }
      printResult();
   }

   // 실제로,인덱스 동일 여부 에따라 스트라이크 볼 더해주는 함수
   public static void checkResult(int userIndex) {

      if (answer.get(userIndex) == userNum[userIndex]) {
         strike++;
         return;
         }
      ball++;

   }

   // 스트라이크 볼에 따른 결과 출력
   public static void printResult() {

      if (strike == 3) {
         allStrike();
         return;
      }
      
      if (strike != 0)
         System.out.printf("%d 스트라이크", strike);
      if (ball != 0)
         System.out.printf("%d볼  ", ball);
      if(strike== 0&& ball==0)
         System.out.print("낫싱");

      System.out.println();

   }

   // 정답 시에 게임 종료,재시작 여부 수행
   public static void allStrike() {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
      System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요");
      int input = sc.nextInt();

      if (input == 1) {
         startGame();
         return;
      }
      System.exit(0);

   }

   // 정답(컴퓨터) 숫자 설정 및 중복 검사 메소드
   public static void randomNumber() {
      answer = new ArrayList<Integer>();
      int number;
      while (answer.size() < 3) {
          number = rand.nextInt(9) + 1;
         if (!checkNumber(number)) {
            answer.add(number);
         }
      }

   }
   
   public static boolean checkNumber(int number) {
      if(answer.contains(number))
         return true;
      return false;
   }
   
}