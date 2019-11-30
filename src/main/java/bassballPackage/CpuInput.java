package bassballPackage;

public class CpuInput {
	static int randomGeneration() {		//1~9사이 정수 랜덤생성
		return (int)(Math.random() * 9) + 1;
	}
	
	public static void main(String[] args) {
		//randomGenereation test
		System.out.println(randomGeneration());

	}

}
