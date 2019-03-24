package edu.woowacourse.first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {
  /*
   *
   */
  private int [] nums;
  Scanner sc;

  public NumberBaseball() {
    nums = new int[3];
  }

  public void start(){
    sc = new Scanner(System.in);
    this.setRandomNumbers();
    boolean isContinue = true;
    while (isContinue){
      System.out.print("숫자를 입력해주세요 : ");
      String userInput = sc.next();
      if (!checkInput(userInput)){
        System.out.println("잘못된 입력입니다 : " + userInput);
        continue;
      }
      int [] userNums = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();
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
}
