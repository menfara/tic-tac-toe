package org.example.model.board;

import org.example.exceptions.CellIsOccupiedException;
import org.example.exceptions.InvalidBoardSizeException;
import org.example.exceptions.InvalidCellCoordinatesException;

public class TicTacToeBoard extends GameBoard {

    public TicTacToeBoard(int size) {
        super(size);
        checkBoardSizeOrThrow(size);
        clear();
    }

    private void checkBoardSizeOrThrow(int size) {
        if (size <= 1) {
            throw new InvalidBoardSizeException("Invalid board size");
        }
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
    public int getSize() {
        return size;
    }

    @Override
    public boolean isCellEmpty(int row, int col) {
        checkCellCoordinatesOrThrow(row, col);
        return board[row][col] == EMPTY_CELL;
    }

    @Override
    public void placeMark(int row, int col, char playerMark) {
        checkCellCoordinatesOrThrow(row, col);
        cellIsEmptyOrThrow(row, col);
        board[row][col] = playerMark;
    }

    @Override
    public char getMarkAt(int row, int col) {
        checkCellCoordinatesOrThrow(row, col);
        return board[row][col];
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

    private boolean isValidCellIndexes(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    private void checkCellCoordinatesOrThrow(int row, int col) {
        if (!isValidCellIndexes(row, col)) {
            throw new InvalidCellCoordinatesException("Entered invalid cell coordinates");
        }
    }

    private void cellIsEmptyOrThrow(int row, int col) {
        if (!isCellEmpty(row, col)) {
            throw new CellIsOccupiedException("Cell is occupied");
        }
    }
}