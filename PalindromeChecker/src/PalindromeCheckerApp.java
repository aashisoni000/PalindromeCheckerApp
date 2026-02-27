import java.util.Scanner;
import java.util.Stack; // Required for UC5

public class PalindromeCheckerApp {
    public static void main(String[] args){
        // UC1: Welcome Message & App Details
        System.out.println("========================================");
        System.out.println("Welcome to Palindrome Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized Successfully done");
        System.out.println("========================================");

        // UC2: User Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String input = scanner.nextLine();
        String cleanInput = input.toLowerCase();

        // UC3: Palindrome Check Using String Reverse (Manual Reversal)
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        System.out.println("Reversed string (UC3): " + reversed);

        // UC4: Character Array Based Check (Two-Pointer Technique)
        char[] charArray = cleanInput.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        boolean isPalindromeUC4 = true;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                isPalindromeUC4 = false;
                break;
            }
            left++;
            right--;
        }

        // UC5: Stack-Based Palindrome Checker (LIFO Principle)
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }

        // Pop characters to create a reversed version
        StringBuilder stackReversed = new StringBuilder();
        while (!stack.isEmpty()) {
            stackReversed.append(stack.pop());
        }

        // Compare and Final Output
        if (cleanInput.equals(stackReversed.toString())) {
            System.out.println("The string \"" + input + "\" IS a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        System.out.println("Program finished.");
        scanner.close();
    }
}
