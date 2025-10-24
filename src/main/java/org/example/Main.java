package org.example;

import org.example.controller.Game;
import org.example.controller.TicTacToeGame;
import org.example.exceptions.TicTacToeException;
import org.example.model.board.GameBoard;
import org.example.model.board.TicTacToeBoard;
import org.example.model.player.ComputerPlayer;
import org.example.model.player.HumanPlayer;
import org.example.model.player.Player;
import org.example.view.ConsoleView;
import org.example.view.GameView;

public class Main {
    public static void main(String[] args) {

        try {
            GameBoard board = new TicTacToeBoard(3);
            GameView view = new ConsoleView();
            Player player1 = new HumanPlayer('X');
            Player player2 = new ComputerPlayer('O');
            Game ticTacToeGame = new TicTacToeGame(board, view, player1, player2);
            ticTacToeGame.start();
        } catch (TicTacToeException ex) {
            System.err.println(ex.getMessage() + ex);
            System.exit(1);
        }
    }
}