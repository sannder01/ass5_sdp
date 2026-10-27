public class Main {
    public static void main(String[] args) {
        double a = 10;
        double b = 5;

        Calculator calculator = new Calculator(new AddStrategy());
        System.out.println(a + " + " + b + " = " + calculator.calculate(a, b));

        calculator.setStrategy(new SubtractStrategy());
        System.out.println(a + " - " + b + " = " + calculator.calculate(a, b));

        calculator.setStrategy(new MultiplyStrategy());
        System.out.println(a + " * " + b + " = " + calculator.calculate(a, b));

        calculator.setStrategy(new DivideStrategy());
        System.out.println(a + " / " + b + " = " + calculator.calculate(a, b));
    }
}
