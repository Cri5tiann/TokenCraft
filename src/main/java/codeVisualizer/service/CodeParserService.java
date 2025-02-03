package codeVisualizer.service;

import codeVisualizer.dto.ParseResponse;
import lexer.Lexer;
import parser.Parser;
import utils.Node;
import org.springframework.stereotype.Service;
import java.io.StringReader;

@Service
public class CodeParserService {

    public ParseResponse parseCode(String sourceCode) {
        try {
            // Create lexer and parser
            Lexer lexer = new Lexer(new StringReader(sourceCode));
            Parser parser = new Parser(lexer);

            // Parse the code
            java_cup.runtime.Symbol parseResult = parser.parse();
            Node astRoot = (Node) parseResult.value;

            return new ParseResponse(astRoot, "Code parsed successfully");
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse code: " + e.getMessage(), e);
        }
    }
}