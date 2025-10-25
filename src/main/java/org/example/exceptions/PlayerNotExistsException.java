package org.example.exceptions;

public class PlayerNotExistsException extends  TicTacToeException{

    public PlayerNotExistsException(String message) {
        super(message);
    }
}
