package com;

import java.util.*;

/**
 * 숫자야구를 실행시킬 수 있는 클래스이다.
 * 기능 목록에 의거하여 구현됐다.
 */
public class NumberBaseball{
    static HashMap<Integer, Integer> com = new HashMap<>();
    static HashMap<Integer, Integer> user = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    /**
     * 컴퓨터에 난수를 발생시키는 메소드
     * 중복을 피하며 1~9의 범위의 난수를 hashmap에 저장한다.
     */
    public void setComNumber(){
        int num = 0;

        for(int i=0; i<3;){
            num = (int) (Math.random() * 10) + 1;

            if(num >= 10 || com.containsValue(num)){
                continue;
            }

            com.put(i++, num);
        }
    }

    /**
     * 사용자가 입력한 숫자를 hashmap에 저장하는 메소드
     * 문자열로 받은 숫자를 문자열 배열로 쪼개고 user에 저장한다.
     */
    public void setUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String[] str = sc.next().split("");

        for(int i=0; i<3; i++){
            user.put(i, Integer.parseInt(str[i]));
        }
    }

    /**
     * 데이터 구조(strike, ball)만 가지는 StrikeBall 클래스 객체에
     * 난수와 사용자 입력 숫자를 비교하여 strike와 ball를 갱신해준다.
     * @param strikeBall
     * @return strikeBall
     */
    public StrikeBall calc(StrikeBall strikeBall){
        for(int i=0; i<3; i++){
            if(com.get(i) == user.get(i)){
                ++strikeBall.strike;
            }else if(com.containsValue(user.get(i))){
                ++strikeBall.ball;
            }
        }
        return strikeBall;
    }

    /**
     * calc 메소드의 결과로 나온 StrikeBall 객체를 받아서 비교 결과를 출력하는 메소드
     * @param strikeBall
     */
    public void printResult(StrikeBall strikeBall){
        String result = "";
        String s = "";

        if(strikeBall.strike != 0){
            s = strikeBall.strike + " 스트라이크 ";
            result += s;
        }
        if(strikeBall.ball != 0){
            s = strikeBall.ball + " 볼 ";
            result += s;
        }
        if(result.isEmpty()){
            result = "낫싱";
        }

        System.out.println(result);
    }

    /**
     * 컴퓨터 난수와 사용자 입력 수가 같은지를 확인하는 메소드
     * 정답을 맞혔는지 확인하기 위해 구현
     * @return
     */
    public boolean compare(){
        for(int i=0; i<3; i++){
            if(com.get(i) != user.get(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자가 입력한 수와 난수가 같았을때 종료 여부를 확인하는 메소드
     * 다시 시작을 의미하는 1을 입력하면 true, 종료를 위해 2를 입력하면 false를 반환한다.
     * @return true / false
     */
    public boolean checkEndOrNot(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        while(true){
            int input = sc.nextInt();

            if(input == 1){
                return true;
            }else if(input == 2){
                return false;
            }else{
                System.out.println("올바른 숫자를 입력하세요");
            }
        }
    }

    /**
     * 사용자의 입력, 두 수 비교, 결과 출력, 두 수가 같은지 여부를 확인하는 메소드들을 묶어논 메소드
     * do while로 묶어서 정답을 맞힐때까지 반복하게 해준다.
     */
    public void guessComNumber(){
        do{
            /* 사용자의 입력 */
            setUserNumber();

            /* 두 숫자 비교 후 결과 출력*/
            printResult(calc(new StrikeBall(0, 0)));

        }while(!compare());     // 두 수가 같은지 여부를 확인
    }
}
