import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNumber = scanner.nextDouble();

        System.out.println("Choose an operation: +, -, *, /");
        System.out.print("Enter your choice: ");
        char operation = scanner.next().charAt(0);

        double result;

        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = firstNumber - secondNumber;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = firstNumber * secondNumber;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    result = firstNumber / secondNumber;
                    System.out.println("Result: " + result);
                }
                break;
            default:
                System.out.println("Invalid operation selected.");
        }

        scanner.close();
    }
}
