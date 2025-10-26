package ast.expr;

import ast.CodeVisitor;
import ast.data.Value;

public class IdExpr implements Expr {
    public String name;
    public Value value;

    public IdExpr(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Value accept(CodeVisitor v) {
        return v.visit(this);
    }
}
