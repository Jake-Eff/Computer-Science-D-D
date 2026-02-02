public class ArithmeticTester {
    public static void main(String[] args) {
        System.out.println(Arithmetic.evaluate("3 + 4"));
        System.out.println(Arithmetic.evaluate("3 + 4 * 2"));
        System.out.println(Arithmetic.evaluate("( 3 + 4 ) * 2"));
        System.out.println(Arithmetic.evaluate("( 2 + ( ( 3 * 5 ) / ( 11 - 6 ) ) )"));
        System.out.println(Arithmetic.operate(3, 4, "+"));
        System.out.println(Arithmetic.evaluateStout("2 3 5 * 11 6 - / +"));
        System.out.println(Arithmetic.convertClassicToStout("( 2 + ( ( 3 * 5 ) / ( 11 - 6 ) ) )").trim());
    }
}
