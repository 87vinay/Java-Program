import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Command Line Calculator!");
        System.out.println("Enter an operation (+, -, *, /): ");
        String operation = scanner.nextLine();

        System.out.println("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = calculate(operation, num1, num2);

        if (Double.isNaN(result)) {
            System.out.println("Error: Invalid operation or division by zero");
        } else {
            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    public static double calculate(String operation, double num1, double num2) {
        switch (operation) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            default:
                return Double.NaN; 
        }
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return Double.NaN; 
        }
    }
}
