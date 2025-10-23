package org.example.view;

import org.example.model.board.GameBoard;
import org.example.model.player.Player;

public class ConsoleView implements GameView {
    @Override
    public void renderBoard(GameBoard board) {

    }

    @Override
    public void displayWelcomeMessage() {

    }

    @Override
    public int[] getPlayerMove(Player player) {
        return new int[0];
    }

    @Override
    public void displayWinner(Player winner) {

    }

    @Override
    public void displayDraw() {

    }

    @Override
    public void displayInvalidMove() {

    }

    @Override
    public void displayComputerMove(int[] move) {

    }
}
