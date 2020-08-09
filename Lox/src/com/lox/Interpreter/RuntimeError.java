package com.lox.Interpreter;

import com.lox.Grammar.Token;

public class RuntimeError extends RuntimeException {
    public final Token token;

    RuntimeError(Token token, String message) {
        super(message);
        this.token = token;
    }
}
