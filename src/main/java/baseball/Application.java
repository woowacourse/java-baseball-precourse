package baseball;

import java.util.List;

import dto.CompareResult;
import service.Computer;
import camp.nextstep.edu.missionutils.Console;
import service.Converter;
import service.UserInterface;

public class Application {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.startUserInterface();
    }

}
