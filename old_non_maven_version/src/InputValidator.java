import  java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
        return number;
    }
    public static String getStringInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }
        return input;
    }
}