package org.example.model.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.model.board.GameBoard;

@RequiredArgsConstructor
@Getter
public class HumanPlayer implements Player {
    private final char mark;

    @Override
    public int[] makeMove(GameBoard board) {
        return null;
    }
}
