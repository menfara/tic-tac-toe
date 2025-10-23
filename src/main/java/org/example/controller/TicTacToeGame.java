package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.board.GameBoard;
import org.example.model.player.HumanPlayer;
import org.example.model.player.Player;
import org.example.view.GameView;


@RequiredArgsConstructor
public class TicTacToeGame implements Game {
    private final GameBoard board;
    private final GameView view;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;
    private Player winner;

    @Override
    public void start() {
        this.currentPlayer = player1;
        view.displayWelcomeMessage();

        while (true) {
            view.renderBoard(board);
            handlePlayerTurn();

            if (checkForWin()) {
                view.renderBoard(board);
                view.displayWinner(winner);
                break;
            }
            if (board.isFull()) {
                view.renderBoard(board);
                view.displayDraw();
                break;
            }
            switchPlayer();
        }
    }

    private void handlePlayerTurn() {
        int[] move;
        if (currentPlayer instanceof HumanPlayer) {
            while (true) {
                move = view.getPlayerMove(currentPlayer);
                if (isValidMove(move)) break;
                else view.displayInvalidMove();
            }
        } else {
            move = currentPlayer.makeMove(board);
            view.displayComputerMove(move);
        }
        board.placeMark(move[0], move[1], currentPlayer.getMark());
    }

    private boolean isValidMove(int[] move) {
        int row = move[0];
        int col = move[1];
        return row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize() && board.isCellEmpty(row, col);
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean checkForWin() {
        char mark = currentPlayer.getMark();
        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            if (checkLine(i, 0, 0, 1, mark) || checkLine(0, i, 1, 0, mark)) {
                this.winner = currentPlayer;
                return true;
            }
        }

        if (checkLine(0, 0, 1, 1, mark) || checkLine(0, size - 1, 1, -1, mark)) {
            this.winner = currentPlayer;
            return true;
        }

        return false;
    }

    private boolean checkLine(int r, int c, int dr, int dc, char mark) {
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getMarkAt(r + i * dr, c + i * dc) != mark) return false;
        }
        return true;
    }
}
