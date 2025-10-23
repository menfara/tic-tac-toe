package org.example.model.board;

public interface GameBoard {
    int getSize();

    boolean isCellEmpty(int row, int col);

    void placeMark(int row, int col, char playerMark);

    char getMarkAt(int row, int col);

    void clear();

    boolean isFull();
}
