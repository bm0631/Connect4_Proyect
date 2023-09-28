package model;

import types.Token;

public class Player {
    private Token token;

    public Player(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return this.token;
    }
}
