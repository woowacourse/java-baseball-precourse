
/**
 * 각종 유틸 기능을 제공하는 클래스
 * 
 * @version			1.00 2019년 3월 24일
 * @author 			Wonseok Choi
 */
public class Utils {

	/**
	 * 세자리수를 배열로 바꿔주는 메소드
	 * 
	 * @param nums
	 * @return int[]
	 */
	public static int[] numsToArr(int nums) {
		int[] curArr = new int[10];
		int tempNum = nums;

		for (int i = 0; i < 3; i++) {
			curArr[i] = tempNum % 10;
			tempNum = tempNum / 10;
		}
		return curArr;
	}

	/**
	 * 두 배열을 통합해주는 메소드
	 * 
	 * @param int[], int[]
	 * @return int[]
	 */
	public static int[] mergeArrs(int[] comNumArr, int[] myNumArr) {
		int[] mergedArr = new int[10];
		int count = 0;
		for (int comNum : comNumArr) {
			mergedArr[comNum] = (count + 1) * -1;
			count++;
		}

		for (int i = 0; i < 3; i++) {
			int myNumVal = myNumArr[i];
			int comNumVal = mergedArr[myNumVal];
			
			if ((comNumVal != 0) && (comNumVal == (i + 1) * -1)) {
				mergedArr[myNumVal] = 1;
			} else if ((comNumVal != 0) && (comNumVal != (i + 1) * -1)) {
				mergedArr[myNumVal] = 2;
			} else {
				mergedArr[myNumVal] = 3;
			}
		}
		return mergedArr;
	}
}
