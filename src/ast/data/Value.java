package ast.data;

public class Value {
    public Type type;
    public Object data;

    public Value(Type type, Object data) {
        this.type = type;
        this.data = data;
    }

}
