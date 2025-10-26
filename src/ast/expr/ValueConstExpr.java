package ast.expr;

import ast.CodeVisitor;
import ast.data.Value;

public class ValueConstExpr implements Expr {
    public Value value;

    public ValueConstExpr(Value value) {
        this.value = value;
    }

    @Override
    public Value accept(CodeVisitor v) {
        return v.visit(this);
    }

}
