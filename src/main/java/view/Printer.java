package view;

import controller.domain.BaseballStatus;

public interface Printer {

    String printInputDescription();
    String printStatus(BaseballStatus dto);
    String printCorrect();
}
