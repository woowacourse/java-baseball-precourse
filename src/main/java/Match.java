/**
 * Match 클래스는 두 입력값을 비교하는 클래스 입니다
 *
 * @version         1.0 2019년 3월 26일
 * @author          이중혁
 */

public class Match {

    /* 난수와 사용자 입력값을 비교하여 스트라이크,볼 상태로 저장하는 메소드 */
    public static int[] matchNumber(int randomNumber, int userNumber){

        int[] baseballResult = new int[2];      // 스트라이크, 볼 값을 저장하기 위한 배열 생성

        int firstRN = randomNumber / 100;                                 // 난수 1번째 숫자
        int secondRN = (randomNumber - (firstRN*100)) / 10;               // 난수 2번째 숫자
        int thirdRN = randomNumber - (firstRN*100) - (secondRN*10);       // 난수 3번째 숫자

        int firstUN = userNumber/100;                                   // 사용자 1번째 숫자
        int secondUN = (userNumber - (firstUN*100)) / 10;               // 사용자 2번쨰 숫자
        int thirdUN = userNumber - (firstUN*100) - (secondUN*10);       // 사용자 3번째 숫자


        if (firstRN == firstUN){

            /* 난수의 첫번째와 사용자의 첫번째 수가 같을때 */
            baseballResult[0] += 1;         /* 스트라이크 1증가 */
        }

        if (firstRN == secondUN){

            /* 난수의 첫번째와 사용자의 두번째 수가 같을때 */
            baseballResult[1] += 1;         /* 볼 1증가 */
        }

        if (firstRN == thirdUN){

            /* 난수의 첫번째와 사용자의 세번째 수가 같을때 */
            baseballResult[1] += 1;         /* 볼 1증가 */
        }

        if (secondRN == secondUN){

            /* 난수의 두번째와 사용자의 두번째 수가 같을때 */
            baseballResult[0] += 1;         /* 스트라이크 1증가 */
        }

        if (secondRN == firstUN){

            /* 난수의 두번째와 사용자의 첫번째 수가 같을때 */
            baseballResult[1] += 1;         /* 볼 1증가 */
        }

        if (secondRN == thirdUN){

            /* 난수의 두번째와 사용자의 세번째 수가 같을때 */
            baseballResult[1] += 1;         /* 볼 1증가 */
        }

        if (thirdRN == thirdUN){

            /* 난수 세번째와 사용자의 세번째 수가 같을때 */
            baseballResult[0] += 1;         /* 스트라이크 1증가 */
        }
        if (thirdRN == firstUN){

            /* 난수 세번째와 사용자의 첫번째 수가 같을때 */
            baseballResult[1] += 1;         /* 볼 1증가 */
        }
        if (thirdRN == secondUN){

            /* 난수 세번째와 사용자의 두번째 수가 같을때 */
            baseballResult[1] += 1;         /* 볼 1증가 */
        }

        return baseballResult;      // 저장된 baseballResult배열 반환
    }

    /* 3스트라이크 판별하는 기능을 가진 메소드 */
    boolean getBaseballResult(int[] baseballResult){

        boolean findOut = false;        // 3스트라이크인지 아닌지 상태를 저장하는 변수

        if(baseballResult[0] == 3){

            /* 3스트라이크 일 경우 */
            findOut = true;
        }

        return  findOut;
    }
}
