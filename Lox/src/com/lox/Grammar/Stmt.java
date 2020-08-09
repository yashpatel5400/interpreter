package com.lox.Grammar;

import java.util.List;

public abstract class Stmt {
    public interface Visitor<R> {
        R visitBlockStmt(Block statement);
        R visitExpressionStmt(Expression statement);
        R visitIfStmt(If statement);
        R visitPrintStmt(Print statement);
        R visitVarStmt(Var statement);
        R visitWhileStmt(While statement);
    }
    public static class Block extends Stmt {
        public Block(List<Stmt> statements) {
            this.statements = statements;
        }

        public final List<Stmt> statements;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitBlockStmt(this);
        }
    }
    public static class Expression extends Stmt {
        public Expression(Expr expression) {
            this.expression = expression;
        }

        public final Expr expression;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitExpressionStmt(this);
        }
    }
    public static class If extends Stmt {
        public If(Expr condition, Stmt thenBranch, Stmt elseBranch) {
            this.condition = condition;
            this.thenBranch = thenBranch;
            this.elseBranch = elseBranch;
        }

        public final Expr condition;
        public final Stmt thenBranch;
        public final Stmt elseBranch;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitIfStmt(this);
        }
    }
    public static class Print extends Stmt {
        public Print(Expr expression) {
            this.expression = expression;
        }

        public final Expr expression;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitPrintStmt(this);
        }
    }
    public static class Var extends Stmt {
        public Var(Token name, Expr initializer) {
            this.name = name;
            this.initializer = initializer;
        }

        public final Token name;
        public final Expr initializer;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitVarStmt(this);
        }
    }
    public static class While extends Stmt {
        public While(Expr condition, Stmt body) {
            this.condition = condition;
            this.body = body;
        }

        public final Expr condition;
        public final Stmt body;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitWhileStmt(this);
        }
    }

    public abstract <R> R accept(Visitor<R> visitor);
}
