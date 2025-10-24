package org.example.view;

import org.example.model.board.GameBoard;
import org.example.model.player.Player;

public interface GameView {

    void renderBoard(GameBoard board);

    void displayWelcomeMessage();

    int[] getPlayerMove(Player player);

    void displayWinner(Player winner);

    void displayDraw();

    void displayInvalidMove();

    void displayComputerMove(int[] move);

}
