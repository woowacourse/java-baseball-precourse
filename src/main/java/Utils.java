
public class Utils {

	public static int[] numsToArr(int nums) {
		int[] curArr = new int[10];
		int tempNum = nums;

		for (int i = 0; i < 3; i++) {
			curArr[i] = tempNum % 10;
			tempNum = tempNum / 10;
		}
		return curArr;
	}

	public static int[] mergeArrs(int[] comNumArr, int[] myNumArr) {
		int[] mergedArr = new int[9];
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
