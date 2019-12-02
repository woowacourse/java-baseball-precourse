# 프리코스 1주차 : 숫자야구 만들기



## 1. 기능 요구사항

게임을 시작하면, 3개의 숫자를 미리 만들어 준다.

이후, 입력으로 **3자리 숫자**가 들어온다. (*입력 도중 예외처리를 명확히 해 준다. 이후엔 입력에 문제가 없다고 가정한다.*)  

룰은 다음과 같다.

- 같은 수가 같은 자리에 있다면, 스트라이크이다.
- 같은 수가 다른 자리에 있다면, 볼이다.
- 같은 수가 전혀 없으면, 낫싱이라고 표기한다.

주어진 숫자를 유저가 맞추면 로직이 종료되고, 게임을 다시 시작하거나 종료할 수 있도록 한다.

---

## 2. 프로그램 구조

대략적인 클래스 구조는 다음과 같다.

```java
public class Baseball{  
  private void makeData();//컴퓨터가 가지는 정답 데이터를 만든다.
  private void getData(int userData);//입력 데이터를 예외처리 검사하고 배열로 쪼개준다.
  private int getBall(int pos);//특정 위치값이 볼로 판정되는지 검사해준다.
  private int getStrike(int pos);//특정 위치값이 스트라이크로 판정되는지 검사해준다.
  private void printState(int strike, int ball);//data간 비교한 결과를 출력해준다.
  private boolean getResult();//스트라이크와 볼 판정을 기반으로, 게임이 끝나는지 여부를 확인해준다.
  
  public boolean playMethod();//게임을 수행한다. getResult값에 따라 종료된다.
  public boolean exitMethod();//야구게임 바깥 루프(게임 계속하기/종료하기) 입력을 받고 종료여부를 확인한다.
}
```

프로그램의 구조를 명확히 하기 위해, MainClass는 오직 동적 메서드 main만을 가진다.

main은 Baseball 객체를 생성해 야구 게임을 진행하며, playMethod와 exitMethod를 통해 야구게임을 진행한다.

playMethod는 야구게임의 내부 루프를 담당하며, 여기에서 진행하는 로직은 아래와 같다.

> 정답값 지정 : makeData
>
> 사용자 입력 : getData
>
> 입력 간 비교 : getResult[getBall,getStrike, printState 호출]
>
> 볼과 스트라이크 개수 확인 : getBall, getStrike
>
> 볼과 스트라이크 개수 출력 : printState