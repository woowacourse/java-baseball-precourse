package controller;

import service.BaseballService;

public class BaseballController {

    private BaseballService baseballService = new BaseballService();

    public void run(){
        initBasballGame();

    }
    public void initBasballGame(){
        baseballService.initBaseballGame();
    }


}
