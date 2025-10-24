package org.example.model.board;

public abstract class GameBoard {

    public static final char EMPTY_CELL = ' ';
    protected final int size;
    protected final char[][] board;

    public GameBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
    }

    public abstract int getSize();

    public abstract boolean isCellEmpty(int row, int col);

    public abstract void placeMark(int row, int col, char playerMark);

    public abstract char getMarkAt(int row, int col);

    public abstract void clear();

    public abstract boolean isFull();
}
