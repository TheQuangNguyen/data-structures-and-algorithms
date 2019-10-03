package utilities;

import stacksandqueues.Stack;

public class MultiBracketValidation {

    public static boolean multiBracketValidation(String input) {
        // Stack that holds only left brackets to test for matching right brackets
        Stack<Character> bracketStack = new Stack<>();

        // Go through every character with for loop
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            // if the character is a left bracket, push it in the stack
            if (character == '(' || character == '[' || character == '{') {
                bracketStack.push(character);
            } else {
                // check if the character is a right bracket. Then check if the top of the stack
                // is the matching left bracket. If not then return false right away.
                // If it is then pop the stack and keep moving on
                if (character == ')') {
                    if (!bracketStack.isEmpty()) {
                        if (bracketStack.peek() == '(') {
                            bracketStack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (character == ']') {
                    if (!bracketStack.isEmpty()) {
                        if (bracketStack.peek() == '[') {
                            bracketStack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (character == '}') {
                    if (!bracketStack.isEmpty()) {
                        if (bracketStack.peek() == '{') {
                            bracketStack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        // If the stack still have things in it, that means there are unmatched brackets so return false.
        // Otherwise all brackets were matched so return true
        return bracketStack.isEmpty();
    }
}
