import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1番目の数値を入力してください: ");
        double num1 = scanner.nextDouble();

        System.out.print("2番目の数値を入力してください: ");
        double num2 = scanner.nextDouble();

        System.out.print("演算子を入力してください (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("ゼロで除算することはできません。");
                    return;
                }
                break;
            default:
                System.out.println("無効な演算子です。");
                return;
        }

        System.out.println("結果: " + result);
    }
}
