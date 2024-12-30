package lexer;

import java_cup.runtime.*;
import java.io.*;

public class TestParser {
    public static void main(String[] args) throws Exception {
        String inputText = "function main() { return 42; }";  // Your test input as a string

        // Create a Lexer that reads from the string
        Lexer lexer = new Lexer(new StringReader(inputText));

        // Create a Parser and parse the input
        Parser p = new Parser(lexer);
        Symbol result = p.parse();

        // Cast the result to Node and print the output
        Node root = (Node) result.value;
        System.out.println(root.toString());
    }
}