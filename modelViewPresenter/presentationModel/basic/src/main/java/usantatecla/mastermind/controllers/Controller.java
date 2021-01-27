package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.Result;

public abstract class Controller {

    protected Board board;

    Controller(Board board) {
        this.board = board;
    }

    public int getWidth() {
        return Result.WIDTH;
    }

}
