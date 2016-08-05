public class InterpreterTest {
    public static void main(String[] args) {
        // 计算 9 + 2 - 8
        int result = new ExpressionMinus().interpret(
                (new InterpreterContext(new ExpressionPlus().interpret(
                        new InterpreterContext(9, 2)), 8)));
        System.out.println(result);
    }
}
