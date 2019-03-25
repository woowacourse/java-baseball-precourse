자바 base ball우아한 테크코스

프리코스 과제 - baseballGame

 기능 목록

1. 난수 생성

	int createRandomNumber
		- 난수 3개를 생성하여 반환


2. 사용자 입력 문구 출력

	void inputDisplay
		- 사용자 입력 문구 출력


3. 사용자 입력

	int inputUserNumber
		- 사용자 입력을 반환


4. 난수와 사용자 입력값 비교 후 상태 값 반환
	
	int[] matchNumber
		- 난수와 사용자 입력값 비교후 strike,ball 의 값을 배열로 저장후 배열 반환


5. 비교 상태 문구 출력

	void matchDisplay
		- 난수와 사용자 입력값 비교 결과 출력


6. 4번의 결과에 따라 게임 상태 반환
	
	boolean getBaseballResult
		- 4번과정에서 반환된 배열을 확인하여 3스트라이크(true) or 3스트라이크 (false) 값 반환

7. 6번에서 3스트라이크(true)시 문구 출력
		
	void getResultDisplay
		- 3스트라이크시 게임 새로시작, 종료 문구 출력


8. 6번에서 3스트라이크시(true) 게임종료, 게임 새로시작
	
	int getGameState
		- 6번과정에서 3스트라이크시 게임종료, 게임 새로시작 값 반환