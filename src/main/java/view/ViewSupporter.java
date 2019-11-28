package view;

import computer.result.Results;

@FunctionalInterface
public interface ViewSupporter {
    boolean support(Results results);
}
