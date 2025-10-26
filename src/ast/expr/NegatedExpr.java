package ast.expr;

import ast.CodeVisitor;
import ast.data.Value;

public class NegatedExpr implements Expr{
    public Expr expr;

    public NegatedExpr(Expr e) {
        this.expr = e;
    }

    @Override
    public Value accept(CodeVisitor v) {
        return v.visit(this);
    }
}
