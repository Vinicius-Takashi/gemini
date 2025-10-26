package ast;

import ast.expr.SumExpr;
import ast.expr.MulExpr;
import ast.expr.SubExpr;
import ast.expr.CosExpr;
import ast.expr.DivExpr;
import ast.expr.IdExpr;
import ast.expr.ValueConstExpr;
import ast.expr.NegatedExpr;
import ast.expr.PiExpr;
import ast.expr.ModExpr;
import ast.expr.ExpExpr;
import ast.expr.SinExpr;
import ast.data.Value;

public interface CodeVisitor {
    public Value visit(SumExpr e);

    public Value visit(SubExpr e);

    public Value visit(MulExpr e);

    public Value visit(DivExpr e);

    public Value visit(IdExpr e);

    public Value visit(ValueConstExpr e);

    public Value visit(NegatedExpr e);

    public Value visit(ModExpr e);

    public Value visit(ExpExpr e);

    public Value visit(SinExpr e);

    public Value visit(CosExpr e);

    public Value visit(PiExpr e);
}
