package levelThree;

public enum OperatorTypeLv3 {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');
    final char op;

    OperatorTypeLv3(char op) {
        this.op = op;
    }
    public char getOperator() {
        return op;
    }

    public static OperatorTypeLv3 getType(char op) {
        for (OperatorTypeLv3 o : OperatorTypeLv3.values()) {
            if (o.getOperator() == op) {
                return o;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자 입력");
    }
}