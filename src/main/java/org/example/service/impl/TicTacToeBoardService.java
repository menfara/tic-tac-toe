package org.example.service.impl;


import lombok.RequiredArgsConstructor;
import org.example.model.Move;
import org.example.model.board.GameBoard;
import org.example.service.BoardService;


@RequiredArgsConstructor
public class TicTacToeBoardService implements BoardService {

    private final GameBoard board;

    @Override
    public GameBoard board() {
        return board;
    }

    @Override
    public boolean isValid(Move move) {
        return move.row() >= 0 && move.row() < board.getSize() && move.col() >= 0 && move.col() < board.getSize() && board.isCellEmpty(move.row(), move.col());
    }

    @Override
    public void apply(Move move) {
        board.placeMark(move.row(), move.col(), move.mark());
    }

    @Override
    public boolean isFull() {
        return board.isFull();
    }

    @Override
    public int size() {
        return board.getSize();
    }

    @Override
    public char at(int row, int col) {
        return board.getMarkAt(row, col);
    }
}