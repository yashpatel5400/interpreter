package com.lox.Grammar;

import java.util.List;

public abstract class Expr {
    public interface Visitor<R> {
        R visitAssignExpr(Assign statement);
        R visitBinaryExpr(Binary statement);
        R visitGroupingExpr(Grouping statement);
        R visitLiteralExpr(Literal statement);
        R visitLogicalExpr(Logical statement);
        R visitUnaryExpr(Unary statement);
        R visitVariableExpr(Variable statement);
    }
    public static class Assign extends Expr {
        public Assign(Token name, Expr value) {
            this.name = name;
            this.value = value;
        }

        public final Token name;
        public final Expr value;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitAssignExpr(this);
        }
    }
    public static class Binary extends Expr {
        public Binary(Expr left, Token operator, Expr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        public final Expr left;
        public final Token operator;
        public final Expr right;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitBinaryExpr(this);
        }
    }
    public static class Grouping extends Expr {
        public Grouping(Expr expression) {
            this.expression = expression;
        }

        public final Expr expression;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitGroupingExpr(this);
        }
    }
    public static class Literal extends Expr {
        public Literal(Object value) {
            this.value = value;
        }

        public final Object value;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitLiteralExpr(this);
        }
    }
    public static class Logical extends Expr {
        public Logical(Expr left, Token operator, Expr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        public final Expr left;
        public final Token operator;
        public final Expr right;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitLogicalExpr(this);
        }
    }
    public static class Unary extends Expr {
        public Unary(Token operator, Expr right) {
            this.operator = operator;
            this.right = right;
        }

        public final Token operator;
        public final Expr right;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitUnaryExpr(this);
        }
    }
    public static class Variable extends Expr {
        public Variable(Token name) {
            this.name = name;
        }

        public final Token name;
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitVariableExpr(this);
        }
    }

    public abstract <R> R accept(Visitor<R> visitor);
}
