import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        boolean hasGuessedCorrectly = false;

        Scanner scanner = new Scanner(System.in);

        while (!hasGuessedCorrectly) {
            System.out.print("1から100の間の数値を入力してください: ");
            int userGuess = scanner.nextInt();
            numberOfTries++;

            if (userGuess < numberToGuess) {
                System.out.println("小さすぎます。");
            } else if (userGuess > numberToGuess) {
                System.out.println("大きすぎます。");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("正解です！" + numberOfTries + " 回目で当たりました。");
            }
        }
    }
}
