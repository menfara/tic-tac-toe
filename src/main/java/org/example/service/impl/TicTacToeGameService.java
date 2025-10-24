package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Move;
import org.example.model.player.HumanPlayer;
import org.example.model.player.Player;
import org.example.service.BoardService;
import org.example.service.GameService;
import org.example.service.MoveValidator;
import org.example.service.WinChecker;
import org.example.view.GameView;

@RequiredArgsConstructor
public class TicTacToeGameService implements GameService {

    private final BoardService boardService;
    private final GameView view;
    private final Player player1;
    private final Player player2;
    private final MoveValidator moveValidator;
    private final WinChecker winChecker;

    private Player current;

    @Override
    public void start() {
        current = player1;
        view.displayWelcomeMessage();


        while (true) {
            view.renderBoard(boardService.board());
            Move move = nextMove();
            boardService.apply(move);


            if (winChecker.hasWin(boardService.board(), current.getMark())) {
                view.renderBoard(boardService.board());
                view.displayWinner(current);
                return;
            }
            if (boardService.isFull()) {
                view.renderBoard(boardService.board());
                view.displayDraw();
                return;
            }
            switchPlayer();
        }
    }

    private Move nextMove() {
        int[] mv;
        if (current instanceof HumanPlayer) {
            do {
                mv = view.getPlayerMove(current);
                if (!moveValidator.isValid(boardService.board(), new Move(mv[0], mv[1], current.getMark()))) {
                    view.displayInvalidMove();
                    mv = null;
                }
            } while (mv == null);
        } else {
            mv = current.makeMove(boardService.board());
            view.displayComputerMove(mv);
        }
        return new Move(mv[0], mv[1], current.getMark());
    }

    private void switchPlayer() {
        current = (current == player1) ? player2 : player1;
    }
}
