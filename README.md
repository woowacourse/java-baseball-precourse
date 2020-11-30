# **미션 - 숫자 야구 게임**

# **구현할 기능 목록**

## **3개의 랜덤값 생성**

- 파일명 : MakeThreeRandomNumber class
- 랜덤한 값을 생성한다.
- 랜덤한 값이 기존 값과 중복되었는가 확인하여 중복되지 않은 값을 만든다.

    ### **3개의 int값이 들어있는 Array를 제공한다.**

## **사용자 입력 정보 처리**

- 파일명 : UserInput class
- 사용자의 입력을 제공받는다.
- 사용자의 입력 데이터에서 정수값을 추출한다(한 자릿 수의 정수값만 들어온다).
- 잘못된 값이 들어왔을 경우 IllegalArgumentException 출력.

    ### **임의의 int값이 들어있는 Array를 제공한다.**

## **정답 비교**

- 파일명 : AnswerCheck class
- 사용자 정보와 랜덤값을 비교하여 스트라이크를 찾는다.
- 스트라이크가 아니라면 볼인지 찾는다.

    ### **Strike와 Ball의 수가 담긴 Array를 제공한다.**

## **정답을 맞출 때 까지 반복**

- 파일명 : BaseBallGameController class
- 컴퓨터의 값을 받아와서 정답을 맞출 때 까지 반복한다.
- 정답을 맞출 경우 종료한다.

## **재시작**

- UserInput class를 사용하여 사용자의 입력을 처리한다.
- 입력에 따라 재시작, 혹은 종료한다.
- 재시작의 경우 다시 baseBallGameController class의 메소드를 사용한다.

# **구조 설명**

- MakeRandomThreeNumber : 랜덤한 3개의 값을 생성한다.
- UserInput : 사용자의 입력값을 예외처리하고 정상 데이터는 int[] array 형태로 리턴한다
    - 중복된 숫자, 정해진 범위를 넘어서는 숫자(3개를 입력해야하나 4개를 입력 등) 숫자가 아닌 문자 혹은 숫자 0
- AnswerCheck: 사용자의 입력이 컴퓨터의 입력과 같은지 확인하고 스트라이크, 볼 정보를 int[] array {스트라이크, 볼} 형태로 출력한다
- BaseBallGameController : 만든 클래스와 메소드를 사용하여 야구 게임을 진행한다.
- Application : 최초 컴퓨터의 숫자를 생성하고 재시작 요청을 처리한다.
- tuils.RandomUtils : 지정한 두 인자 내의 랜덤한 숫자를 생성한다.

## **📝 License**

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.