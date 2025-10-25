package org.example.view;

import org.example.model.board.GameBoard;
import org.example.model.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements GameView {
    private static final int MIN_CELL = 1;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayWelcomeMessage() {
        System.out.println("Welcome to Tic-Tac-Toe!");
    }

    @Override
    public void renderBoard(GameBoard board) {
        System.out.println();
        int size = board.getSize();
        String separator = buildSeparator(size);

        for (int i = 0; i < size; i++) {
            printRow(board, i);
            if (i < size - 1) {
                System.out.println(separator);
            }
        }
        System.out.println();
    }

    private String buildSeparator(int size) {
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < size; i++) {
            separator.append("---");
            if (i < size - 1) {
                separator.append("+");
            }
        }
        return separator.toString();
    }

    private void printRow(GameBoard board, int row) {
        int size = board.getSize();
        for (int col = 0; col < size; col++) {
            char mark = board.getMarkAt(row, col);
            String cell = (mark == ' ') ? " " : String.valueOf(mark);
            System.out.print(" " + cell + " ");

            if (col < size - 1) {
                System.out.print("|");
            }
        }
        System.out.println();
    }

    @Override
    public int[] getPlayerMove(Player player) {
        Integer cellNumber = null;

        while (cellNumber == null) {
            System.out.printf("Player '%c', enter a cell number (%d-%d): ",
                    player.getMark(), MIN_CELL, getMaxCell());
            cellNumber = readCellNumber();
        }

        return mapNumberToCoords(cellNumber);
    }

    private Integer readCellNumber() {
        try {
            int input = scanner.nextInt();
            if (input >= MIN_CELL && input <= getMaxCell()) {
                return input;
            }
            System.out.printf("Error! Please enter a number between %d and %d.%n", MIN_CELL, getMaxCell());
        } catch (InputMismatchException e) {
            System.out.println("Error! Input must be a number.");
            scanner.nextLine();
        }
        return null;
    }

    private int getMaxCell() {
        return 9; // Для стандартной доски 3x3
    }

    @Override
    public void displayInvalidMove() {
        System.out.println("Invalid move! The cell is occupied or out of bounds. Try again.");
    }

    @Override
    public void displayWinner(Player winner) {
        System.out.printf("Congratulations! Player '%c' wins!%n", winner.getMark());
    }

    @Override
    public void displayDraw() {
        System.out.println("The game ended in a draw!");
    }

    @Override
    public void displayComputerMove(int[] move) {
        System.out.printf("Computer moved to cell %d.%n", mapCoordsToNumber(move[0], move[1]));
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
}