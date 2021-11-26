## 미션 - 숫자 야구 게임

우아한테크코스 1주차 미션

### 💁‍♂️ Wiki & Notion 

---
- 📌 [미션 내용](https://github.com/maprk/java-baseball-precourse/wiki/Mission-Contents)
- 📅 [과제 계획](https://github.com/maprk/java-baseball-precourse/wiki/Plan-List)
- 🔍 [문제 분석](https://github.com/maprk/java-baseball-precourse/wiki/Problem-Analysis)
- 📎 [참고 자료](https://github.com/maprk/java-baseball-precourse/wiki/Reference)
- 📚 [공부한 내용](https://github.com/maprk/java-baseball-precourse/wiki/Study)
- 🗒 [개발 일지](https://github.com/maprk/java-baseball-precourse/progress)
- ✔️ [Notion Link](https://tricolor-silk-b6e.notion.site/woowacourse-cd272b35cbfc448d88a47d1a338fee14)

### 구현할 기능 목록

<details>
<summary>입출력 기능</summary>

사용자 숫자 및 재시작 여부 숫자들을 입력하거나, Exception 메시지 혹은 Notification 메시지를 담고 있는 클래스이다.

- [Input Class](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/com/io/Input)
- [Output Class](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/com/io/Output)

</div>
</details>

<details>
<summary>컴퓨터 숫자 및 사용자 숫자 생성</summary>

컴퓨터 숫자(랜덤)를 생성 하고, 사용자 숫자에 대한 검증 및 타입 변환이 이루어지는 클래스이다.

- [BaseballFactory](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/com/model/BaseballFactory)

</div>
</details>

<details>
<summary>결과 생성</summary>

최종적으로 볼 개수, 스트라이크 개수 등 원래의 값에 요구사항에 맞는 값으로 변환이 이루어지는 클래스이다.

- [Result](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/com/model/Result)

</div>
</details>

<details>
<summary>숫자 야구 게임 관리</summary>

최초로 게임이 시작되는 곳, 그리고 재시작 여부를 판단하는 클래스이다.

- [BaseballGameManager](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/BaseballGameManager)

</div>
</details>

<details>
<summary>숫자 야구 게임 시작</summary>

BaseballGameManager에서 게임이 시작되면 게임의 Service는 이곳에서 이루어진다.

- [BaseballGame](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/BaseballGame)

</div>
</details>


<details>
<summary>볼 / 스트라이크 카운트 체크</summary>

볼 / 카운트 개수를 체크하는 클래스다.

- [CheckBaseballNumbers](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/CheckBaseballNumbers)

</div>
</details>


<details>
<summary>컴퓨터 숫자 생성</summary>

Factory에는 사용자 숫자 및 컴퓨터 숫자를 생성하는 곳이 같이 있기때문에 컴퓨터 숫자만 만드는 클래스이다.

- [Computer](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/Computer)

</div>
</details>


<details>
<summary>재시작 여부</summary>

재시작 여부를 판단하는 클래스이다. (입력 값에 대한 검증)

- [RestartFlag](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/RestartFlag)

</div>
</details>