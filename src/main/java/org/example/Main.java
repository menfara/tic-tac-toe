package org.example;

import org.example.controller.GameRunner;
import org.example.model.board.GameBoard;
import org.example.model.board.TicTacToeBoard;
import org.example.model.player.ComputerPlayer;
import org.example.model.player.HumanPlayer;
import org.example.model.player.Player;
import org.example.service.BoardService;
import org.example.service.GameService;
import org.example.service.MoveValidator;
import org.example.service.WinChecker;
import org.example.service.impl.BasicMoveValidator;
import org.example.service.impl.TicTacToeBoardService;
import org.example.service.impl.TicTacToeGameService;
import org.example.service.impl.TicTacToeWinChecker;
import org.example.view.ConsoleView;
import org.example.view.GameView;

public class Main {

    public static void main(String[] args) {
        GameBoard board = new TicTacToeBoard(3);
        GameView view = new ConsoleView();
        Player player1 = new HumanPlayer('X');
        Player player2 = new ComputerPlayer('O');

        BoardService boardService = new TicTacToeBoardService(board);
        MoveValidator moveValidator = new BasicMoveValidator();
        WinChecker winChecker = new TicTacToeWinChecker();
        GameService gameService = new TicTacToeGameService(boardService, view, player1, player2, moveValidator, winChecker);

        new GameRunner(gameService).start();
    }
}
