package ast.expr;

import ast.CodeVisitor;
import ast.data.Value;

public interface Expr {
    public Value accept(CodeVisitor v);
}
