import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws CalculatorException {

        int operand1;
        char operator;
        int operand2;

        Scanner scanner = new Scanner(System.in);
        try {
            operand1 = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new CalculatorException("Первый операнд должен быть целым числом в размерности int");
        }
        try {
            operator = scanner.next().charAt(0);
        } catch (InputMismatchException e) {
            throw new CalculatorException("Операция должна быть арифметическим оператором: +, -, *, /");
        }

        try {
            operand2 = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new CalculatorException("Второй операнд должен быть целым числом в размерности int");
        }
        scanner.close();
        calc(operand1, operator, operand2);
    }

    public static void calc(int operand1, char operator, int operand2) throws CalculatorException {

        System.out.println(switch (operator) {
                    case '+' -> String.valueOf(operand1 + operand2);
                    case '-' -> String.valueOf(operand1 - operand2);
                    case '*' -> String.valueOf(operand1 * operand2);
                    case '/' -> checkAndReturnDivision(operand1, operand2);
                    default -> null;
                }
        );
    }

    private static String checkAndReturnDivision(int operand1, int operand2) throws CalculatorException {
        try {
            return String.valueOf(operand1 / operand2);
        } catch (ArithmeticException e) {
            throw new CalculatorException("Деление на 0");
        }
    }
}
