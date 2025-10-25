package org.example.service.impl;

import org.example.model.board.GameBoard;
import org.example.service.WinChecker;

public class TicTacToeWinChecker implements WinChecker {

    @Override
    public boolean hasWin(GameBoard board, char mark) {
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            if (line(board, i, 0, 0, 1, mark, n) || line(board, 0, i, 1, 0, mark, n)) return true;
        }
        return line(board, 0, 0, 1, 1, mark, n) || line(board, 0, n - 1, 1, -1, mark, n);
    }

    private boolean line(GameBoard b, int r, int c, int dr, int dc, char m, int n) {
        for (int i = 0; i < n; i++) if (b.getMarkAt(r + i * dr, c + i * dc) != m) return false;
        return true;
    }
}