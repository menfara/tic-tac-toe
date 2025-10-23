package org.example.model.board;

public class TicTacToeBoard implements GameBoard {

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isCellEmpty(int row, int col) {
        return false;
    }

    @Override
    public void placeMark(int row, int col, char playerMark) {

    }

    @Override
    public char getMarkAt(int row, int col) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isFull() {
        return false;
    }
}