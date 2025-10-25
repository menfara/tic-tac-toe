package org.example.model.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.model.board.GameBoard;

import java.util.Random;

@RequiredArgsConstructor
@Getter
public class ComputerPlayer implements Player {

    private final char mark;
    private final Random random = new Random();

    @Override
    public int[] makeMove(GameBoard board) {
        int size = board.getSize();
        int[] move;
        do {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            move = new int[]{row, col};
        } while (!board.isCellEmpty(move[0], move[1]));
        return move;
    }
}
