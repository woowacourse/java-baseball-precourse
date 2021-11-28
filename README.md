# 미션 - 숫자 야구 게임⚾️

## ⌨️ 입력

#### 1. Number

- [예외] 0~9의 범위를 벗어난 수가 들어올 경우 IllegalArgumentException이 발생해야 한다.

#### 2. Numbers

- [예외] 4개이상의 수가 입력될 경우 IllegalArgumentException이 발생해야 한다.
- [예외] 입력된 숫자 중 중복된 숫자가 존재할 경우 IllegalArgumentException이 발생해야 한다.

#### 2-1. Numbers Matching

- 숫자가 위치한 곳에 해당 수가 존재하는 만큼 더해서 Strike수를 반환할 수 있다.
- 숫자가 위치한 곳에는 없지만 다른 곳에 해당 수가 존재하는 만큼 더해서 Ball수를 반환할 수 있다.

<br>

#### 3. Computer

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`API를 사용해 값을 저장한다.
- `Randoms` API에서 이전에 입력한 숫자를 입력할 경우 다시 입력하도록 요청한다.
- 입력된 Numbers를 가지고 Answer와 매칭하여 GameResult를 반환할 수 있다.
- GameResult는 3 스트라이크일 경우 게임이 종료됨을 판단한다.
- GameResult가 종료되었다면 게임 재시작에 대한 명령을 시작해야 한다.
    - 게임을 종료하였을 때 1을 누르면 게임이 재시작되어야 한다.
    - 게임을 종료하였을 때 2를 누르면 Application이 종료되어야 한다.

<br>

## 🖥 출력

#### 5. InputView

- `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용해 값을 입력받는다.
-  숫자를 입력받을 때 다음과 같은 입력창을 출력한다.

```
숫자를 입력해주세요 :
```

- 게임이 종료되면 재시작, 종료를 묻는 입력창을 출력하다.

```
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```

#### 6. OutputView

- 맞은 개수에 따라 스트라이크, 볼, 낫싱 등과 같이 출력한다.

```
1볼 1스트라이크
3스트라이크 
낫싱
```

- 3개의 숫자를 모두 맞출 경우 다음과 같이 출력한다.

```
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```