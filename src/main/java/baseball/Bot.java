package baseball;

public class Bot {

    private NumberCreator numberCreator;
    private Inputor inputor;
    private InputValidator validator;
    private Printer printer;
    private Checker checker;

    public void start() {
        // 랜덤 숫자 생성기 생성.
        numberCreator = new NumberCreator();
        // 입력기 생성.
        inputor = new Inputor();
        // 입력 값 검증기 생성.
        validator = new InputValidator();
        // 출력기 생성.
        printer = new Printer();
        // 정답 체커 생성.
        checker = new Checker();

        while (true) {
            execute();
            if(inputor.inputRestart().equals("2")) break;
        }
    }

    private void execute()  {
        String answer = numberCreator.create();

        while (true) {
            String input = inputor.inputData();
            validator.Validate(input);

            Data data = checker.check(answer, input);

            printer.printData(data);
            if (data.isCorrect()) {
                break;
            }
        }
    }

}
