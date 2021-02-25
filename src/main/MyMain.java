/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-02-2021
Time: 11:51
File: MyMain.java 

*/
package main;

import infix.postfix.InfixToPostfix;

public class MyMain {
    public static void main(String[] args) {
        InfixToPostfix converter = new InfixToPostfix();
        String infix = "A+(B*C-(D/E^F)*G)*H";
        String postfix = converter.infixPostfix(infix);
        System.out.println("postfix -> "  + postfix);
    }
}