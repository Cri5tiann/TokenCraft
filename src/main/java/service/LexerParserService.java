package service;

import utils.Node;
import java.io.FileReader;
import java.io.IOException;
import lexer.Lexer;
import parser.Parser;
import java_cup.runtime.Symbol;

public class LexerParserService {

    private String filePath;

    public LexerParserService(String filePath) {
        this.filePath = filePath;
    }

    public Node parseFile() throws IOException, Exception {
        // Create a FileReader to read the .plt file
        FileReader fileReader = new FileReader(filePath);

        // Create a Lexer that reads from the file
        Lexer lexer = new Lexer(fileReader);

        // Create a Parser and parse the input
        Parser parser = new Parser(lexer);
        Symbol result = parser.parse();

        // Cast the result to Node
        Node root = (Node) result.value;

        // Close the FileReader
        fileReader.close();

        return root;
    }
}
