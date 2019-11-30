# **미션 1 : 숫자야구게임**

1~9의 서로 다른 수로 이루어진 3자리 수를 맞추는 게임

 

## **요구사항**

####  프로그래밍 및 진행 요구사항                   

- 자바 코드 컨벤션 준수
- Indent depth < 3
- 3항 연산자 미사용
- 각 함수, 메소드는 한 가지 기능만 수행
- 기능 단위의 commit





#### 기능 요구사항

#### Main Class

1. while(true) 
   - 숫자야구게임을 실행하는 메서드(Play) 호출
   - 종료 / 새 게임 시작하는 메서드 호출(isEnd)
     - false를 반환 : break
     - true를 반환 : 아무 기능도 하지 않음



#### Computer Class

1.  makeAnswer 메서드
    - 1~9 까지의 서로 다른 수로 이루어진 3자리 수 랜덤생성 
      - 첫번째 자리 : 1~9 무작위 생성
      - 두번째 자리 : 첫번째 자리에 있는 수 제외 1~9 무작위 생성
      - 세번째 자리 : 첫번째, 두번째 자리에 있는 수 제외 1~9 무작위 생성
2.  checkStrike 메서드
    - 같은 수가 같은 자리인 갯수 리턴
3.  checkBall 메서드
    - 같은 수가 다른 자리인 갯수 리턴
4.  print 메서드
    - 플레이어가 입력한 숫자에 대한 결과를 출력
    - if checkstrike의 반환값 !=0
      - print CheckStrike의 반환값 + '스트라이크'
    - if checkBall의 반환값 !=0
      - print CheckBall의 반환값 + '볼'
    - if checkStrike의 반환값 ==0 and checkBall의 반환값 ==0
      - print '낫싱'
    - if checkStrike의 반환값 ==3
      - return false
    - else
      - return true



#### Player Class

1.  1~9로 이루어진 서로 다른 수 입력 요청

   

2. 플레이어가 서로 다른 세 수 외의 값(중복되는 수, 혹은 문자 등)을 입력할 경우

   - 재입력 요청

   

#### PlayBaseballGame Class

1. Computer 객체 생성
2. Player 객체 생성
3. play 메서드
   - Computer로부터 랜덤 값 획득
   - while(false)
     - 플레이어로부터 값을 입력받음
     - Computer의 print 메서드에서 true가 리턴 될 때 까지 반복
4. isEnd 메서드
   - 1을 입력 : 새 게임 시작, return true 
   - 2를 입력 : 게임 종료, return false



