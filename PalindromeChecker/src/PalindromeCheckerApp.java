import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        // UC1: Welcome Message & App Details
        System.out.println("========================================");
        System.out.println("Welcome to Palindrome Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized Successfully done");
        System.out.println("========================================");

        // UC2: User Input (Replacing the hardcoded "madam")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String input = scanner.nextLine();

        // UC3: Palindrome Check Using String Reverse
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        System.out.println("Reversed string: " + reversed);
        if (input.equalsIgnoreCase(reversed)) {
            System.out.println("The string \"" + input + "\" IS a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
        System.out.println("Program finished.");
        scanner.close();
    }
}
