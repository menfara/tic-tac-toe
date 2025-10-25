package org.example.service.impl;

import org.example.model.Move;
import org.example.model.board.GameBoard;
import org.example.service.MoveValidator;

public class BasicMoveValidator implements MoveValidator {

    @Override
    public boolean isValid(GameBoard board, Move move) {
        int size = board.getSize();
        int r = move.row(), c = move.col();
        return r >= 0 && r < size && c >= 0 && c < size && board.isCellEmpty(r, c);
    }
}
