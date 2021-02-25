/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-02-2021
Time: 10:29
File: InfixToPostfix.java

*/
package infix.postfix;

public class InfixToPostfix {
    public String infixPostfix(String infix) {
        String postfix = "";

        return postfix;
    }
    private boolean isOperator(char elementFromInfix) {
        boolean response = switch (elementFromInfix) {
            case '^', '/', '*', '+', '-' -> true;
            default -> false;
        };

        return response;
    }
    private int precedence(char operator) {
        int response = 0;
        response = switch (operator) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };

        return response;
    }
}