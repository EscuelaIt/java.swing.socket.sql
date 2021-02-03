package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.StartView;

public class StartController extends Controller {

    public StartController(Board board, ViewFactory viewFactory) {
        super(board, viewFactory);
    }

    public void control(){
        new StartView().write();
        this.writeBoard();
    }

}
