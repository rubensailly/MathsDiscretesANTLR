package ast;

public enum OP {
    PLUS, MINUS, TIMES, DIVIDE;

    public static OP parseOP(String op) {
        return switch (op) {
            case "*" -> TIMES;
            case "/" -> DIVIDE;
            case "+" -> PLUS;
            case "-" -> MINUS;
            default          -> throw new IllegalArgumentException("Unexpected operator: " + op);
        };
    }
}
