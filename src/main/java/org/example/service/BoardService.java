package org.example.service;

import org.example.model.Move;
import org.example.model.board.GameBoard;

public interface BoardService {

    GameBoard board();

    boolean isValid(Move move);

    void apply(Move move);

    boolean isFull();

    int size();

    char at(int row, int col);

}
