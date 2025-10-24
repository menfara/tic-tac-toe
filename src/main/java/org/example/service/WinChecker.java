package org.example.service;

import org.example.model.board.GameBoard;

public interface WinChecker {

    boolean hasWin(GameBoard board, char mark);

}
