# Change log

## Version

## TaeyeonRoyce

1. ```
   2021/11/24
   "docs(README.md) : add README.md to list up application functions"
   
   프로젝트 생성 및 요구사항에 맞는 기능 목록을 포함하여 리드미 작성
   ```

   

2. ```
   2021/11/24
   "feat : add creating random computer number with handling exception"
   
   pickNumberInRange()를 활용하여 1 ~ 9 사이의 서로 다른 세 자리 정수를 생성하는 기능 추가
   랜덤하게 생성된 숫자의 예외처리 기능(중복) 추가
   ```

3. ```
   2021/11/25
   "refactor : change number pacakge structure to seperate model and service"
   
   컴퓨터 난수 생성과 컴퓨터 난수 저장의 역할 분리를 위한 코드 리팩토링
   baseball이라는 인터페이스로 통합하여 추후 추가될 사용자 입력에 대한 처리도 가능하게 함
   ```

4. ```
   2021/11/25
   "feat : add user input view and service with handling exception"
   
   사용자 입력에 관한 기능 추가
   입력하기 위한 메세지 출력기능 추가
   입력을 판단하고 이에 따른 어플리케이션 진행여부를 결정 하도록 함
   ```

5. ```
   2021/11/25
   "feat(Result) : add result service to calculate game result deciding when the game over and print result message"
   
   사용자 숫자와 컴퓨터 숫자간의 숫자 야구 게임 진행
   스트라이크와 볼, 그에 따른 결과 메세지를 저장하는 result객체 추가
   형식에 맞는 게임 결과 출력
   3스트라이크가 될 때까지 사용자에게 숫자를 입력받는 기능 추가
   3스트라이크 시 게임이 종료 됨.
   ```

6. ```
   2021/11/25
   "refactor(ResultService) : change ResultService structure to carry out result model per each, not every model"
   
   ResultService에 대한 어플리케이션의 의존도를 낮추기 위한 리팩토링.
   ResultService의 역할을 위임 없이 모두 수행하도록 변경
   ```

7. ```
   2021/11/25
   "feat(PlayBall) : choose restart after game over"
   
   게임 종료(3스트라이크)시 재시작 여부 입력 받기
   입력받은 값이 정상 값인지 판단 후,
   재시작 혹은 어플리케이션 종료
   ```

8. ```
   2021/11/25
   "fix(PlayBall) : throw excpetion without handling"
   
   버그 : **예외 입력 사항에 대한 테스트 실패**
   
   해결 : 요구사항에 맞게 예외사항에 대해 처리하는 것이 아닌 발생하도록 변경
   ```

9. ```
   2021/11/26
   "style : edit comments and suit to the java style guide"
   
   주석 수정 및 코드 컨벤션에 적합하도록 공백 추가
   ```





