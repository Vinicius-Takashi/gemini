package ast;

import ast.expr.CosExpr;
import ast.expr.DivExpr;
import ast.expr.IdExpr;
import ast.expr.ModExpr;
import ast.expr.ValueConstExpr;
import ast.expr.ExpExpr;
import ast.expr.MulExpr;
import ast.expr.NegatedExpr;
import ast.expr.PiExpr;
import ast.expr.SinExpr;
import ast.expr.SubExpr;
import ast.expr.SumExpr;
import ast.data.Type;
import ast.data.Value;

public class Interpreter implements CodeVisitor {

    @Override
    public Value visit(SumExpr e) {
        Value v1 = e.e1.accept(this);
        Value v2 = e.e2.accept(this);
        if ((v1.type == v2.type) && (v1.type == Type.DBL)) {
            Double d1 = (Double) v1.data;
            Double d2 = (Double) v2.data;
            Double r = d1 + d2;
            return new Value(Type.DBL, r);
        } else {
            throw new Error("Só é possível somar valores " +
                    "de mesmo tipo!");
        }
    }

    @Override
    public Value visit(SubExpr e) {
        Value v1 = e.e1.accept(this);
        Value v2 = e.e2.accept(this);
        if ((v1.type == v2.type) && (v1.type == Type.DBL)) {
            Double d1 = (Double) v1.data;
            Double d2 = (Double) v2.data;
            Double r = d1 - d2;
            return new Value(Type.DBL, r);
        } else {
            throw new Error("Só é possível subtrair números!");
        }
    }

    @Override
    public Value visit(MulExpr e) {
        Value v1 = e.e1.accept(this);
        Value v2 = e.e2.accept(this);
        if ((v1.type == v2.type) && (v1.type == Type.DBL)) {
            Double d1 = (Double) v1.data;
            Double d2 = (Double) v2.data;
            Double r = d1 * d2;
            return new Value(Type.DBL, r);
        } else {
            throw new Error("Só é possível multiplicar números!");
        }
    }

    @Override
    public Value visit(DivExpr e) {
        Value v1 = e.e1.accept(this);
        Value v2 = e.e2.accept(this);
        if ((v1.type == v2.type) && (v1.type == Type.DBL)) {
            Double d1 = (Double) v1.data;
            Double d2 = (Double) v2.data;
            if (d2 == 0.0) {
                throw new Error("Erro: divisão por zero!");
            }
            Double r = d1 / d2;
            return new Value(Type.DBL, r);
        } else {
            throw new Error("Só é possível dividir números!");
        }
    }

    @Override
    public Value visit(IdExpr e) {
        return e.value;
    }

    @Override
    public Value visit(ValueConstExpr e) {
        return e.value;
    }

    @Override
    public Value visit(NegatedExpr e) {
        Value value = e.expr.accept(this);
        if (value.type == Type.DBL) {
            Double d = -(Double) value.data;
            return new Value(Type.DBL, d);
        } else {
            throw new Error("Inversão de sinal é somente para " +
                    "números!");
        }
    }

    @Override
    public Value visit(ModExpr e) {
        Value v1 = e.e1.accept(this);
        Value v2 = e.e2.accept(this);
        if ((v1.type == v2.type) && (v1.type == Type.DBL)) {
            Double d1 = (Double) v1.data;
            Double d2 = (Double) v2.data;
            if (d2 == 0.0) {
                throw new Error("Erro: divisão por zero!");
            }
            Double r = d1 % d2;
            return new Value(Type.DBL, r);
        } else {
            throw new Error("Só é possível calcular o " +
                    "resto da divisão entre números!");
        }
    }

    @Override
    public Value visit(ExpExpr e) {
        Value v1 = e.e1.accept(this);
        Value v2 = e.e2.accept(this);
        if ((v1.type == v2.type) && (v1.type == Type.DBL)) {
            Double d1 = (Double) v1.data;
            Double d2 = (Double) v2.data;
            Double r = Math.pow(d1, d2);
            return new Value(Type.DBL, r);
        } else {
            throw new Error("Só é possível exponenciar números!");
        }
    }

    @Override
    public Value visit(SinExpr e) {
        Value value = e.expr.accept(this);
        if (value.type == Type.DBL) {
            Double d = Math.sin((Double) value.data);
            return new Value(Type.DBL, d);
        } else {
            throw new Error("Seno é somente para números!");
        }
    }

    @Override
    public Value visit(CosExpr e) {
        Value value = e.expr.accept(this);
        if (value.type == Type.DBL) {
            Double d = Math.cos((Double) value.data);
            return new Value(Type.DBL, d);
        } else {
            throw new Error("Coseno de é somente para números!");
        }
    }

    @Override
    public Value visit(PiExpr e) {
        return e.value;
    }
}
