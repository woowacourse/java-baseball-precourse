package edu.woowacourse.first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {
  private int [] nums;
  Scanner sc;

  public NumberBaseball() {
    nums = new int[3];
    this.setRandomNumbers();
  }

  public void start(){
    sc = new Scanner(System.in);
    boolean isContinue = true;
    while (isContinue){
      System.out.print("숫자를 입력해주세요 : ");
      String userInput = sc.next();
      if (!checkInput(userInput)){
        System.out.println("잘못된 입력입니다 : " + userInput);
        continue;
      }
      int [] userNums = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();
      int [] ballCount = this.calBallCount(userNums);
      boolean isAnswer = false;
      String resultMsg;
      if (ballCount[0] == 0 && ballCount[1] == 0){
        resultMsg = "낫싱";
      } else if (ballCount[0] == 3){
        resultMsg = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        isAnswer = true;
      } else {
        resultMsg = String.format("%d 스트라이크 %d볼", ballCount[0], ballCount[1]);
      }
      System.out.println(resultMsg);
      if (isAnswer) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        if (sc.nextInt() == 2){
          isContinue = false;
        } else {
          this.setRandomNumbers();
        }
      }
    } // 게임을 진행하는 while 문
    sc.close();
  }

  private void setRandomNumbers(){
    Random rand = new Random();
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < 3; i++){
      int randNum = rand.nextInt(9) + 1;
      if (!set.contains(randNum)) {
        this.nums[i] = randNum;
        set.add(randNum);
      } else {
        i--;
      }
    }
  } // 중복없이 1부터 9까지 컴퓨터의 입력값을 정해주는 메서드

  private boolean checkInput(String userInput){
    int n = userInput.length();
    if (n != 3) {
      return false;
    } else if (isCharacter(userInput)) {
      return false;
    } else if (isOverlap(userInput)) {
      return false;
    }
    return true;
  } // 유저의 입력값이 제대로 입력되었는지 판단하는 메서드

  private boolean isCharacter(String userInput){
    for (int i = 0; i < userInput.length(); i++){
      char ch = userInput.charAt(i);
      if (ch < 49 || ch > 57){
        return true;
      }
    }
    return false;
  } // 유저의 input 값을 검토하는 것 중 문자가 입력되는 경우를 판단하는 메서드

  private boolean isOverlap(String userInput) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < userInput.length(); i++){
      int temp = Integer.parseInt(userInput.charAt(i) + "");
      if (set.contains(temp)) {
        return true;
      } else {
        set.add(temp);
      }
    }
    return false;
  } // 유저의 input 값 검토 중 입력 숫자가 중복되는 것이 있는지 판단하는 메서드

  private int [] calBallCount(int [] userNums){
    int [] ballCounts = new int[2];
    for (int i = 0; i < this.nums.length; i++){
      int comNum = this.nums[i];
      for (int j = 0; j < userNums.length; j++){
        int userNum = userNums[j];
        if (comNum == userNum){
          if (i == j) {
            ballCounts[0] += 1;
          } else {
            ballCounts[1] += 1;
          }
        }
      }
    }
    return ballCounts;
  } // 유저의 input 값과 현재 컴퓨터가 정한 값과 비교하여 볼카운트를 계산하는 메서드
}
