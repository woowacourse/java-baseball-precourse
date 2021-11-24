# 미션 - 숫자 야구 게임

## ✍🏻 구현할 기능 목록

- <b>[게임 시작] 타겟 넘버 생성</b>

  - 1부터 9까지 서로 다른 숫자로 이루어진 3자리의 수의 타겟 넘버를 생성한다.
  - camp.nextstep.edu.missionutils에서 제공하는 Randoms API를 활용하여 생성한다.
    <br>

- <b>[게임 진행] 플레이어로부터 수 입력 받기</b>

  - [예외] 입력받은 수가 1부터 9사이의 숫자로 이루어져 있는지 검사한다.
  - [예외] 입력받은 수가 3자리의 수인지 검사한다.
  - [예외] 입력받은 수가 서로 다른 숫자로 이루어져 있는지 검사한다.
  - 예외 발생 시 IllegalArgumentException 을 발생시킨다.
  - camp.nextstep.edu.missionutils에서 제공하는 Console API를 활용해 입력을 받는다.
  - 타겟 넘버와 입력 받은 수가 일치할 때 까지 반복한다.
    <br>

- <b>[게임 진행] 타겟 넘버와 플레이어에게 입력받은 수가 일치하는 지 확인</b>

  - 같은 숫자가 같은 자리에 있으면 스트라이크이다.
  - 같은 숫자가 다른 자리에 있으면 볼이다.
  - 같은 숫자가 전혀 없으면 낫싱이다.
  - 스트라이크/볼 결과를 반환한다.
    <br>

- <b>[게임 종료] 게임 종료 여부 결정</b>

  - 재시작/종료는 1과 2로 결정
  - [예외] 입력받은 수가 1또는 2가 아닐 때 IllegalArgumentException을 발생시킨다.

    <br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
