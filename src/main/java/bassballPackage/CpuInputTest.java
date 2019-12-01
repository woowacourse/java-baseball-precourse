package bassballPackage;

import bassballPackage.CpuInput;

public class CpuInputTest {

	public static void main(String[] args) {
		//randomGenereation test
		System.out.println("==randomGeneration test==");
		System.out.println(CpuInput.randomGeneration());
		
		//cpuInput test
		System.out.println("==cpuInput test==");
		int[] testArray = CpuInput.cpuInput();
		System.out.println(testArray[0]);
		System.out.println(testArray[1]);
		System.out.println(testArray[2]);
	}

}
