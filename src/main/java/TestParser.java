import java_cup.runtime.Symbol;
import lexer.Lexer;
import utils.Node;
import parser.Parser;

import java.io.FileReader;
import java.io.IOException;

public class TestParser {
    public static void main(String[] args) {
        // Path to your .plt file
        String filePath = "E:\\cod\\demo\\Lexer-Parser-PLT\\src\\main\\resources\\FibonacciNumbers.plt";

        try {
            // Create a FileReader to read the .plt file
            FileReader fileReader = new FileReader(filePath);

            // Create a Lexer that reads from the file
            Lexer lexer = new Lexer(fileReader);

            // Create a Parser and parse the input
            Parser parser = new Parser(lexer);
            Symbol result = parser.parse();

            // Cast the result to Node and print the output
            Node root = (Node) result.value;
            System.out.println(root.toString());

            // Close the FileReader
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Parsing error: " + e.getMessage());
        }
    }
}
