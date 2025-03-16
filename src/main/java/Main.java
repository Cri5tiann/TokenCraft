import java_cup.runtime.Symbol;
import lexer.Lexer;
import parser.Parser;
import utils.Node;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the name of the file
        System.out.print("Enter the name of the file (e.g., FibonacciNumbers.plt): ");
        String fileName = scanner.nextLine().trim();

        String filePath = "src/main/resources/" + fileName  + ".plt"; // Path to the resources folder

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