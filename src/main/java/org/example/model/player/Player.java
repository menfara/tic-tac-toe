package org.example.model.player;

import org.example.model.board.GameBoard;

public interface Player {

    char getMark();

    int[] makeMove(GameBoard board);

}
