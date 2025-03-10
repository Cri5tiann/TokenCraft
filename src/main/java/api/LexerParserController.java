package api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.LexerParserService;
import utils.Node;

@RestController
public class LexerParserController {

    @GetMapping("/parse")
    public String parseFile() {
        String filePath = "E:\\cod\\TokenCraft\\src\\main\\resources\\FibonacciNumbers.plt";
        LexerParserService lexerParserService = new LexerParserService(filePath);

        try {
            Node root = lexerParserService.parseFile();
            return root.toString();  // Return the tree representation
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
