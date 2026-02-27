import java.util.Scanner;
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

        // UC3: Palindrome Check Using String Reverse (Manual Reversal)
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        System.out.println("Reversed string (UC3): " + reversed);

        // UC4: Character Array Based Check (Two-Pointer Technique)
        char[] charArray = input.toLowerCase().toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" IS a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
        System.out.println("Program finished.");
        scanner.close();
    }
}
