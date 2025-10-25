package org.example.view;

import org.example.exceptions.PlayerNotExistsException;
import org.example.model.board.GameBoard;
import org.example.model.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements GameView {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayWelcomeMessage() {
        System.out.println("Welcome to Tic-Tac-Toe!");
    }

    @Override
    public void renderBoard(GameBoard board) {
        System.out.println();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(" " + board.getMarkAt(i, j) + " ");
                if (j < board.getSize() - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.getSize() - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    @Override
    public int[] getPlayerMove(Player player) {
        checkExistsPlayerOrThrow(player);
        while (true) {
            try {
                System.out.printf("Player '%c', enter your move (row and column, e.g., 1 2): ", player.getMark());
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                return new int[]{row, col};
            } catch (InputMismatchException e) {
                System.out.println("Error! Please enter two numbers separated by a space.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void displayInvalidMove() {
        System.out.println("Invalid move! The cell is occupied or out of bounds. Try again.");
    }

    @Override
    public void displayWinner(Player winner) {
        checkExistsPlayerOrThrow(winner);
        System.out.printf("Congratulations! Player '%c' wins!%n", winner.getMark());
    }

    @Override
    public void displayDraw() {
        System.out.println("The game ended in a draw!");
    }

    @Override
    public void displayComputerMove(int[] move) {
        System.out.printf("Computer moved to position (%d, %d).%n", move[0] + 1, move[1] + 1);
    }

    private void checkExistsPlayerOrThrow(Player player) {
        if (player == null) {
            throw new PlayerNotExistsException("Player is null");
        }
    }
}
