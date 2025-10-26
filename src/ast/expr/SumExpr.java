package ast.expr;

import ast.data.Value;
import ast.CodeVisitor;

public class SumExpr implements Expr {
    public Expr e1, e2;

    public SumExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public Value accept(CodeVisitor v) {
        return v.visit(this);
    }

}
