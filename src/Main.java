import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Type height, length, symbol as 'h l s' pattern");
            printCharRectangle(scanner.nextInt(), scanner.nextInt(), validateCharToString(scanner.next()));

            System.out.println("\nChoose the sequence number for Pell numbers: ");
            System.out.println(pellNumbers(scanner.nextInt()));

            System.out.println("\nMultiplication Table:");
            printMultiplicationTable();

            System.out.println("\nThe guess game.");
            playGuessGame(1000);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static void printCharRectangle(int n, int m, char c) {
        while (n-- > 0) {
            for (int i = m; i > 0; i--) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }


    public static long pellNumbers(int n) {
        return Math.round((Math.pow((1 + Math.sqrt(2)), n) - Math.pow((1 - Math.sqrt(2)), n)) / (2 * Math.sqrt(2)));
    }

    public static void printMultiplicationTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                int result = i * j;
                System.out.print(j + " * " + i + " = " + result + (result > 9 ? "   " : "    "));
            }
            System.out.println();
        }
    }

    public static void playGuessGame(int range) {
        Scanner scanner = new Scanner(System.in);
        int guessed = new Random().nextInt(range) + 1;
        int attempts = (int) Math.ceil(Math.log(range) / Math.log(2));
        System.out.println("Try to guess the number from 1 to " + range + ". You have " + attempts + " attempts");
        Set<Integer> guessSet = new HashSet<>();
        int guess;
        while (attempts > 0) {
            System.out.print("Make a guess: ");
            try {
                guess = scanner.nextInt();
                if (guess == guessed) {
                    System.out.println("You won!");
                    return;
                } else if (guessSet.contains(guess)) {
                    System.out.println("You've already tried this number!");
                } else {
                    System.out.println("No! It's " + (guessed > guess ? "bigger! " : "smaller! ") + --attempts + " attempts left.");
                    guessSet.add(guess);
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input!");
            }
        }
        System.out.println("You lost! Answer is " + guessed);
    }

    public static char validateCharToString(String str) {
        if (str.length() != 1) throw new RuntimeException("Cant convert String to char");
        else return str.charAt(0);
    }
}
