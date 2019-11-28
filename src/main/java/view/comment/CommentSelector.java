package view.comment;

import computer.result.Results;

@FunctionalInterface
public interface CommentSelector {
    boolean support(Results results);
}
