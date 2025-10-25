package org.example.view;

import org.example.exceptions.PlayerNotExistsException;
import org.example.model.board.GameBoard;
import org.example.model.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class ConsoleView implements GameView {
    private final Scanner scanner = new Scanner(in);

    @Override
    public void displayWelcomeMessage() {
        out.println("Welcome to Tic-Tac-Toe!");
    }

    @Override
    public void renderBoard(GameBoard board) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char mark = board.getMarkAt(i, j);
                sb.append(" ").append(mark).append(" ");
                if (j < size - 1) sb.append("|");
            }
            sb.append("\n");
            if (i < size - 1) sb.append("---+---+---\n");
        }
        sb.append("\n");
        out.print(sb);
    }

    @Override
    public int[] getPlayerMove(Player player) {
        checkExistsPlayerOrThrow(player);
        while (true) {
            try {
                out.printf("Player '%c', enter a cell number (1-9): ", player.getMark());
                int cellNumber = scanner.nextInt();
                if (cellNumber >= 1 && cellNumber <= 9) {
                    return mapNumberToCoords(cellNumber);
                } else {
                    out.println("Error! Please enter a number between 1 and 9.");
                }
            } catch (InputMismatchException e) {
                out.println("Error! Input must be a number.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void displayInvalidMove() {
        out.println("Invalid move! The cell is occupied or out of bounds. Try again.");
    }

    @Override
    public void displayWinner(Player winner) {
        checkExistsPlayerOrThrow(winner);
        out.printf("Congratulations! Player '%c' wins!%n", winner.getMark());
    }

    @Override
    public void displayDraw() {
        out.println("The game ended in a draw!");
    }

    @Override
    public void displayComputerMove(int[] move) {
        out.printf("Computer moved to cell %d.%n", mapCoordsToNumber(move[0], move[1]));
    }

    private int[] mapNumberToCoords(int number) {
        int zeroBased = number - 1;
        int row = zeroBased / 3;
        int col = zeroBased % 3;
        return new int[]{row, col};
    }

    private int mapCoordsToNumber(int row, int col) {
        return row * 3 + col + 1;
    }

    private void checkExistsPlayerOrThrow(Player player) {
        if (player == null) {
            throw new PlayerNotExistsException("Player is null");
        }
    }
}
