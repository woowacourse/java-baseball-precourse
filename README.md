# 미션 - 숫자 야구 게임

## 구현할 기능 목록

- 세자리의 난수 생성
    - `camp.nextstep.edu.missionutils`의 `Randoms` API 활용
    - 각 자리의 수가 모두 달라야한다
    - 각 자리의 수가 1 ~ 9 사이의 수
- 게임 실행
    - `Application` 실행 시 콘솔 창 실행
    - 게임 안내 멘트
        - 게임 시작 직후
            - "숫자를 입력해주세요 : " 출력
        - 플레이어의 숫자 입력 이후
            - 틀린 경우 : 볼, 스트라이크, 낫싱 등의 **힌트** 제공
            - 맞은 경우 : "3개의 숫자를 모두 맞히셨습니다! 게임 종료 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 두줄에 걸쳐 출력
        - 게임 끝난 이후
            - "3개의 숫자를 모두 맞히셨습니다! 게임 종료 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 두줄에 걸쳐 출력
- 정답 체크 (입력값 : 플레이어가 입력한 세자리 수)
    - 스트라이크 개수 세기
        - 스트라이크 개수가 3개이면 **바로 게임 끝내도록**
    - 볼 개수 세기
    - 스트라이크, 볼 개수가 모두 0이면 "낫싱", 아니면 볼-스트라이크 순서대로 힌트 제공
- 예외 처리
    - 잘못된 값 입력 시 `IllegalArgumentException`
    - 게임 중 잘못된 값 입력
        - 입력된 수가 세자리 수가 아닐 때
        - 공백, 특수문자, 문자 등이 입력 되었을 때 (숫자만 입력되어야 한다)
        - 입력 값의 각 자리수가 모두 다른지 확인
        - 입력 값에 0이 포함된 경우
    - 게임이 끝나고 잘못된 값 입력
        - 끝났을 때 숫자 1 또는 숫자 2만 입력되어야 한다
    - 콘솔이 강제로 종료되었을 때, 게임이 정상 종료되도록 해야한다
