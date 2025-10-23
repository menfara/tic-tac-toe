package org.example.model.board;

public class TicTacToeBoard implements GameBoard {
    private final int size;
    private final char[][] board;
    private static final char EMPTY_CELL = ' ';

    public TicTacToeBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
        clear();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == EMPTY_CELL;
    }

    @Override
    public void placeMark(int row, int col, char playerMark) {
        if (row >= 0 && row < size && col >= 0 && col < size && isCellEmpty(row, col)) {
            board[row][col] = playerMark;
        }
    }

    @Override
    public char getMarkAt(int row, int col) {
        return board[row][col];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
}