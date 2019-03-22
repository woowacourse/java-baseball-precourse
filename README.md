야구게임

1. main메소드: 게임 순서도, 전체 흐름 짜기

2. genComNum()메소드 : 컴퓨터가 게임에 사용할 랜덤한 숫자 생성
    - 반환형 int, 
    - comNum%10, comNum/10%10, comNum/100%10 셋다 다르면 리턴 아니면 반복
    - 해당 메소드내, effchk(int value) 메소드 호출 : value값이 야구 게임에 사용하기 유용한 숫자인가? 
3. chkNum(int comNum,int playerNum) 메소드 :
    - 먼저 스트라이크 체크, 볼 체크 
    - 스트라이크 갯수, 볼 갯수 저장하는 정수형 배열 반환

4. playerNumEffChk(int value) 메소드 : 플레이어 입력 숫자 playerNum 유효성 체크 . 
    - main 메소드내 플레이어 숫자 입력 코드 부분 while문으로 수정