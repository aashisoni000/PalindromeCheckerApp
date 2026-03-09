import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

// Helper class for UC8
class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; }
}

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

        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }

        StringBuilder stackReversed = new StringBuilder();
        while (!stack.isEmpty()) {
            stackReversed.append(stack.pop());
        }

        if (cleanInput.equals(stackReversed.toString())) {
            System.out.println("The string \"" + input + "\" IS a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        // UC6 : Queue + Stack Based Palindrome Check
        Queue<Character> queueUC6 = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        for (char c : cleanInput.toCharArray()) {
            queueUC6.add(c);
            stackUC6.push(c);
        }
        boolean isPalindromeUC6 = true;

        while (!queueUC6.isEmpty()) {
            if (!queueUC6.remove().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }
        System.out.println("UC6 (Queue + Stack) Result: " + (isPalindromeUC6 ? "IS a palindrome" : "is NOT a palindrome"));

        // UC7: Deque-Based Optimized Palindrome Checker
        Deque<Character> dequeUC7 = new ArrayDeque<>();
        for (char c : cleanInput.toCharArray()) {
            dequeUC7.addLast(c);
        }

        boolean isPalindromeUC7 = true;
        while (dequeUC7.size() > 1) {
            if (!dequeUC7.removeFirst().equals(dequeUC7.removeLast())) {
                isPalindromeUC7 = false;
                break;
            }
        }
        System.out.println("UC7 (Deque-Based) Result: " + (isPalindromeUC7 ? "IS a palindrome" : "is NOT a palindrome"));

        // UC8: Linked List Based Palindrome Checker
        Node head = null, tail = null;
        for (char c : cleanInput.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) { head = newNode; tail = newNode; }
            else { tail.next = newNode; tail = newNode; }
        }

        // Fast and Slow pointer to find middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null, current = slow;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Compare halves
        Node leftSide = head, rightSide = prev;
        boolean isPalindromeUC8 = true;
        while (rightSide != null) {
            if (leftSide.data != rightSide.data) {
                isPalindromeUC8 = false;
                break;
            }
            leftSide = leftSide.next;
            rightSide = rightSide.next;
        }
        System.out.println("UC8 (Linked List) Result: " + (isPalindromeUC8 ? "IS a palindrome" : "is NOT a palindrome"));

        System.out.println("Program finished.");
        scanner.close();
    }
}
