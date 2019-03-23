*구현해야 하는 기능

class Game
- String generateNumber(int length)
length 크기 숫자(string)를 랜덤으로 생성한다. 하나의 숫자 범위는 1~9다.

- boolean playGame(String createdNumber)
생성된 수를 넘겨받아 게임을 진행한다. 사용자가 게임을 새로 시작하려고 하면 true, 종료하려고 하면 false를 리턴한다.

- String recieveNumber()
세 자릿 수 숫자(string)을 입력으로 받는다. 세 자릿 수 숫자인지 확인하기 위해 checkLength, checkNumber 함수를 사용한다.
checkLength 또는 checkNumber가 false라면 입력을 계속해서 받는다.



class CheckSomething
- boolean checkLength(String input, int length)
input의 길이가 length인지를 확인한다. 아니라면 false, 맞다면 true를 리턴한다.

- boolean checkNumberString(String input)
input이 1~9의 숫자로만 이루어졌는지 확인한다. 아니라면 false, 맞다면 true를 리턴한다. checkNumber 함수를 사용한다.

- boolean checkNumber(char character)
character이 1~9 중 하나의 숫자인지 확인한다. 아니라면 false, 맞다면 true를 리턴한다.

- boolean checkReceivedNumber(String number)
number의 길이가 3인지, 그리고 number이 실제 숫자인지 확인한다. 모두 맞다면 true, 하나라도 틀리면 false를 리턴한다.
checkNumbers, checkLength 함수를 사용한다.

- boolean checkUserThought()
"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"라고 유저의 의사를 묻는다. 1 또는 2 이외의 글자를 입력하면 다시 유저의 의사를 묻는다.
유저가 "1"이라고 답하면 true, "2"라고 답하면 false를 return한다.



class Oracle
- Result tells(String createdNumber, String inputNumber)
총체적인 결과를 리턴한다. strike가 몇 개 나왔고, ball이 몇 개 나왔는지에 대한 정보를 Result Object에 담아 리턴한다.
examines 함수를 사용한다.

- int examines(String createdNumber, String inputNumber, int seat)
주어진 자릿수(seat)에 대해 strike인지, ball인지, nothing인지 오라클이 판단한다. strike라면 1을, ball이라면 2를, nothing이라면 0을 리턴한다.
checkStrike, checkBall 함수를 사용한다.

- boolean checkStrike(string createdNumber, string inputNumber, int seat)
주어진 자릿수(seat)에 대해 strike인지 판단한다. extractNumber 함수를 사용한다.

- boolean checkBall(string createdNumber, string inputNumber, int seat)
ball인지 아닌지에 대해 판단한다. extractNumber 함수를 사용한다.



class Result
- int strike, int ball
strike 개수와 ball 개수에 대한 정보를 담고 있다.


구현 순서:
checkLength -> checkNumber -> checkNumberString -> checkRecievedNumber -> recieveNumber -> generateNumber
    Result class  -> checkStrike -> checkBall ->examines -> tells ->checkUserThought -> playGame