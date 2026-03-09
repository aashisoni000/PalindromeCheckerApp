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

// UC11: Object-Oriented Palindrome Service
class PalindromeService {
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
        String clean = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return clean.equals(reversed.toString());
    }
}

// UC12: Strategy Pattern
interface PalindromeStrategy {
    boolean isValid(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return input.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    // UC9: Recursive Helper Method
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

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

        // UC10: Normalization
        String cleanInput = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("Normalized String: " + cleanInput);

        // UC13: Performance Comparison Logic
        System.out.println("\n--- Performance Results (nanoseconds) ---");

        // UC4: Two-Pointer Timing
        long startUC4 = System.nanoTime();
        char[] charArray = cleanInput.toCharArray();
        int left = 0, right = charArray.length - 1;
        boolean isPalindromeUC4 = true;
        while (left < right) {
            if (charArray[left] != charArray[right]) { isPalindromeUC4 = false; break; }
            left++; right--;
        }
        long endUC4 = System.nanoTime();
        System.out.println("UC4 (Two-Pointer): " + (endUC4 - startUC4) + " ns | Result: " + isPalindromeUC4);

        // UC5: Stack Timing
        long startUC5 = System.nanoTime();
        Stack<Character> stack = new Stack<>();
        for (char c : cleanInput.toCharArray()) stack.push(c);
        StringBuilder stackReversed = new StringBuilder();
        while (!stack.isEmpty()) stackReversed.append(stack.pop());
        boolean isPalindromeUC5 = cleanInput.equals(stackReversed.toString());
        long endUC5 = System.nanoTime();
        System.out.println("UC5 (Stack):       " + (endUC5 - startUC5) + " ns | Result: " + isPalindromeUC5);

        // UC7: Deque Timing
        long startUC7 = System.nanoTime();
        Deque<Character> dequeUC7 = new ArrayDeque<>();
        for (char c : cleanInput.toCharArray()) dequeUC7.addLast(c);
        boolean isPalindromeUC7 = true;
        while (dequeUC7.size() > 1) {
            if (!dequeUC7.removeFirst().equals(dequeUC7.removeLast())) { isPalindromeUC7 = false; break; }
        }
        long endUC7 = System.nanoTime();
        System.out.println("UC7 (Deque):       " + (endUC7 - startUC7) + " ns | Result: " + isPalindromeUC7);

        // UC9: Recursion Timing
        long startUC9 = System.nanoTime();
        boolean isPalindromeUC9 = isPalindromeRecursive(cleanInput, 0, cleanInput.length() - 1);
        long endUC9 = System.nanoTime();
        System.out.println("UC9 (Recursion):   " + (endUC9 - startUC9) + " ns | Result: " + isPalindromeUC9);

        // UC8: Linked List Timing
        long startUC8 = System.nanoTime();
        Node head = null, tail = null;
        for (char c : cleanInput.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) { head = newNode; tail = newNode; }
            else { tail.next = newNode; tail = newNode; }
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        Node prev = null, current = slow;
        while (current != null) {
            Node nextNode = current.next; current.next = prev; prev = current; current = nextNode;
        }
        Node leftSide = head, rightSide = prev;
        boolean isPalindromeUC8 = true;
        while (rightSide != null) {
            if (leftSide.data != rightSide.data) { isPalindromeUC8 = false; break; }
            leftSide = leftSide.next; rightSide = rightSide.next;
        }
        long endUC8 = System.nanoTime();
        System.out.println("UC8 (Linked List): " + (endUC8 - startUC8) + " ns | Result: " + isPalindromeUC8);

        // Final UI outputs
        System.out.println("========================================");
        System.out.println("Program finished.");
        scanner.close();
    }
}
