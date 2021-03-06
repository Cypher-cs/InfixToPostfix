/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-02-2021
Time: 10:29
File: InfixToPostfix.java

*/
package infix.postfix;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix {
    public String infixPostfix(String infix) {
        String postfix = "";

        Deque<Character> stack = new ArrayDeque<Character>();
        // step 1
        stack.push('(');
        infix = infix.concat(String.valueOf(')')); //or  infix + ')';
        //step 2
        for (int i = 0; i < infix.length(); i++) {
            char element = infix.charAt(i);
            // step 3
            if (Character.isAlphabetic(element) || Character.isDigit(element)) {
                postfix = postfix + element;
            }
            // step 4
            else if (element == '(') {
                stack.push(element);
            }
            // step 5.a
            else if (isOperator(element)) {
                while(!stack.isEmpty()) {
                    if (precedence(stack.peek()) >= precedence(element)) {
                        // leaving space for associativity
                         postfix = postfix + stack.pop();
                    }
                    // step 5.b
                    else {
                        stack.push(element);
                        break;
                    }
                }
            }
            // step 6
            else if (element == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix = postfix + stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        return postfix;
    }

    private boolean isOperator(char elementFromInfix) {
        return switch (elementFromInfix) {
            case '^', '/', '*', '+', '-' -> true;
            default -> false;
        };
    }

    private int precedence(char operator) {
        int response;
        response = switch (operator) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };

        return response;
    }
}