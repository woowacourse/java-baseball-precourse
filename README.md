#숫자 야구 게임

* 주요 클래스 

 1. View : 입력과 출력을 담당하는 클래스  <br/>
  1.1 참조할 클래스 :  2의 클래스를 참조 해야합니다. <br/>
  1.2 포함하고 있는 메소드 : InputNumber, PrintResult, InputReGame<br/>
   
 2. Model : 입력한 Data를 보관하는 클래스  <br/>
  2.1 참조할 클래스 : 없음 <br/>
  2.2 포함하고 있는 메소드 : 없음 <br/>
  
 3. HandlingData : 입력받은 Data를 처리하는 클래스 <br/>
  3.1 참조할 클래스 : 2의 클래스를 참조 해야합니다. <br/>
  3.2 포함하고 있는 메소드 : JudgeStrike <br/>
  
 4. Controller(main함수 포함) : 전체적인 게임을 컨트롤하고 운영하는 클래스 <br/>
  4.1 참조할 클래스 : 1,2,3의 모든 클래스를 참조할 필요가 있습니다. 
  4.2 포함하고 있는 메소드 :  StartGame , ChooseNumber, IsGameOver, ReStart, ExitGame <br/>
  
* 주요 기능 

 1. StartBaseBallGame : 게임을 시작하고 운영하는 기능
 
 2. SelectRandomNumber : 1~9까지의 난수를 생성해서 리턴해주는 기능
 
 3. SaveComputerNumber : 컴퓨터가 선택한 숫자를 Model에 저장하는 기능
 
 4. InputNumber : 게임 중 사용자의 입력을 받는 기능
  
 5. JudgeStrike : 입력된 데이터를 기반으로 스트라이크, 볼, 낫싱을 판단하는 기능
 
 6. PrintResult  : 처리된 데이터를 기반으로 출력을 해주는 기능
  
 7. IsGameOver :  결과를 출력한 뒤  경기가 끝났는 지 아닌지 판단하는 기능
 
 8. InputReGame : 경기가 끝났다면 게임을 다시 시작할지 사용자의 입력을 받는 기능
  
 9. ReStart : 게임을 다시 시작하는 기능
 
 10. ExitGame : 게임을 종료하는 기능
 
 ※ 기능의 숫자는 프로그램이 실행되는 순서를 의미합니다.