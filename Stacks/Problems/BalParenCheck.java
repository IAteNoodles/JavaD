package Stacks.Problems;
import Stacks.StackException;
import Stacks.Stack;
public class BalParenCheck {

    // The balanced function to check balanced parentheses
    public static boolean balanced(String inputString) throws StackException {
        if(inputString.length()==0)
        {
            return false;
        }
        Stack inputStack = new Stack();
        if(inputString.charAt(0)==')'||inputString.charAt(0)=='}'||inputString.charAt(0)==']')
        {
            return false;
        }
        inputStack.push(inputString.charAt(0));  // Push the first character onto the stack
        int i = 1;
        while (i < inputString.length()) {
            char compare = ' ';  // Placeholder to compare with closing bracket

            // Determine the corresponding closing bracket
            char top = (char)inputStack.peek();
            if (top == '(') {
                if(inputString.charAt(i)=='}'||inputString.charAt(i)==']')
                {
                    return false;
                }
                compare = ')';
            } else if (top == '[') {
                if(inputString.charAt(i)=='}'||inputString.charAt(i)==')')
                {
                    return false;
                }
                compare = ']';
            } else if (top ==  '{') {
                if(inputString.charAt(i)=='('||inputString.charAt(i)==']')
                {
                    return false;
                }
                compare = '}';
            }
            // If the current character matches the expected closing bracket, pop
            if (inputString.charAt(i) == compare) {
                inputStack.pop();
            } else {
                // Otherwise, push the character onto the stack
                inputStack.push(inputString.charAt(i));
            }
            i++;
        }

        // If the stack is empty, the parentheses are balanced
        return inputStack.isEmpty();
    }

    public static void main(String[] args) throws StackException {
        // Test cases for balanced parentheses check
        String test1 = "{[()()]}"; // Balanced
        String test2 = "{[(])}";   // Not balanced
        String test3 = "((()))";   // Balanced
        String test4 = "([{}])";   // Balanced
        String test5 = "{[}";      // Not balanced

        // Calling the balanced function with different inputs
        System.out.println(balanced(test1) ? "Yes" : "No"); // Output: Yes
        System.out.println(balanced(test2) ? "Yes" : "No"); // Output: No
        System.out.println(balanced(test3) ? "Yes" : "No"); // Output: Yes
        System.out.println(balanced(test4) ? "Yes" : "No"); // Output: Yes
        System.out.println(balanced(test5) ? "Yes" : "No"); // Output: No
    }
}
