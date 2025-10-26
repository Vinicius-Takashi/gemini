package ast.expr;

import ast.CodeVisitor;
import ast.data.Value;

public class SinExpr implements Expr{
    public Expr expr;

    public SinExpr(Expr e) {
        this.expr = e;
    }

    @Override
    public Value accept(CodeVisitor v) {
        return v.visit(this);
    }
}