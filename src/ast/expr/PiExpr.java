package ast.expr;

import ast.CodeVisitor;
import ast.data.Value;

public class PiExpr implements Expr {
    public Value value;

    public PiExpr(Value value) {
        this.value = value;
    }

    @Override
    public Value accept(CodeVisitor v) {
        return v.visit(this);
    }
}
