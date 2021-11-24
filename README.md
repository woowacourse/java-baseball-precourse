# 미션 - 숫자 야구 게임

## ✍🏻 구현할 기능 목록
각 기능들은 메소드로 분리  

-  [타겟넘버 생성]  
   
    - camp.nextstep.edu.missionutils의 **Randoms** API의 **pickNumberInRange()** 활용
    - 1부터 9까지의 서로 다른 수로 이루어진 3자리의 수
       

-  [유저에게 유저인풋넘버 입력 받기]  

    - camp.nextstep.edu.missionutils의 **Condsole** API의 **readLine()** 활용
    - **"숫자를 입력해주세여 : "** 출력    
    - 1부터 9까지의 3자리의 수
    - 올바르지 않은 인풋 예외처리 
        - IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
       

- [유저에게 결과 알러주기]  
  
    - 타겟넘버와 유저인풋넘버를 비교 
       - 각각 배열로 저장해 하나 씩 비교 
    - 비교 후, **"X볼 X스트라이크"** 출력 
    - 3스트라이크 라면, **"3개의 숫자를 모두 맞히셨습니다! 게임 종료"** 출력
    - 3스트라이크 아니라면, **"숫자를 입력해주세여 : "** 출력 


- [재시작 여부 입력 받기]  
  
    - **게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.** 출력
    - 1이라면, 위의 과정 반복 
    - 2라면, 종료
<br>

## ✔️ Commit Conventions 
 - [feat]: 기능 관련 커밋
 - [fix]: 버그 수정 관련 커밋
 - [docs]: 문서 관련 커밋
 - [refactor]: 기능 수정 관련 커밋 
 - [test]: 테스트 관련 커밋 

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.


