package org.example.service;

import org.example.model.Move;
import org.example.model.board.GameBoard;

public interface MoveValidator {

    boolean isValid(GameBoard board, Move move);

}
