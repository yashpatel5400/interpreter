package com.craftinginterpreters.lox;

import java.util.List;

abstract class Stmt {
    interface Visitor<R> {
    R visitBlockStmt(Block block);
    R visitExpressionStmt(Expression expression);
    R visitPrintStmt(Print print);
    R visitVarStmt(Var var);
    }
  static class Block extends Stmt {
    Block(List<Stmt> statements) {
      this.statements = statements;
    }

    final List<Stmt> statements;
@Override
<R> R accept(Visitor<R> visitor) {
    return visitor.visitBlockStmt(this);
}
  }
  static class Expression extends Stmt {
    Expression(Expr expression) {
      this.expression = expression;
    }

    final Expr expression;
@Override
<R> R accept(Visitor<R> visitor) {
    return visitor.visitExpressionStmt(this);
}
  }
  static class Print extends Stmt {
    Print(Expr expression) {
      this.expression = expression;
    }

    final Expr expression;
@Override
<R> R accept(Visitor<R> visitor) {
    return visitor.visitPrintStmt(this);
}
  }
  static class Var extends Stmt {
    Var(Token name, Expr initializer) {
      this.name = name;
      this.initializer = initializer;
    }

    final Token name;
    final Expr initializer;
@Override
<R> R accept(Visitor<R> visitor) {
    return visitor.visitVarStmt(this);
}
  }

    abstract <R> R accept(Visitor<R> visitor);
}
