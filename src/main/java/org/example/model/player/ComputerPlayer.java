package org.example.model.player;

import org.example.model.board.GameBoard;

public class ComputerPlayer implements Player {
    @Override
    public char getMark() {
        return 0;
    }

    @Override
    public int[] makeMove(GameBoard board) {
        return new int[0];
    }
}
