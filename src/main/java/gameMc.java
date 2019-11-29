/*
 * gameMc.java
 * 2019.11.29
 *
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * baseballGame 에 필요한 메소드
 */
public class gameMc {
    /**computer 의 숫자를 담는 변수*/
    private ArrayList comNum;

    /**사용자가 입력한 숫자를 담는 변수*/
    private ArrayList userNum;
    private Scanner inputNum;

    /**숫자를 몇번 입력했는지 확인*/
    private int round=1;

    private int strike;
    private int ball;

    /** 반복문의 위한 변수, ex)gameStatus = 2 이면 프로그램 종료*/
    private int gameStatus = 3;



    /**초기화 동시에 난수생성*/
   public gameMc(){
        setComNum();
    }

    /**comNum 에 3자리 난수 할당 및 test 를 위한 난수 확인 함수*/
    public void setComNum(){
        int randomNum;                                            //comNum 에 저장하기전에 난수를 임시로 저장할 변수;
        comNum = new ArrayList();
        Random rand = new Random();
        while (comNum.size()<3) {                                 //3자리의 난수;
            randomNum = rand.nextInt(9);
            if (randomNum != 0 & !comNum.contains(randomNum)) {               //난수가 0 혹은 중복 되는 값이 없도록;
                comNum.add(randomNum);
            }
        }
    }
    public void getComNum(){
        System.out.println("comNum : "+comNum);
    }


    /**
     * round 출력과 함께 숫자를 입력하는 함수;
     * 숫자가 아닌 데이터가 들어오면 재입력 요청;
     */
    public void setUserNum(){
        String temp;                                                 //입력한 숫자를 임시로 저장할 변수;
        String[] arrayTemp;
        System.out.println("-------"+round+"round--------");
        System.out.println("서로다른 3자리 숫자를 입력해주세요 : ");
        try{
            userNum = new ArrayList();
            inputNum = new Scanner(System.in);                          //숫자 입력;
            temp = inputNum.next();
            arrayTemp = temp.split("");                          //입력한 3자리 숫자를 분할하여 int 타입으로 배열에 저장;
            for(int i=0;i<3;i++){
                userNum.add(Integer.valueOf(arrayTemp[i]));
            }
            round+=1;
        } catch(Exception e){                                            //입력한 값이 숫자가 아닐경우 재입력 요청;
            System.out.println("3자리 숫자만 입력 해주세요");
            setUserNum();
        }

    }
    public void getUserNum(){
        System.out.println("userNum : "+userNum);
    }


    /**
     * comNum 과 userNum 을 비교하여 strike 와 ball 확인;
     */
    public void compare(){
        strike=0;
        ball=0;
        for(int i=0;i<3;i++){
            if(userNum.get(i)==comNum.get(i)){
                strike+=1;
            } else if (comNum.contains(userNum.get(i))){
                ball+=1;
            }
        }
    }

    /**
     * 결과를 출력해줌과 동시에 3스트라이크라면 종료를 확인하는 isEnd() 호출;
     */
    public void scoring(){
        if(strike == 3){
            System.out.println("3 스트라이크");
            System.out.println("게임종료! 다시하려면 1, 종료하려면 2 를 입력해주세요");
            isEnd();
        }
        else{
            if(strike*ball > 0){                                             //strike,ball 둘다 0이 아닌 경우;
                System.out.println(strike+" 스트라이크 "+ball+" 볼");
            } else if(strike == 0 & ball != 0){                                //ball 만 0이 아닌 경우;
                System.out.println(ball+" 볼");
            } else if(strike != 0 & ball == 0){                                //strike 만 0이 아닌 경우;
                System.out.println(strike+" 스트라이크");
            } else{                                                            //strike,ball 둘다 0인 경우;
                System.out.println("낫싱");
            }
        }
    }


    /**
     * 게임을 끝낸 사용자가 입력한 값을 gameStatus 에 할당;
     */
    public void isEnd(){
        Scanner end = new Scanner(System.in);
        String status = end.next();
        setGameStatus(Integer.valueOf(status));
    }
    public void setGameStatus(int x){
        gameStatus = x;
    }


    /**
     * 게임을 끝낸 사용자가 1을 값을 입력하면 새로운 난수 생성과 함께 게임 초기화
     * 게임을 끝낸 사용자가 2의 값을 입력하면 프로그램 종료;
     * @return 현재 gameStatus 값을 리턴함으로서 게임 반복 여부 확인;
     */
    public int checkStatus() {
        if (gameStatus == 1) {                //isEnd()를 통해 1을 입력한 상태이므로 난수 재생성 및 초기화
            setComNum();
            round=1;
            gameStatus = 3;
        } else if(gameStatus == 2){              //프로그램 종료
            System.exit(0);
        }
        return gameStatus;
    }
}
