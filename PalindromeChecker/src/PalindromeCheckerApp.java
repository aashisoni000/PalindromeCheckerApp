public class PalindromeCheckerApp {
    public static void main(String[] args){
        //UC1
        System.out.println("welcome to palindrome management system");
        System.out.println("version : 1.0");
        System.out.println("System initialized Successfully done");

        String input = "madam";
        String reversed = "";
        // UC2
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        if (input.equals(reversed)) {
            System.out.println("The hardcoded string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The hardcoded string \"" + input + "\" is NOT a palindrome.");
        }

        System.out.println("Program finished.");
    }
}
