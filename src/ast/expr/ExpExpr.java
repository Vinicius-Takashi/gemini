package ast.expr;

import ast.CodeVisitor;
import ast.data.Value;

public class ExpExpr implements Expr {
    public Expr e1, e2;

    public ExpExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public Value accept(CodeVisitor v) {
        return v.visit(this);
    }
}