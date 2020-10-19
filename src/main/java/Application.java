import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Application {
  private static final int ENDING_USERINPUT = 2;
  private static final int INPUT_LENGTH = 3;
  private static final int CORRECT_STRIKE_CONDITION = 3;
  private static final int MAX_NUMBER = 9;
  private static final int MAX_RANDOM_INDEX = 8;
  private static final String USERINPUT_REQUEST = "숫자를 입력해주세요 : ";
  private static final String NOTHING = "낫싱";
  private static final String ENDING_PHRASE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
  private static final String REGAME_PHRASE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";
  private static final String STRIKE = "스트라이크 ";
  private static final String BALL = "볼";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean stop = false;

    do {
      ArrayList<Integer> input = new ArrayList<Integer>();
      ArrayList<Integer> generatedThreeNumbersArrayList = generateRandomNumbersArrayList();

      outputView(USERINPUT_REQUEST);
      String userInput = scanner.nextLine();

      for (int i = 0; i < INPUT_LENGTH; i++) {
        int inputNumber = parseCharToInt(userInput.charAt(i));
        addElementToArrayList(input, inputNumber);
      }

      int numberOfStrikes = getStrikeCount(generatedThreeNumbersArrayList, input);
      int numberOfBalls = getBallCount(generatedThreeNumbersArrayList, input);

      if (numberOfStrikes == 0 && numberOfBalls == 0) {
        outputViewWithNewLine(NOTHING);
      } else if (numberOfStrikes == CORRECT_STRIKE_CONDITION) {
        outputViewWithNewLine(ENDING_PHRASE);
        outputView(REGAME_PHRASE);
        int restart = Integer.parseInt(scanner.nextLine());
        if (restart == ENDING_USERINPUT) {
          stop = true;
        }
      } else {
        String strikeBallMessage = numberOfStrikes + STRIKE + numberOfBalls + BALL;
        outputViewWithNewLine(strikeBallMessage);
      }
    } while (!stop);
    scanner.close();
  }

  static void outputViewWithNewLine(String message) {
    System.out.println(message);
  }

  static void outputView(String message) {
    System.out.print(message);
  }

  static ArrayList<Integer> generateRandomNumbersArrayList() {
    ArrayList<Integer> nCandidates = new ArrayList<Integer>(MAX_NUMBER);
    for (int i = 1; i <= MAX_NUMBER; i++)
      nCandidates.add(i);

    ArrayList<Integer> arrRandomNumbersList = new ArrayList<Integer>();
    Random randomGenerator = new Random();

    for (int i = 0; i < INPUT_LENGTH; i++) {
      int randomNumberIndex = randomGenerator.nextInt(MAX_RANDOM_INDEX);
      addElementToArrayList(arrRandomNumbersList, getArrayListElementByIndex(nCandidates, randomNumberIndex));
      removeElementFromArrayListByIndex(nCandidates, randomNumberIndex);
    }

    return arrRandomNumbersList;
  }

  static int parseCharToInt(char charInput) {
    return Integer.parseInt(charInput + "");
  }

  static void addElementToArrayList(ArrayList<Integer> arrayList, int element) {
    arrayList.add(element);
  }

  static void removeElementFromArrayListByIndex(ArrayList<Integer> arrayList, int index) {
    arrayList.remove(index);
  }

  static int getArrayListSize(ArrayList<Integer> arrayList) {
    return arrayList.size();
  }

  static int getArrayListElementByIndex(ArrayList<Integer> arrayList, int index) {
    return arrayList.get(index);
  }

  static boolean compare(int element1, int element2) {
    return element1 == element2;
  }

  static int getStrikeCount(ArrayList<Integer> randomNumbersArrayList, ArrayList<Integer> userInput) {
    int strikeCount = 0;
    for (int i = 0; i < getArrayListSize(randomNumbersArrayList); i++) {
      if (isStrike(randomNumbersArrayList, userInput, i)) {
        strikeCount++;
      }
    }
    return strikeCount;
  }

  static boolean isStrike(ArrayList<Integer> randomNumbersArrayList, ArrayList<Integer> userInput,
      int randomNumberIndex) {
    boolean isStrike = false;
    for (int i = 0; i < getArrayListSize(userInput); i++) {
      if (compare(getArrayListElementByIndex(randomNumbersArrayList, randomNumberIndex),
          getArrayListElementByIndex(userInput, i)) && randomNumberIndex == i) {
        isStrike = true;
        break;
      }
    }

    return isStrike;
  }

  static int getBallCount(ArrayList<Integer> randomNumbersArrayList, ArrayList<Integer> userInput) {
    int ballCount = 0;
    for (int i = 0; i < getArrayListSize(randomNumbersArrayList); i++) {
      if (isBall(randomNumbersArrayList, userInput, i)) {
        ballCount++;
      }
    }
    return ballCount;
  }

  static boolean isBall(ArrayList<Integer> randomNumbersArrayList, ArrayList<Integer> userInput,
      int randomNumberIndex) {
    boolean isBall = false;
    for (int i = 0; i < getArrayListSize(userInput); i++) {
      if (compare(getArrayListElementByIndex(randomNumbersArrayList, randomNumberIndex),
          getArrayListElementByIndex(userInput, i)) && randomNumberIndex != i) {
        isBall = true;
        break;
      }
    }
    return isBall;
  }
}