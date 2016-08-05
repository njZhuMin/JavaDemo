public class ExpressionMinus implements Expression {
    @Override
    public int interpret(InterpreterContext context) {
        return context.getNum1() - context.getNum2();
    }
}
